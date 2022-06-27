package co.com.sofka.gestionriesgos.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String id;
    private String idFirebase;
    private String rol = "Lector";
    private String email;
}
