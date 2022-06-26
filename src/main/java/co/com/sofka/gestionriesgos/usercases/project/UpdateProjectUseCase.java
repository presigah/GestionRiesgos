package co.com.sofka.gestionriesgos.usercases.project;

import co.com.sofka.gestionriesgos.collections.Project;
import co.com.sofka.gestionriesgos.mappers.ProjectMapper;
import co.com.sofka.gestionriesgos.model.ProjectDTO;
import co.com.sofka.gestionriesgos.repositories.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class UpdateProjectUseCase implements SaveProject {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public UpdateProjectUseCase(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public Mono<String> apply(ProjectDTO updateProject) {
        Objects.requireNonNull(updateProject.getId(), "El id del proyecto no puede ser nulo");
        return projectRepository.save(projectMapper.mapperToProject(updateProject.getId()).apply(updateProject))
                .map(Project::getId);
    }
}
