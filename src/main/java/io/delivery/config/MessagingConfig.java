package io.delivery.config;

import java.net.URI;
import java.util.Arrays;

import javax.jms.ConnectionFactory;

import io.delivery.messaging.MessageReceiver;
import io.delivery.messaging.MessageSender;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.activemq.usage.SystemUsage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;


@Configuration
@EnableJms
public class MessagingConfig {

    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    private static final String ORDER_QUEUE = "order-queue";
    private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";

//    @Autowired
//    MessageReceiver messageReceiver;
//    @Bean
//    public BrokerService createBrokerService() throws Exception {
//        BrokerService broker = new BrokerService();
//        TransportConnector connector = new TransportConnector();
//        connector.setUri(new URI("tcp://localhost:61616"));
//        broker.addConnector(connector);
//        broker.setPersistent(false);
//        broker.setUseJmx(false);
//        SystemUsage systemUsage = broker.getSystemUsage();
//        systemUsage.getStoreUsage().setLimit(256 * 256 * 8);
//        systemUsage.getTempUsage().setLimit(256 * 256 * 8);
//        return broker;
//    }

    @Bean
    @Primary
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("io.delivery.messaging"));
        return connectionFactory;
    }

    @Bean
    public ConnectionFactory cachingConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setTargetConnectionFactory(connectionFactory());
        connectionFactory.setSessionCacheSize(10);
        return connectionFactory;
    }

//    @Bean
//    public MessageListenerContainer getContainer() {
//        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory());
//        container.setDestinationName(ORDER_RESPONSE_QUEUE);
//        container.setMessageListener(messageReceiver);
//        return container;
//    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(ORDER_QUEUE);
        return template;
    }

    @Bean
    MessageConverter converter() {
        return new SimpleMessageConverter();
    }

    @Bean
    MessageSender messageSender() {return new MessageSender(); }

    @Bean
    MessageReceiver messageReceiver() {return new MessageReceiver(); }

}