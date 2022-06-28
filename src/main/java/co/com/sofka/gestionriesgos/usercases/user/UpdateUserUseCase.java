package co.com.sofka.gestionriesgos.usercases.user;

import co.com.sofka.gestionriesgos.collections.User;
import co.com.sofka.gestionriesgos.mappers.UserMapper;
import co.com.sofka.gestionriesgos.model.UserDTO;
import co.com.sofka.gestionriesgos.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class UpdateUserUseCase implements SaveUser {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UpdateUserUseCase(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Mono<String> apply(UserDTO userDTO) {
         Objects.requireNonNull(userDTO.getId(), "El id del usuario no puede ser nulo");
        return userRepository.save(userMapper.userDtoToUser(userDTO.getId()).apply(userDTO))
                .map(User::getId);
    }

}
