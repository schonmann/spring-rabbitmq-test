package br.com.xuma.rabbittest.queue;

import br.com.xuma.rabbittest.dto.EnvelopeDTO;

public interface RabbitQueueListener {
    void fooListener(EnvelopeDTO envelopeDTO);
    void barListener(EnvelopeDTO envelopeDTO);
    void bazListener(EnvelopeDTO envelopeDTO);
}