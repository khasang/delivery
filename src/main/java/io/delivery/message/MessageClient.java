package io.delivery.message;

import javax.annotation.Resource;
import javax.jms.*;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageClient {
    @Resource(mappedName = "jms/Example1ConnectionFactory")      // устанавливаем соединение с JMS-провайдером
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/Example1Queue")
    private static Queue queue;

    Connection connection = null;
    Destination destination = queue;

//    try{
//        try {
//            connection = connectionFactory.createConnection();
//            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            MessageProducer producer = session.createProducer(destination);      // создали producer (отправка)
//            TextMessage message = session.createTextMessage();       // создали текстовое сообщение
//            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//            char c = 'n';
//            int i = 0;
//            while (!((c == 'q') || (c == 'Q'))) {
//                try {
//                    c = (char) inputStreamReader.read();     // ожидание ввода пользователя
//                    message.setText("La-la-la-la-la " + (i + 1);     // формируем тело сообщения
//                    System.out.println("Sending message: " + message.getText());
//                    producer.send(message);         // отправка сообщения в Очередь (Queue)
//                    i++;
//                } catch(IOException e) {
//                    System.err.println("IOException: " +e.toString());
//                }
//            }
//        } catch (JMSException e1) {
//            e1.printStackTrace();
//        }
//
//     finally {
//        if (connection != null) {
//            try {
//                connection.close();     // закрываем соединение с JMS-провайдером
//            } catch( JMSException e) {
//                System.err.println("exception...");
//            }
//        }
//    }
//
//    }
}