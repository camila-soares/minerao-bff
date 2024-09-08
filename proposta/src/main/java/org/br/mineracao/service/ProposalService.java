package org.br.mineracao.service;

import org.br.mineracao.dto.ProposalDetailsDTO;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ProposalService {

    ProposalDetailsDTO findProposal(long id);
    void createNewProposal(ProposalDetailsDTO proposalDetailsDTO);
    void removeProposal(long id);

}
