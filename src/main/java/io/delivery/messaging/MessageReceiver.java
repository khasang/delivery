package io.delivery.messaging;

import io.delivery.model.InventoryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class MessageReceiver implements MessageListener {
    private final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

    @Autowired
    MessageConverter messageConverter;

    @Override
    public void onMessage(Message message) {
        try {
            LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            InventoryResponse response = (InventoryResponse) messageConverter.fromMessage(message);
            LOG.info("Application : order response received : {}",response);
            LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
