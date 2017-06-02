package io.delivery.config.application;

import io.delivery.message.CustomerJmsSender;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
public class CustomerJmsConfig {
    private static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    private static final String CUSTOMER_DESTINATION_NAME = "Customer_JMS";

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDefaultDestinationName(CUSTOMER_DESTINATION_NAME);
        return jmsTemplate;
    }

    @Bean
    public ConnectionFactory connectionFactory(){
        return new ActiveMQConnectionFactory(ACTIVEMQ_URL);
    }

    @Bean
    public CustomerJmsSender customerJmsSender(){
        return new CustomerJmsSender();
    }
}
