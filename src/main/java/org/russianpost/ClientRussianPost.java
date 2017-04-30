package org.russianpost;

import org.russianpost.operationhistory.GetOperationHistory;
import org.russianpost.operationhistory.ObjectFactory;
import org.russianpost.operationhistory.data.AuthorizationHeader;
import org.russianpost.operationhistory.data.OperationHistoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.MalformedURLException;
import java.util.List;

@Configuration
@PropertySource(value = {"classpath:russianpost.properties"})
public class ClientRussianPost {
    @Autowired
    private Environment environment;

    public ClientRussianPost(){
    }

    public List<String> operationhistory (String barcode) throws MalformedURLException {

        ObjectFactory objectFactory = new ObjectFactory();

        GetOperationHistory operationHistory = objectFactory.createGetOperationHistory();

        AuthorizationHeader authorizationHeader = new AuthorizationHeader();
        authorizationHeader.setLogin(environment.getProperty("soap.russianpost.login"));
        authorizationHeader.setPassword(environment.getProperty("soap.russianpost.password"));
        operationHistory.setAuthorizationHeader(authorizationHeader);

        OperationHistoryRequest operationHistoryRequest = new OperationHistoryRequest();
        operationHistoryRequest.setBarcode(barcode);
        operationHistoryRequest.setLanguage(environment.getProperty("soap.russianpost.language"));
        operationHistoryRequest.setMessageType(Integer.parseInt(environment.getProperty("soap.russianpost.messageType")));
        operationHistory.setOperationHistoryRequest(operationHistoryRequest);

        return null;
    }

    public String result(String barcodestring) {
        String res = "N/A";
        String url = "https://tracking.russianpost.ru/rtm34";
        SOAPConnectionFactory soapConnFactory;
        SOAPConnection connection = null;
        try {
            //Cоздаем соединение
            soapConnFactory = SOAPConnectionFactory.newInstance();
            connection = soapConnFactory.createConnection();

            //Cоздаем сообщение
            MessageFactory messageFactory = MessageFactory.newInstance("SOAP 1.2 Protocol");
            SOAPMessage message = messageFactory.createMessage();

            //Создаем объекты, представляющие различные компоненты сообщения
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            SOAPBody body = envelope.getBody();
            envelope.addNamespaceDeclaration("soap", "http://www.w3.org/2003/05/soap-envelope");
            envelope.addNamespaceDeclaration("oper", "http://russianpost.org/operationhistory");
            envelope.addNamespaceDeclaration("data", "http://russianpost.org/operationhistory/data");
            envelope.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
            SOAPElement operElement = body.addChildElement("getOperationHistory", "oper");
            SOAPElement dataElement = operElement.addChildElement("OperationHistoryRequest", "data");
            SOAPElement barcode = dataElement.addChildElement("Barcode", "data");
            SOAPElement messageType = dataElement.addChildElement("MessageType", "data");
            SOAPElement language = dataElement.addChildElement("Language", "data");
            SOAPElement dataAuth = operElement.addChildElement("AuthorizationHeader", "data");
            SOAPFactory sf = SOAPFactory.newInstance();
            Name must = sf.createName("mustUnderstand", "soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
            dataAuth.addAttribute(must, "1");
            SOAPElement login = dataAuth.addChildElement("login", "data");
            SOAPElement password = dataAuth.addChildElement("password", "data");

            //Заполняем значения
            barcode.addTextNode(barcodestring);
            messageType.addTextNode(environment.getProperty("soap.russianpost.messageType"));
            language.addTextNode(environment.getProperty("soap.russianpost.language"));
            login.addTextNode(environment.getProperty("soap.russianpost.login"));
            password.addTextNode(environment.getProperty("soap.russianpost.password"));

            //Сохранение сообщения
            message.saveChanges();

            //Отправляем запрос и выводим ответ на экран
            SOAPMessage soapResponse = connection.call(message, url);
            Source sourceContent = soapResponse.getSOAPPart().getContent();
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.METHOD, "html");
            t.setOutputProperty(OutputKeys.INDENT, "yes");

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            t.transform(sourceContent, new StreamResult(bos));
            res = new String(bos.toByteArray(), "UTF-8");
        } catch (SOAPException | TransformerException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            //Закрываем соединение
            if (connection != null){
                try {
                    connection.close();
                } catch (SOAPException e) {
                    e.printStackTrace();
                }
            }
        }

        return res;
    }
}
