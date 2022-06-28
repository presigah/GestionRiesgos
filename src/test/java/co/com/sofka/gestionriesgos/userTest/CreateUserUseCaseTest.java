package co.com.sofka.gestionriesgos.userTest;

import co.com.sofka.gestionriesgos.collections.User;
import co.com.sofka.gestionriesgos.mappers.UserMapper;
import co.com.sofka.gestionriesgos.repositories.UserRepository;
import co.com.sofka.gestionriesgos.usercases.user.CreateUserUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CreateUserUseCaseTest {

    @Mock
    UserRepository userRepository;

    CreateUserUseCase createUserUseCase;

    UserMapper userMapper;

    @BeforeEach
    void setUp() {
        userMapper = new UserMapper();
        createUserUseCase = new CreateUserUseCase(userRepository, userMapper);
    }

    @Test
    void getValidationCreateUserTest() {
        var user = new User();
        user.setIdFirebase("1user");
        user.setRol("Administrador");
        user.setEmail("correo@gmail.com");

        var userReturn = new User();
        userReturn.setId("1");
        userReturn.setIdFirebase("1user");
        userReturn.setRol("Administrador");
        userReturn.setEmail("correo@gmail.com");

        var userDTO = userMapper.userToUserDTO().apply(user);

        when(userRepository.save(any(User.class))).thenReturn(Mono.just(userReturn));

        StepVerifier.create(createUserUseCase.apply(userDTO))
                .expectNext("1")
                .verifyComplete();

        verify(userRepository).save(user);
    }

}