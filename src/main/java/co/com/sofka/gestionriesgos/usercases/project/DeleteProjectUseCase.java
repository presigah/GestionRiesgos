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
public class DeleteProjectUseCase  implements Function<String, Mono<Void>> {
    private final ProjectRepository projectRepository;
    private final RiskRepository riskRepository;

    public DeleteProjectUseCase(RiskRepository riskRepository, ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
        this.riskRepository = riskRepository;
    }


    @Override
    public Mono<Void> apply(String id) {
//        Objects.equals(status, "Creado");
        Objects.requireNonNull(id, "Id es requerido");
        return projectRepository.deleteById(id);
//                .switchIfEmpty(Mono.defer(() -> riskRepository.deleteByQuestionId(id)));
    }
}
