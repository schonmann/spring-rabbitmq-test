package br.com.xuma.rabbittest.queue.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.xuma.rabbittest.queue.RabbitQueueListener;

public class RabbitQueueListenerImpl implements RabbitQueueListener {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitQueueListenerImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    @Override
    public void receiveMessage(String data) {
        
    }
}