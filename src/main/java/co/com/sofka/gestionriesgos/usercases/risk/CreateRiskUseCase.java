package co.com.sofka.gestionriesgos.usercases.risk;

import co.com.sofka.gestionriesgos.collections.Risk;
import co.com.sofka.gestionriesgos.mappers.RiskMapper;
import co.com.sofka.gestionriesgos.model.RiskDTO;
import co.com.sofka.gestionriesgos.repositories.RiskRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateRiskUseCase implements SaveRisk{
    private final RiskRepository riskRepo;
    private final RiskMapper riskMapper;

    public CreateRiskUseCase(RiskMapper riskMapper, RiskRepository riskRepo) {
        this.riskRepo = riskRepo;
        this.riskMapper = riskMapper;
    }

    public Mono<String> apply(RiskDTO riskDTO) {
        return riskRepo
                .save(riskMapper.RiskDTOTORisk(null).apply(riskDTO))
                .map(Risk::getId);
    }
}
