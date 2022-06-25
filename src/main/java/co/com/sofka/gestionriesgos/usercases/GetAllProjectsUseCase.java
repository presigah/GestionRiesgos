package co.com.sofka.gestionriesgos.usercases;

import co.com.sofka.gestionriesgos.mappers.ProjectMapper;
import co.com.sofka.gestionriesgos.model.ProjectDTO;
import co.com.sofka.gestionriesgos.repositories.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class GetAllProjectsUseCase implements Supplier<Flux<ProjectDTO>> {
    private ProjectRepository projectRepository;
    private ProjectMapper projectMapper;

    public GetAllProjectsUseCase(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public Flux<ProjectDTO> get() {
        return projectRepository.findAll().map(projectMapper.EntityToProjectDTO());
    }
}
