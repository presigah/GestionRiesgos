package co.com.sofka.gestionriesgos.usercases.risk;

import co.com.sofka.gestionriesgos.model.RiskDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface SaveRisk {
    Mono<String> apply(@Valid RiskDTO riskDTO);
}
