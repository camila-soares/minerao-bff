package org.br.mineracao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Jacksonized
@Data
@Builder
@AllArgsConstructor
public class ProposalDTO {

    private Long proposalId;

    private String customer;

    private Integer tonnes;

    private BigDecimal priceTonne;
}
