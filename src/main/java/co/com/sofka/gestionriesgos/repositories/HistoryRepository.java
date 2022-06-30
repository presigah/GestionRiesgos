package co.com.sofka.gestionriesgos.repositories;

import co.com.sofka.gestionriesgos.collections.History;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface HistoryRepository extends ReactiveCrudRepository<History, String> {
}
