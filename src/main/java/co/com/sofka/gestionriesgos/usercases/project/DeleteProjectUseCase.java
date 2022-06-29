package co.com.sofka.gestionriesgos.usercases.project;

import co.com.sofka.gestionriesgos.repositories.ProjectRepository;
import co.com.sofka.gestionriesgos.repositories.RiskRepository;
import com.mongodb.Function;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class DeleteProjectUseCase implements Function<String, Mono<Void>> {
    private final ProjectRepository projectRepository;
    private final RiskRepository riskRepository;

    public DeleteProjectUseCase(ProjectRepository projectRepository, RiskRepository riskRepository) {
        this.projectRepository = projectRepository;
        this.riskRepository = riskRepository;
    }


    @Override
    public Mono<Void> apply(String id) {
        Objects.requireNonNull(id, "Id es requerido");

        return projectRepository.findById(id)
                .flatMap(project -> {
                    if (project.getStatus().equalsIgnoreCase("Creado")) {
                        riskRepository.findByProjectId(id).flatMap(risk -> {
                            risk.setRiskState("Inactivo");
                            riskRepository.save(risk);
                            return Mono.empty();
                        });
                       return projectRepository.deleteById(id);
                    }
                    return Mono.error(new IllegalArgumentException("El proyecto no puede ser eliminado"));
                });
    }
}
