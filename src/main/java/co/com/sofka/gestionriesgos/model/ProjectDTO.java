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
    @NotBlank(message = "La fecha de inicio del proyecto es requerida")
    private LocalDate startDate;
    private LocalDate endingDate;
    private List<String> labels;
    @NotBlank(message = "El correo del proyecto es requerido")
    private List<String> emails;
    @NotBlank(message = "La descripción del proyecto es requerida")
    private String description;
}
