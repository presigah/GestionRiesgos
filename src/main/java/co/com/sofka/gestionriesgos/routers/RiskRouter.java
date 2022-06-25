package co.com.sofka.gestionriesgos.routers;

import co.com.sofka.gestionriesgos.model.RiskDTO;
import co.com.sofka.gestionriesgos.usercases.CreateRiskUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RiskRouter {

    @Bean
    public RouterFunction<ServerResponse> create(CreateRiskUseCase createRiskUseCase) {
        Function<RiskDTO, Mono<ServerResponse>> executor = riskDTO ->  createRiskUseCase.apply(riskDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .bodyValue(result));

        return route(
                POST("/createRisk").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RiskDTO.class).flatMap(executor)
        );
    }
}
