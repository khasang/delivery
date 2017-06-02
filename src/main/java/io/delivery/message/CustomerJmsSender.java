package io.delivery.message;

import io.delivery.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerJmsSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(Customer customer) {
        jmsTemplate.convertAndSend(customer);
    }
}
