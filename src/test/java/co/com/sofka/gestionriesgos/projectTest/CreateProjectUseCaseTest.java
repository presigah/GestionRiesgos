package co.com.sofka.gestionriesgos.projectTest;

import co.com.sofka.gestionriesgos.collections.Project;
import co.com.sofka.gestionriesgos.mappers.ProjectMapper;
import co.com.sofka.gestionriesgos.repositories.ProjectRepository;
import co.com.sofka.gestionriesgos.usercases.project.CreateProjectUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CreateProjectUseCaseTest {

    @Mock
    ProjectRepository projectRepository;


    CreateProjectUseCase createProjectUseCase;

    ProjectMapper projectMapper;

    @BeforeEach
    void setUp() {
        projectMapper = new ProjectMapper();
        createProjectUseCase = new CreateProjectUseCase(projectRepository, projectMapper);
    }

    @Test
    void getValidationCreateProjectTest(){
        var project = new Project();
        project.setName("Project");
        project.setDescription("Description");
        project.setEndingDate(LocalDate.of(2022,7,4));
        project.setLabels(List.of("label1", "label2"));
        project.setEmails(List.of("correo@gmail.com"));
        project.setDescription("Description");
        project.setStatus("Creado");

        var projectReturn = new Project();
        projectReturn.setId("1");
        project.setName("Project");
        project.setDescription("Description");
        project.setStartDate(LocalDate.now());
        project.setEndingDate(LocalDate.of(2022,7,4));
        project.setLabels(List.of("label1", "label2"));
        project.setEmails(List.of("correo@gmail.com"));
        project.setDescription("Description");
        project.setStatus("Creado");

        var projectDTO = projectMapper.entityToProjectDTO().apply(project);

        when(projectRepository.save(any(Project.class))).thenReturn(Mono.just(projectReturn));

        StepVerifier.create(createProjectUseCase.apply(projectDTO))
                .expectNext("1")
                .verifyComplete();

        verify(projectRepository).save(project);
    }

}