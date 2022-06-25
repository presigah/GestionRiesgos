package co.com.sofka.gestionriesgos.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RiskDTO {

    private String id;

    @NotBlank
    private String projectId;

    @NotBlank
    private String name;

    @NotBlank
    private String userId;

    @NotBlank
    private LocalDate detectedDate = LocalDate.now();

    @NotBlank
    private LocalDate endedDate;

    private List<String> labels;

    @NotBlank
    private String description;

    @NotBlank
    // (Abierto; mitigado; Cerrado; Problema)
    private String risksState;

    @NotBlank
    // (Interna; Externa)
    private String audience;

    @NotBlank
    // (Costo; Tiempo; Calidad)
    private String category;

    @NotBlank
    // (Riesgo de producto o calidad; Riesgo de proyecto)
    private String riskType;

    @NotBlank
    private String detailsRiskType;

    @NotBlank
    private Integer probability;

    @NotBlank
    private Integer impactValue;

    @NotBlank
    private String mitigationPlan;

    private List<String> responsibleMitigationMails;

    @NotBlank
    private String contingencyPlan;

    private List<String> responsibleContingencyMails;

    // ------
    private String projectName;

}
