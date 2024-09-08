package org.br.mineracao.message;

import org.br.mineracao.dto.ProposalDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaEvents {

    private final Logger LOG = LoggerFactory.getLogger(KafkaEvents.class);

    @Channel("proposal")
    Emitter<ProposalDTO> proposalEntityEmitter;

    public void sendNewKafkaEvent(ProposalDTO proposalDTO){
        LOG.info("-- Enviando uma proposta para o tópico kafka --");
        proposalEntityEmitter.send(proposalDTO).toCompletableFuture().join();
    }
}
