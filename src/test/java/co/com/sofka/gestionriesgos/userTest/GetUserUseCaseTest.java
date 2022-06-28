package co.com.sofka.gestionriesgos.userTest;

import co.com.sofka.gestionriesgos.collections.User;
import co.com.sofka.gestionriesgos.mappers.UserMapper;
import co.com.sofka.gestionriesgos.repositories.UserRepository;
import co.com.sofka.gestionriesgos.usercases.user.GetUserUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class GetUserUseCaseTest {

    @Mock
    UserRepository userRepository;

    UserMapper userMapper;

    GetUserUseCase getUserUseCase;

    @BeforeEach
    void setup() {
        userMapper = new UserMapper();
        getUserUseCase = new GetUserUseCase(userRepository, userMapper);
    }

    @Test
    void setGetUserUseCaseTest() {
        var user = new User();
        user.setId("1");
        user.setIdFirebase("Usuario 1");
        user.setEmail("correo");
        user.setRol("Administrador");

        when(userRepository.findById(user.getId())).thenReturn(Mono.just(user));

        StepVerifier.create(getUserUseCase.apply(user.getId()))
                .expectNext(user)
                .verifyComplete();

        verify(userRepository).findById(user.getId());
    }

}