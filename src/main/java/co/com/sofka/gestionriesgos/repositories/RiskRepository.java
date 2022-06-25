package co.com.sofka.gestionriesgos.repositories;

import co.com.sofka.gestionriesgos.collections.Risk;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface RiskRepository extends ReactiveCrudRepository<Risk, Integer> {
    Flux<Risk> findByUserId();
    Flux<Risk> findByProjectId();
}
