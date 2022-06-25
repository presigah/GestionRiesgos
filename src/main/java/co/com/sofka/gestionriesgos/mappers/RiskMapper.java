package co.com.sofka.gestionriesgos.mappers;

import co.com.sofka.gestionriesgos.collections.Risk;
import co.com.sofka.gestionriesgos.model.RiskDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RiskMapper {

    public Function<RiskDTO, Risk> RiskDTOTORisk() {
        return updateRisk -> {
            var risk = new Risk();
            risk.setProjectId(updateRisk.getProjectId());
            risk.setName(updateRisk.getName());
            risk.setUserId(updateRisk.getUserId());
            // detectedDate = now
            risk.setEndedDate(updateRisk.getEndedDate());
            risk.setLabels(updateRisk.getLabels());
            risk.setDescription(updateRisk.getDescription());
            risk.setRisksState(updateRisk.getRisksState());
            risk.setAudience(updateRisk.getAudience());
            risk.setCategory(updateRisk.getCategory());
            risk.setRiskType(updateRisk.getRiskType());
            risk.setDetailsRiskType(updateRisk.getDetailsRiskType());
            risk.setProbability(updateRisk.getProbability());
            risk.setImpactValue(updateRisk.getImpactValue());
            risk.setMitigationPlan(updateRisk.getMitigationPlan());
            risk.setResponsibleMitigationMails(updateRisk.getResponsibleMitigationMails());
            risk.setContingencyPlan(updateRisk.getContingencyPlan());
            risk.setResponsibleContingencyMails(updateRisk.getResponsibleContingencyMails());
            // state = 1
            return risk;
        };
    }

    public Function<Risk, RiskDTO> RiskToRiskDTO() {
        return entity -> new RiskDTO(
                entity.getId(),
                entity.getProjectId(),
                entity.getName(),
                entity.getUserId(),
                entity.getDetectedDate(),
                entity.getEndedDate(),
                entity.getLabels(),
                entity.getDescription(),
                entity.getRisksState(),
                entity.getAudience(),
                entity.getCategory(),
                entity.getRiskType(),
                entity.getDetailsRiskType(),
                entity.getProbability(),
                entity.getImpactValue(),
                entity.getMitigationPlan(),
                entity.getResponsibleMitigationMails(),
                entity.getContingencyPlan(),
                entity.getResponsibleContingencyMails(),
                // Aqui debe cambiar por el nombre verdadero del project
                // Cuando este creado el project mientras le dejo
                // el mismo nombre del riesgo
                entity.getName()
        );
    }
}
