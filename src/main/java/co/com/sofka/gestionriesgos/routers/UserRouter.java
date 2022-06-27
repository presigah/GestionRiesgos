package co.com.sofka.gestionriesgos.routers;


import co.com.sofka.gestionriesgos.model.UserDTO;
import co.com.sofka.gestionriesgos.usercases.user.GetUserUseCase;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RestController
@Configuration
public class UserRouter {

    //Consultar Todos los usuarios
//    @Bean
//    @RouterOperation(beanClass = GetAllUsersUseCase.class, beanMethod = "get",
//            operation = @Operation(operationId = "Consultar", summary = "Consultar todos los usuarios", tags = {"Usuario"}))
//    public RouterFunction<ServerResponse> getAllUsers(GetAllUsersUseCase getAllUsersUseCase) {
//        return route(GET("/getAllUsers"), request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromPublisher(getAllUsersUseCase.get(), UserDTO.class)));
//    }

    //Consultar un usuario por su id en mongo
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

}
