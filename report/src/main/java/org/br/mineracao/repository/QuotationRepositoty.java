package org.br.mineracao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.br.mineracao.entity.QuotationEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuotationRepositoty implements PanacheRepository<QuotationEntity> {
}
