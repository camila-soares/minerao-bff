package org.br.mineracao.service;

import org.br.mineracao.dto.ProposalDetailsDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@ApplicationScoped
public interface ProposalService {


    ProposalDetailsDTO getProposalDetailsById(@PathParam("id") long  id);

    Response createProposal(ProposalDetailsDTO proposalDetails);

    Response removeProposal(long id);
}
