package co.com.sofka.gestionriesgos.collections;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "risks")
public class Risk {
    @Id
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

    @NotBlank
    private Integer state = 1;
}
