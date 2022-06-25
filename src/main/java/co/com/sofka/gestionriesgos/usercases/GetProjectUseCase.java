package co.com.sofka.gestionriesgos.usercases;

import co.com.sofka.gestionriesgos.mappers.ProjectMapper;
import co.com.sofka.gestionriesgos.model.ProjectDTO;
import co.com.sofka.gestionriesgos.repositories.ProjectRepository;
import co.com.sofka.gestionriesgos.repositories.RiskRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class GetProjectUseCase implements Function<String, Mono<ProjectDTO>> {
    private final ProjectRepository projectRepository;
    private final RiskRepository riskRepository;
    private final ProjectMapper projectMapper;

    public GetProjectUseCase(ProjectRepository projectRepository, RiskRepository riskRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.riskRepository = riskRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public Mono<ProjectDTO> apply(String id) {
        Objects.requireNonNull(id, "Id is required");
        return projectRepository.findById(id)
                .map(projectMapper.EntityToProjectDTO())
                .flatMap(mapProjectAggregate());
    }

    private Function<ProjectDTO, Mono<ProjectDTO>> mapProjectAggregate() {
        return projectDTO ->
                Mono.just(projectDTO).zipWith(
                        riskRepository.findAllByProjectId(projectDTO.getId())
                                .map(projectMapper.EntityToProjeDTO())
                                .collectList(),
                        (question, answers) -> {
                            question.setAnswers(answers);
                            return question;
                        }
                );
    }

}
