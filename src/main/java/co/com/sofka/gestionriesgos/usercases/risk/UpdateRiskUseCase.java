package co.com.sofka.gestionriesgos.usercases.risk;

import co.com.sofka.gestionriesgos.collections.History;
import co.com.sofka.gestionriesgos.collections.Risk;
import co.com.sofka.gestionriesgos.mappers.RiskMapper;
import co.com.sofka.gestionriesgos.model.RiskDTO;
import co.com.sofka.gestionriesgos.repositories.HistoryRepository;
import co.com.sofka.gestionriesgos.repositories.RiskRepository;
import co.com.sofka.gestionriesgos.usercases.project.GetProjectUseCase;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Service
@Validated
public class UpdateRiskUseCase implements SaveRisk{

    private final RiskRepository riskRepo;
    private final RiskMapper riskMapper;
    private final HistoryRepository historyRepository;
    private final GetProjectUseCase getProjectUseCase;

    public UpdateRiskUseCase(RiskMapper riskMapper, RiskRepository riskRepo,
                             HistoryRepository historyRepository, GetProjectUseCase getProjectUseCase) {
        this.riskRepo = riskRepo;
        this.riskMapper = riskMapper;
        this.historyRepository = historyRepository;
        this.getProjectUseCase = getProjectUseCase;
    }

    public Mono<String> apply(RiskDTO riskDTO){
        Objects.requireNonNull(riskDTO.getId(), "Id of the risk is required");
        return riskRepo
                .save(riskMapper.RiskDTOTORisk(riskDTO.getId()).apply(riskDTO))
                .flatMap(risk -> getProjectUseCase.apply(risk.getProjectId()))
                .flatMap(projectDTO -> {
                    History history = new History(null, LocalDate.now(), LocalTime.now(), projectDTO);
                    return historyRepository.save(history);
                })
                .map(History::getId);
    }
}
