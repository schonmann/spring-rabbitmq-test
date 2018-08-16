package br.com.xuma.rabbittest.queue.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.xuma.rabbittest.dto.EnvelopeDTO;
import br.com.xuma.rabbittest.queue.RabbitQueueSender;

@Component
public class RabbitQueueSenderImpl implements RabbitQueueSender {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitQueueSenderImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     *  Send a message to the target exchange.
     */

    @Override
    public void sendMessage(String exchangeName, String routingKey, EnvelopeDTO envelope) {
        System.out.println(String.format("Sending message... (%s)", envelope.toString()));
        rabbitTemplate.convertAndSend(exchangeName, routingKey, envelope);
    }
}