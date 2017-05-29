package io.delivery.messaging;

import io.delivery.entity.Order;
import io.delivery.model.InventoryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.ArrayList;
import java.util.List;

@Component
public class MessageReceiver {

    @Autowired
    JmsTemplate jmsTemplate;

    public List<Order> orderReceiver(String queue) {

        List<Order> ordersReceived = new ArrayList<Order>();
        Object nextOrder = jmsTemplate.receiveAndConvert(queue);

        while (nextOrder != null) {
            ordersReceived.add((Order) nextOrder);
            nextOrder = jmsTemplate.receiveAndConvert(queue);
        }
        return ordersReceived;
    }

}