package org.br.mineracao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.br.mineracao.entity.ProposalEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class ProposalRepository implements PanacheRepository<ProposalEntity> {

    public Optional<ProposalEntity> findByCustomer(String customer){
        return Optional.of(find("customer", customer).firstResult());
    }
}
