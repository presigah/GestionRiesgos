package co.com.sofka.gestionriesgos.routers;

import co.com.sofka.gestionriesgos.model.ProjectDTO;
import co.com.sofka.gestionriesgos.usercases.project.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springdoc.core.annotations.RouterOperation;
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

    //Consultar Todos los proyectos
    @Bean
    @RouterOperation(beanClass = GetAllProjectsUseCase.class, beanMethod = "get",
            operation = @Operation(operationId = "Consultar", summary = "Consultar todos los proyecctos", tags = {"Proyecto"}))
    public RouterFunction<ServerResponse> getAll(GetAllProjectsUseCase getAllProjectsUseCase) {
        return route(GET("/getAllProjects"),request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllProjectsUseCase.get(),ProjectDTO.class)));
    }

    //Consultar un proyecto por su id
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

//    Modificar un proyecto
    @Bean
    @RouterOperation(beanClass = UpdateProjectUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "Actualizar", summary = "Actualizar proyecto",  tags = {"Proyecto"},
                    parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "id")}))
    public RouterFunction<ServerResponse> update(UpdateProjectUseCase updateProjectUseCase) {
        Function<ProjectDTO, Mono<ServerResponse>> executor = projectDTO -> updateProjectUseCase.apply(projectDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .bodyValue(result));
        return route(
                PUT("/updateProject").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProjectDTO.class).flatMap(executor)
        );
    }

    //Eliminar un proyecto
//    @Bean
//    public RouterFunction<ServerResponse> delete(DeleteProjectUseCase deleteProjectUseCase) {
//        return route(
//                DELETE("/deleteProject/{id}").and(accept(MediaType.APPLICATION_JSON)),
//                request -> ServerResponse.accepted()
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(BodyInserters.fromPublisher(deleteProjectUseCase.apply(request.pathVariable("id")), Void.class))
//        );
//    }
}
