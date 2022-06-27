package co.com.sofka.gestionriesgos.usercases.project;

import co.com.sofka.gestionriesgos.model.ProjectDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface SaveProject {
    Mono<String> apply(@Valid ProjectDTO projectDTO);
}
