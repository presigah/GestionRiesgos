package co.com.sofka.gestionriesgos.usercases.history;

import co.com.sofka.gestionriesgos.collections.History;
import co.com.sofka.gestionriesgos.repositories.HistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class GetAllHistoriesUseCase implements Supplier<Flux<History>> {

    private final HistoryRepository historyRepository;

    public GetAllHistoriesUseCase(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public Flux<History> get() {
        return historyRepository.findAll();
    }
}
