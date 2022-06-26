package co.com.sofka.gestionriesgos.usercases.project;

import co.com.sofka.gestionriesgos.repositories.ProjectRepository;
import com.mongodb.Function;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class DeleteProjectUseCase implements Function<String, Mono<Void>> {
    private final ProjectRepository projectRepository;

    public DeleteProjectUseCase(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public Mono<Void> apply(String id) {
        Objects.requireNonNull(id, "Id es requerido");

        return projectRepository.findById(id)
                .flatMap(project -> {
                    if (project.getStatus().equalsIgnoreCase("Creado")) {
                       return projectRepository.deleteById(id);
                    }throw new IllegalArgumentException("El proyecto no puede ser eliminado");
                });
    }
}
