package br.com.xuma.rabbittest.queue.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.xuma.rabbittest.dto.EnvelopeDTO;
import br.com.xuma.rabbittest.queue.RabbitQueueListener;

/**
 *  Class wrapping listener methods to receive messages from specified queues.
 */

@Component
public class RabbitQueueListenerImpl implements RabbitQueueListener {

    @RabbitListener(queues = "${node.queues.fanoutQueueFoo}")
    @Override
    public void fooListener(EnvelopeDTO envelopeDTO) {
        System.out.println("Received messsage from queue foo! " + envelopeDTO.toString());
    }

    @RabbitListener(queues = "${node.queues.fanoutQueueBar}")
    @Override
    public void barListener(EnvelopeDTO envelopeDTO) {
        System.out.println("Received messsage from queue bar! " + envelopeDTO.toString());
    }

    @RabbitListener(queues = "${node.queues.fanoutQueueBaz}")
    @Override
    public void bazListener(EnvelopeDTO envelopeDTO) {
        System.out.println("Received messsage from queue baz! " + envelopeDTO.toString());
    }
}