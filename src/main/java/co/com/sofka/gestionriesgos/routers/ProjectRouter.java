package co.com.sofka.gestionriesgos.routers;

import co.com.sofka.gestionriesgos.model.ProjectDTO;
import co.com.sofka.gestionriesgos.usercases.CreateProjectUseCase;
import co.com.sofka.gestionriesgos.usercases.GetAllProjectsUseCase;
import co.com.sofka.gestionriesgos.usercases.GetProjectUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RestController
@Configuration
public class ProjectRouter {

    //Crear un proyecto
    @Bean
    public RouterFunction<ServerResponse> create(CreateProjectUseCase createProjectUseCase) {
        Function<ProjectDTO, Mono<ServerResponse>> executor = projectDTO -> createProjectUseCase.apply(projectDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .bodyValue(result));
        return route(
                POST("/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProjectDTO.class).flatMap(executor)
        );
    }

    //Obtener Todos los proyectos
    @Bean
    public RouterFunction<ServerResponse> getAll(GetAllProjectsUseCase getAllProjectsUseCase) {
        return route(GET("/getAllProjects"),request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllProjectsUseCase.get(),ProjectDTO.class)));
    }

    //Obtener un proyecto por su id
    @Bean
    public RouterFunction<ServerResponse> getById(GetProjectUseCase getProjectUseCase) {
        return route(
                GET("/getProject/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getProjectUseCase.apply(
                                        request.pathVariable("id")),
                                ProjectDTO.class
                        ))
        );
    }
}
