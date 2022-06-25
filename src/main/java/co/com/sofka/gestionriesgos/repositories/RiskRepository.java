package co.com.sofka.gestionriesgos.repositories;

import co.com.sofka.gestionriesgos.collections.Risk;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Repository
public interface RiskRepository extends ReactiveCrudRepository<Risk, String> {
    Flux<Risk> findAllByProjectId(String id);
}
