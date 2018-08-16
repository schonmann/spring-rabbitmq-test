package br.com.xuma.rabbittest.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableRabbit
@EnableScheduling
public class RabbitMQConfig implements RabbitListenerConfigurer {

    @Value(value = "${node.queues.fanoutExchange}")
    private String fanoutExchange;

    @Value(value = "${node.queues.fanoutQueueFoo}")
    private String fanoutQueueFoo;

    @Value(value = "${node.queues.fanoutQueueBar}")
    private String fanoutQueueBar;

    @Value(value = "${node.queues.fanoutQueueBaz}")
    private String fanoutQueueBaz;

    // @Bean
    // public FanoutExchange fanoutExchange() {
    //     return new FanoutExchange(fanoutExchange);
    // }

    // @Bean
    // public Queue fanoutQueueFoo() {
    //     return new Queue(fanoutQueueFoo);
    // }

    // @Bean
    // public Queue fanoutQueueBar() {
    //     return new Queue(fanoutQueueBar);
    // }

    // @Bean
    // public Queue fanoutQueueBaz() {
    //     return new Queue(fanoutQueueBaz);
    // }

    // @Bean
    // public Binding declareFanoutToQueueBindingFoo() {
    //     return BindingBuilder.bind(fanoutQueueFoo()).to(fanoutExchange());
    // }

    // @Bean
    // public Binding declareFanoutToQueueBindingBar() {
    //     return BindingBuilder.bind(fanoutQueueBar()).to(fanoutExchange());
    // }

    // @Bean
    // public Binding declareFanoutToQueueBindingBaz() {
    //     return BindingBuilder.bind(fanoutQueueBaz()).to(fanoutExchange());
    // }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }

    @Bean
    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(consumerJackson2MessageConverter());
        return factory;
    }

    @Override
    public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }
}