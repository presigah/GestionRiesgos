package co.com.sofka.gestionriesgos.usercases.risk;

import co.com.sofka.gestionriesgos.collections.Risk;
import co.com.sofka.gestionriesgos.mappers.ProjectMapper;
import co.com.sofka.gestionriesgos.mappers.RiskMapper;
import co.com.sofka.gestionriesgos.model.RiskDTO;
import co.com.sofka.gestionriesgos.repositories.ProjectRepository;
import co.com.sofka.gestionriesgos.repositories.RiskRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class UpdateRiskUseCase implements SaveRisk{

    private final RiskRepository riskRepo;
    private final ProjectRepository projectRepo;
    private final RiskMapper riskMapper;
    private final ProjectMapper projectMapper;

    public UpdateRiskUseCase(RiskMapper riskMapper, RiskRepository riskRepo, ProjectRepository projectRepo, ProjectMapper projectMapper) {
        this.riskRepo = riskRepo;
        this.projectRepo = projectRepo;
        this.riskMapper = riskMapper;
        this.projectMapper = projectMapper;
    }

    public Mono<String> apply(RiskDTO riskDTO){
        Objects.requireNonNull(riskDTO.getId(), "Id of the risk is required");
        return riskRepo
                .save(riskMapper.RiskDTOTORisk(riskDTO.getId()).apply(riskDTO))
                .map(Risk::getId);
    }
}
