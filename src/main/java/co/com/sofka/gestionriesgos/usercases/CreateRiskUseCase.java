package co.com.sofka.gestionriesgos.usercases;

import co.com.sofka.gestionriesgos.collections.Risk;
import co.com.sofka.gestionriesgos.mappers.RiskMapper;
import co.com.sofka.gestionriesgos.model.RiskDTO;
import co.com.sofka.gestionriesgos.repositories.RiskRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class CreateRiskUseCase {
    private final RiskRepository riskRepo;
    private final RiskMapper mapper;

    public CreateRiskUseCase(RiskMapper mapper, RiskRepository repository) {
        this.riskRepo = repository;
        this.mapper = mapper;
    }

    public Mono<String> apply(RiskDTO riskDTO) {


        return riskRepo
                .save(mapper.RiskDTOTORisk().apply(riskDTO))
                .map(Risk::getId);
    }
}
