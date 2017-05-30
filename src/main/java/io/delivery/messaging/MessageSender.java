package io.delivery.messaging;

import javax.jms.ObjectMessage;
import io.delivery.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class MessageSender {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final Order order) {

        jmsTemplate.send(session -> {
            ObjectMessage objectMessage = session.createObjectMessage(order);
            return objectMessage;
        });
    }
}