package org.br.mineracao.service;

import org.br.mineracao.dto.ProposalDTO;
import org.br.mineracao.dto.ProposalDetailsDTO;
import org.br.mineracao.entity.ProposalEntity;
import org.br.mineracao.message.KafkaEvents;
import org.br.mineracao.repository.ProposalRepository;
import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

@ApplicationScoped
@Traced
public class ProposalServiceImpl implements ProposalService{

    @Inject
    ProposalRepository repository;

    @Inject
    KafkaEvents kafkaEvents;

    @Override
    public ProposalDetailsDTO findProposal(long id) {


        ProposalEntity proposalEntity =  repository.findById(id);

        return ProposalDetailsDTO.builder()
                .proposalId(proposalEntity.getId())
                .proposalValidityDays(proposalEntity.getProposalValidityDays())
                .country(proposalEntity.getCountry())
                .priceTonne(proposalEntity.getPriceTonne())
                .customer(proposalEntity.getCustomer())
                .tonnes(proposalEntity.getTonnes())
                .priceTonne(proposalEntity.getPriceTonne())
                .build();

    }

    @Override
    @Transactional
    public void createNewProposal(ProposalDetailsDTO proposalDetailsDTO) {
        ProposalDTO proposal = buildAndSaveNewProposal(proposalDetailsDTO);
        kafkaEvents.sendNewKafkaEvent(proposal);

    }

    @Transactional
    public ProposalDTO buildAndSaveNewProposal(ProposalDetailsDTO proposalDetailsDTO) {

        try {

            ProposalEntity proposal = new ProposalEntity();

            proposal.setCreated(new Date());
            proposal.setProposalValidityDays(proposalDetailsDTO.getProposalValidityDays());
            proposal.setCountry(proposalDetailsDTO.getCountry());
            proposal.setCustomer(proposalDetailsDTO.getCustomer());
            proposal.setPriceTonne(proposalDetailsDTO.getPriceTonne());
            proposal.setTonnes(proposalDetailsDTO.getTonnes());

            repository.persist(proposal);

            return ProposalDTO.builder()
                    .proposalId(repository.findByCustomer(proposal.getCustomer()).get().getId())
                    .priceTonne(proposal.getPriceTonne())
                    .tonnes(proposal.getTonnes())
                    .customer(proposal.getCustomer())
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    @Transactional
    public void removeProposal(long id) {
        repository.deleteById(id);
    }
}
