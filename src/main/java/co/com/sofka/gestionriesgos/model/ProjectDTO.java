package co.com.sofka.gestionriesgos.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private String id;
    @NotBlank(message = "El nombre del proyecto es requerido")
    private String name;
    private LocalDate startDate = LocalDate.now();
    private LocalDate endingDate;
    private List<String> labels;
    private List<String> emails;
    @NotBlank(message = "La descripción del proyecto es requerida")
    private String description;
    private String status;
    private List<RiskDTO> risks;

    public ProjectDTO(String id, String name, LocalDate startDate, LocalDate endingDate, List<String> labels, List<String> emails, String description, String status) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endingDate = endingDate;
        this.labels = labels;
        this.emails = emails;
        this.description = description;
        this.status = status;
    }

    public List<RiskDTO> getRisks() {
        this.risks = Optional.ofNullable(risks).orElse(new ArrayList<>());
        return risks;
    }
}
