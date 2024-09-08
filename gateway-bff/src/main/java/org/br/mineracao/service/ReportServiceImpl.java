package org.br.mineracao.service;

import org.br.mineracao.client.ReportClient;
import org.br.mineracao.dto.OpportunityDTO;
import org.br.mineracao.utils.CSVHelper;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.util.List;

@ApplicationScoped
@Traced
public class ReportServiceImpl implements ReportService{

    @Inject
    @RestClient
    ReportClient reportClient;

    @Override
    public ByteArrayInputStream generateCSVOpportunityReport() {

        List<OpportunityDTO> opportunityDTOS = reportClient.requestOppotunitiesData();

        return CSVHelper.OppotunitiesToCSV(opportunityDTOS);
    }

    @Override
    public List<OpportunityDTO> getOpportunityDetails() {
        return reportClient.requestOppotunitiesData();
    }
}
