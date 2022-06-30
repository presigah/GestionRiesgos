package co.com.sofka.gestionriesgos.usercases.risk;

import co.com.sofka.gestionriesgos.collections.Project;
import co.com.sofka.gestionriesgos.mappers.RiskMapper;
import co.com.sofka.gestionriesgos.model.RiskDTO;
import co.com.sofka.gestionriesgos.repositories.ProjectRepository;
import co.com.sofka.gestionriesgos.repositories.RiskRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateRiskUseCase implements SaveRisk{
    private final RiskRepository riskRepo;
    private final RiskMapper riskMapper;
    private final ProjectRepository projectRepository;

    public CreateRiskUseCase(RiskMapper riskMapper, RiskRepository riskRepo, ProjectRepository projectRepository) {
        this.riskRepo = riskRepo;
        this.riskMapper = riskMapper;
        this.projectRepository = projectRepository;
    }

    public Mono<String> apply(RiskDTO riskDTO) {
        if(riskDTO.getDetectedDate().isBefore(riskDTO.getEndedDate()) || riskDTO.getDetectedDate().isEqual(riskDTO.getEndedDate())) {
            return riskRepo
                    .save(riskMapper.RiskDTOTORisk(null).apply(riskDTO))
                    .flatMap(risk -> projectRepository.findById(risk.getProjectId()))
                    .flatMap(project -> {
                        project.setStatus("Cerrado");
                        return projectRepository.save(project);
                    })
                    .map(Project::getId)
                    .switchIfEmpty(Mono.defer(() -> Mono.just("Empty")));
        }
        return Mono.error(new IllegalArgumentException("La fecha de inicio debe ser igual o anterior a la fecha de finalización"));
    }
}
