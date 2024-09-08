package org.br.mineracao.message;


import io.netty.channel.ChannelHandler;
import org.br.mineracao.dto.QuotationDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class KafkaEvents {

    private final Logger LOG = LoggerFactory.getLogger(KafkaEvents.class);

    @Channel("quotation-channel")
    Emitter<QuotationDTO> quotationDTOEmitter;

    public void sendNewKafkaEvent(QuotationDTO quotationDTO){
        LOG.info("-- Enviando uma cotação para o tópico kafka --");
        quotationDTOEmitter.send(quotationDTO).toCompletableFuture().join();
    }
}
