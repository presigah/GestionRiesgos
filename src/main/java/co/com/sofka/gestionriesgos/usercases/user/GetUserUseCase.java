package co.com.sofka.gestionriesgos.usercases.user;

import co.com.sofka.gestionriesgos.mappers.UserMapper;
import co.com.sofka.gestionriesgos.model.UserDTO;
import co.com.sofka.gestionriesgos.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import java.util.Objects;

@Service
@Validated
public class GetUserUseCase implements Function<String, Mono<UserDTO>> {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public GetUserUseCase(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Mono<UserDTO> apply(String id) {
        Objects.requireNonNull(id, "Id is required");
        return userRepository.findById(id)
                .map(userMapper.userToUserDTO()).
                        flatMap(mapUserAggregate());
    }

    private Function<UserDTO, Mono<UserDTO>> mapUserAggregate() {
        return Mono::just;
    }
}
