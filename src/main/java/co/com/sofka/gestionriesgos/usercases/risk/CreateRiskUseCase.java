package co.com.sofka.gestionriesgos.usercases.risk;

import co.com.sofka.gestionriesgos.collections.Risk;
import co.com.sofka.gestionriesgos.mappers.ProjectMapper;
import co.com.sofka.gestionriesgos.mappers.RiskMapper;
import co.com.sofka.gestionriesgos.model.RiskDTO;
import co.com.sofka.gestionriesgos.repositories.ProjectRepository;
import co.com.sofka.gestionriesgos.repositories.RiskRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateRiskUseCase implements SaveRisk{
    private final RiskRepository riskRepo;
    private final ProjectRepository projectRepo;
    private final RiskMapper riskMapper;
    private final ProjectMapper projectMapper;

    public CreateRiskUseCase(RiskMapper riskMapper, RiskRepository riskRepo, ProjectRepository projectRepo, ProjectMapper projectMapper) {
        this.riskRepo = riskRepo;
        this.projectRepo = projectRepo;
        this.riskMapper = riskMapper;
        this.projectMapper = projectMapper;
    }

    public Mono<String> apply(RiskDTO riskDTO) {
        return riskRepo
                .save(riskMapper.RiskDTOTORisk(null).apply(riskDTO))
                .map(Risk::getId);
    }
}
