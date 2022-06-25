package co.com.sofka.gestionriesgos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private String id;
    @NotBlank(message = "El nombre del proyecto es requerido")
    private String name;
    private LocalDate startDate = LocalDate.now();
    private LocalDate endingDate;
    private List<String> labels;
    @NotBlank(message = "El correo del proyecto es requerido")
    private List<String> emails;
    @NotBlank(message = "La descripción del proyecto es requerida")
    private String description;
    private List<RiskDTO> risks;

    public ProjectDTO(String id, String name, LocalDate startDate, LocalDate endingDate, List<String> labels, List<String> emails, String description) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endingDate = endingDate;
        this.labels = labels;
        this.emails = emails;
        this.description = description;
    }
}
