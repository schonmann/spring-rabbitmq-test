package br.com.xuma.rabbittest.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.xuma.rabbittest.dto.EnvelopeDTO;
import br.com.xuma.rabbittest.queue.RabbitQueueSender;
import br.com.xuma.rabbittest.service.QueueProducerService;

@Service
public class QueueProducerServiceImpl implements QueueProducerService {

    private RabbitQueueSender queueSender;

    @Autowired
    public QueueProducerServiceImpl(RabbitQueueSender queueSender) {
        this.queueSender = queueSender;
    }
    
    @Value(value = "${node.queues.fanoutExchange}")
    private String fanoutExchange;

    @Scheduled(fixedDelay = 1000)
	@Override
	public void produceMessage() {
        EnvelopeDTO envelopeDTO = new EnvelopeDTO();
        envelopeDTO.setFrom("Fooguy");
        envelopeDTO.setBody("Hello, subscriber!");
        envelopeDTO.setTimestamp(new Date().getTime());
        queueSender.sendMessage(fanoutExchange, "", envelopeDTO);
	}

}