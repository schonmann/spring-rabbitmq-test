package br.com.xuma.rabbittest.queue.impl;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Argument;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.xuma.rabbittest.dto.EnvelopeDTO;
import br.com.xuma.rabbittest.queue.RabbitQueueListener;

/**
 *  Class wrapping listener methods to receive messages from specified queues.
 */

@Component
public class RabbitQueueListenerImpl implements RabbitQueueListener {

    @RabbitListener(
        bindings = @QueueBinding(
            value = @Queue(value = "${node.queues.fanoutQueueFoo}"),
            exchange = @Exchange(value = "${node.queues.fanoutExchange}", type = ExchangeTypes.FANOUT),
            arguments = @Argument(name = "x-expires", value = "604800000")
        )
    )
    @Override
    public void fooListener(EnvelopeDTO envelopeDTO) {
        System.out.println("Received messsage from queue foo! " + envelopeDTO.toString());
    }

    @RabbitListener(
        bindings = @QueueBinding(
            value = @Queue(value = "${node.queues.fanoutQueueBar}"),
            exchange = @Exchange(value = "${node.queues.fanoutExchange}", type = ExchangeTypes.FANOUT),
            arguments = @Argument(name = "x-expires", value = "604800000")
        )
    )
    @Override
    public void barListener(EnvelopeDTO envelopeDTO) {
        System.out.println("Received messsage from queue bar! " + envelopeDTO.toString());
    }

    @RabbitListener(
        bindings = @QueueBinding(
            value = @Queue(value = "${node.queues.fanoutQueueBaz}"),
            exchange = @Exchange(value = "${node.queues.fanoutExchange}", type = ExchangeTypes.FANOUT),
            arguments = @Argument(name = "x-expires", value = "604800000")
        )
    )
    @Override
    public void bazListener(EnvelopeDTO envelopeDTO) {
        System.out.println("Received messsage from queue baz! " + envelopeDTO.toString());
    }
}