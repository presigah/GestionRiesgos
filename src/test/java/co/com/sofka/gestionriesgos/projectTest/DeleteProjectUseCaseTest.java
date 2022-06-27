package co.com.sofka.gestionriesgos.projectTest;

import co.com.sofka.gestionriesgos.collections.Project;
import co.com.sofka.gestionriesgos.repositories.ProjectRepository;
import co.com.sofka.gestionriesgos.usercases.project.DeleteProjectUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class DeleteProjectUseCaseTest {

    @Mock
    ProjectRepository projectRepository;

    DeleteProjectUseCase deleteProjectUseCase;

    @BeforeEach
    void setup() {
        deleteProjectUseCase = new DeleteProjectUseCase(projectRepository);
    }

    @Test
    void deleteProjectTest() {
        var proyecto = new Project();
        proyecto.setId("1");
        proyecto.setName("Project");
        proyecto.setDescription("Description");
        proyecto.setStartDate(LocalDate.now());
        proyecto.setEndingDate(LocalDate.of(2022,07,04));
        proyecto.setLabels(List.of("label1", "label2"));
        proyecto.setEmails(List.of("correo@gmail.com"));
        proyecto.setDescription("Description");
        proyecto.setStatus("Creado");


        when(projectRepository.findById(proyecto.getId())).thenReturn(Mono.just(proyecto));
        when(projectRepository.deleteById(proyecto.getId())).thenReturn(Mono.empty());

        StepVerifier.create(deleteProjectUseCase.apply(proyecto.getId()))
                .verifyComplete();

        verify(projectRepository).deleteById(proyecto.getId());
    }


}