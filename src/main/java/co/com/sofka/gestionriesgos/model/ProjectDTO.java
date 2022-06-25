package co.com.sofka.gestionriesgos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private Integer id;
    private String name;
    private LocalDate startDate;
    private LocalDate endingDate;
    private List<String> labels;
    private List<String> emails;
    private String description;
}
