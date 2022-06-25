package co.com.sofka.gestionriesgos.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "projects")
public class Project {

    @Id
    private String id;
    private String name;
    private LocalDate startDate;
    private LocalDate endingDate;
    private List<String> labels;
    private List<String> emails;
    private String description;

}
