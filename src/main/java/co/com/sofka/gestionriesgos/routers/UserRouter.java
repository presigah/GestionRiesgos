package co.com.sofka.gestionriesgos.routers;


import co.com.sofka.gestionriesgos.model.ProjectDTO;
import co.com.sofka.gestionriesgos.model.UserDTO;
import co.com.sofka.gestionriesgos.usercases.project.UpdateProjectUseCase;
import co.com.sofka.gestionriesgos.usercases.user.CreateUserUseCase;
import co.com.sofka.gestionriesgos.usercases.user.GetAllUsersUseCase;
import co.com.sofka.gestionriesgos.usercases.user.GetUserUseCase;
import co.com.sofka.gestionriesgos.usercases.user.UpdateUserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
public class UserRouter {

    //Consultar Todos los usuarios
    @Bean
    @RouterOperation(beanClass = GetAllUsersUseCase.class, beanMethod = "get",
            operation = @Operation(operationId = "Consultar", summary = "Consultar todos los usuarios", tags = {"Usuario"}))
    public RouterFunction<ServerResponse> getAllUsers(GetAllUsersUseCase getAllUsersUseCase) {
        return route(GET("/getAllUsers"), request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllUsersUseCase.get(), UserDTO.class)));
    }

    //Consultar un usuario por su id en mongo
    @Bean
    @RouterOperation(beanClass = GetUserUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "ConsultarById", summary = "Consultar Usuario por ID", tags = {"Usuario"},
                    parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "String")},
                    responses = {@ApiResponse(responseCode = "200", description = "successful operation",
                            content = @Content(schema = @Schema(implementation = UserDTO.class))),
                            @ApiResponse(responseCode = "400", description = "Invalid user supplied"),
                            @ApiResponse(responseCode = "404", description = "User not found")}))
    public RouterFunction<ServerResponse> getUsertByIdMongo(GetUserUseCase getUserUseCase) {
        return route(
                GET("/getUser/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getUserUseCase.apply(
                                        request.pathVariable("id")),
                                UserDTO.class
                        ))
        );
    }

    //Crear Usuario
    @Bean
    @RouterOperation(beanClass = CreateUserUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "UserDTO", summary = "Crear Usuario", tags = {"Usuario"},
                    responses = {@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = UserDTO.class))),
                            @ApiResponse(responseCode = "400", description = "Invalid User supplied"),
                            @ApiResponse(responseCode = "404", description = "User not found")}))
    public RouterFunction<ServerResponse> create(CreateUserUseCase createUserUseCase) {
        Function<UserDTO, Mono<ServerResponse>> executor = userDTO -> createUserUseCase.apply(userDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .bodyValue(result));
        return route(
                POST("/createUser").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UserDTO.class).flatMap(executor)
        );
    }

    //Modificar Usuario
    @Bean
    @RouterOperation(beanClass = UpdateUserUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "Modificar", summary = "Modificar Usuario", tags = {"Usuario"},
                    parameters = {@Parameter(in = ParameterIn.PATH, name = "rol", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "email", description = "String")},
                    responses = {@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = UserDTO.class))),
                            @ApiResponse(responseCode = "400", description = "Invalid user supplied"),
                            @ApiResponse(responseCode = "404", description = "User not found")}))
    public RouterFunction<ServerResponse> update(UpdateUserUseCase updateUserUseCase) {
        Function<UserDTO, Mono<ServerResponse>> executor = userDTO -> updateUserUseCase.apply(userDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .bodyValue(result));
        return route(
                PUT("/updateUser").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UserDTO.class).flatMap(executor)
        );
    }
}
