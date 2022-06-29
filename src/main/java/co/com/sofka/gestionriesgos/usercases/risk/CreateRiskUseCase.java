package co.com.sofka.gestionriesgos.usercases.risk;

import co.com.sofka.gestionriesgos.collections.Risk;
import co.com.sofka.gestionriesgos.mappers.RiskMapper;
import co.com.sofka.gestionriesgos.model.RiskDTO;
import co.com.sofka.gestionriesgos.repositories.RiskRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateRiskUseCase implements SaveRisk{
    private final RiskRepository riskRepo;
    private final RiskMapper riskMapper;

    public CreateRiskUseCase(RiskMapper riskMapper, RiskRepository riskRepo) {
        this.riskRepo = riskRepo;
        this.riskMapper = riskMapper;
    }

    public Mono<String> apply(RiskDTO riskDTO) {
        if(riskDTO.getDetectedDate().isBefore(riskDTO.getEndedDate()) || riskDTO.getDetectedDate().isEqual(riskDTO.getEndedDate())) {
            return riskRepo
                    .save(riskMapper.RiskDTOTORisk(null).apply(riskDTO))
                    .map(Risk::getId);
        }
        return Mono.error(new IllegalArgumentException("La fecha de inicio debe ser igual o anterior a la fecha de finalización"));
        //        return riskRepo
//                .save(riskMapper.RiskDTOTORisk(null).apply(riskDTO))
//                .map(Risk::getId);
    }
}
