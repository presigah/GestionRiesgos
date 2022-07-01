package co.com.sofka.gestionriesgos.usercases.user;

import co.com.sofka.gestionriesgos.collections.User;
import co.com.sofka.gestionriesgos.mappers.UserMapper;
import co.com.sofka.gestionriesgos.model.UserDTO;
import co.com.sofka.gestionriesgos.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateUserUseCase implements SaveUser {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public CreateUserUseCase(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Mono<String> apply(UserDTO userDTO) {

        return userRepository.findById(userDTO.getIdFirebase())
                .switchIfEmpty(userRepository.save(userMapper.userDtoToUser(userDTO.getIdFirebase()).apply(userDTO)))
                .map(User::getId);

//        return userRepository.save(userMapper.userDtoToUser(userDTO.getIdFirebase()).apply(userDTO))
//                .map(User::getId);
    }
}
