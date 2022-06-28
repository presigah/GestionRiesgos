package co.com.sofka.gestionriesgos.userTest;

import co.com.sofka.gestionriesgos.collections.User;
import co.com.sofka.gestionriesgos.mappers.UserMapper;
import co.com.sofka.gestionriesgos.repositories.UserRepository;
import co.com.sofka.gestionriesgos.usercases.user.UpdateUserUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UpdateUserUseCaseTest {

    @Mock
    UserRepository userRepository;

    UpdateUserUseCase updateUserUseCase;

    UserMapper userMapper;

    @BeforeEach
    public void setup() {
        userMapper = new UserMapper();
        updateUserUseCase = new UpdateUserUseCase(userRepository, userMapper);
    }

    @Test
    void updateUserUseCase() {
        var user = new User();
        user.setId("1");
        user.setIdFirebase("1user");
        user.setRol("Administrador");
        user.setEmail("correo@gmail.com");

        var userReturn = new User();
        userReturn.setId("1");
        userReturn.setIdFirebase("1user");
        userReturn.setRol("Administrador");
        userReturn.setEmail("correo@gmail.com");

        var userDTO = userMapper.userToUserDTO().apply(user);

        when(userRepository.findById("1")).thenReturn(Mono.just(user));
        when(userRepository.save(user)).thenReturn(Mono.just(userReturn));

        StepVerifier.create(updateUserUseCase.apply(userDTO))
                .expectNext("1")
                .verifyComplete();

        verify(userRepository).save(refEq(user));
    }
}
