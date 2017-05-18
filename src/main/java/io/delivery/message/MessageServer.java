package io.delivery.message;

import javax.annotation.Resource;
import javax.jms.*;
import javax.xml.soap.Text;

public class MessageServer {
        @Resource(mappedName = "jms/Example1ConnectionFactory")      // устанавливаем соединение с JMS-провайдером
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/Example1Queue")
    private static Queue queue;

    Connection connection = null;
    Destination dest = (Destination) queue;
    String destType = null;
    Session session = null;
    MessageConsumer consumer = null;
    TextMessage message = null;

    try{
        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            consumer = session.createConsumer(dest);      // создаём получателя (consumer)
            connection.start();     // start, чтобы мы могли принимать сообщения

            while (true) {
                Message m = consumer.receive(1);    // ожидание 1 милисек

                if (m != null) {
                    if (m instanceof TextMessage) {       // если сообщение имеет текстовый тип, то оно извлекается и печатается тело сообщения
                        message = (TextMessage) m;
                        System.out.println("Reading message: " + message.getText());
                    }
                }
            }
        } catch (JMSException e1) {
            e1.printStackTrace();
        }

//    } catch(JMSException e) {
//        System.err.println("Exception occurred: " + e.toString());
    }
    finally {
        if (connection != null) {
            try {
                connection.close();     // закрываем соединение с JMS-провайдером
            } catch( JMSException e) {
                System.err.println("exception...");
            }
        }
    }




}
