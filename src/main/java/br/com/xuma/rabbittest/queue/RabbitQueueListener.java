package br.com.xuma.rabbittest.queue;

public interface RabbitQueueListener {
    void receiveMessage(String data);
}