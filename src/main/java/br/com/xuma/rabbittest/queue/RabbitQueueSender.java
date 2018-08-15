package br.com.xuma.rabbittest.queue;

import br.com.xuma.rabbittest.dto.EnvelopeDTO;

public interface RabbitQueueSender {
    void sendMessage(String exchangeName, String routingKey, EnvelopeDTO envelope);
}