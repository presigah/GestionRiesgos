package co.com.sofka.gestionriesgos.usercases.user;


import co.com.sofka.gestionriesgos.model.UserDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface SaveUser {
    Mono<String> apply(@Valid UserDTO userDTO);
}