package co.com.sofka.gestionriesgos.usercases.user;

import co.com.sofka.gestionriesgos.mappers.UserMapper;
import co.com.sofka.gestionriesgos.model.UserDTO;
import co.com.sofka.gestionriesgos.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

//@Service
//@Validated
//public class GetAllUsersUseCase implements Supplier<Flux<UserDTO>> {
//    private final UserRepository userRepository;
//    private final UserMapper userMapper;
//
//    public GetAllUsersUseCase(UserRepository userRepository, UserMapper userMapper) {
//        this.userRepository = userRepository;
//        this.userMapper = userMapper;
//    }
//
//    @Override
//    public Flux<UserDTO> get() {
//        return userRepository.findAll().map(userMapper.userToUserDto());
//    }
//
//}
