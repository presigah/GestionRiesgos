package co.com.sofka.gestionriesgos.mappers;

import co.com.sofka.gestionriesgos.collections.User;
import co.com.sofka.gestionriesgos.model.UserDTO;
import com.mongodb.Function;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public Function<UserDTO, User> userDtoToUser(String id){
        return userDto -> {
            var user = new User();
            user.setId(id);
            user.setIdFirebase(userDto.getIdFirebase());
            user.setRol(userDto.getRol());
            user.setEmail(userDto.getEmail());
            return user;
        };
    }

    public Function<User, UserDTO> userToUserDTO(){
        return user -> new UserDTO(
                user.getId(),
                user.getIdFirebase(),
                user.getRol(),
                user.getEmail()
        );
    }
}
