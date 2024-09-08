package org.br.mineracao.service;

import org.br.mineracao.client.ProposalClient;
import org.br.mineracao.dto.ProposalDetailsDTO;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Traced
public class ProposalServiceImpl implements ProposalService {

    @Inject
    @RestClient
    ProposalClient proposalClient;

    @Override
    public ProposalDetailsDTO getProposalDetailsById(long proposalId) {
       return proposalClient.geProposalDetailsById(proposalId);
    }

    @Override
    public Response createProposal(ProposalDetailsDTO proposalDetails) {
        return proposalClient.createProposal(proposalDetails);
    }

    @Override
    public Response removeProposal(long id) {
        return proposalClient.removeProposal(id);
    }
}
