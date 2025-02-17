package org.br.mineracao.client;


import io.quarkus.oidc.token.propagation.reactive.AccessTokenRequestReactiveFilter;
import org.br.mineracao.dto.OpportunityDTO;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/api/opportunity")
@RegisterRestClient
@RegisterProvider(AccessTokenRequestReactiveFilter.class)
@ApplicationScoped
public interface ReportClient {


    @GET
    @Path("/data")
    List<OpportunityDTO> requestOppotunitiesData();

}
