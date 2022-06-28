package co.com.sofka.gestionriesgos.userTest;

import co.com.sofka.gestionriesgos.collections.User;
import co.com.sofka.gestionriesgos.mappers.UserMapper;
import co.com.sofka.gestionriesgos.repositories.UserRepository;
import co.com.sofka.gestionriesgos.usercases.user.GetAllUsersUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class GetAllUsersUseCaseTest {

    @Mock
    UserRepository userRepository;

    UserMapper userMapper;

    GetAllUsersUseCase getAllUsersUseCase;

    @BeforeEach
    void setup() {
        userMapper = new UserMapper();
        getAllUsersUseCase = new GetAllUsersUseCase(userRepository, userMapper);
    }

    @Test
    void getAllUsersTest(){
        var user = new User();
        user.setId("1");
        user.setIdFirebase("User 1");
        user.setEmail("email 1");
        user.setRol("rol 1");

        when(userRepository.findAll()).thenReturn(Flux.just(user));

        StepVerifier.create(getAllUsersUseCase.get())
                .expectNextMatches(userDTO -> {
                    assert userDTO.getId().equals("1");
                    assert userDTO.getEmail().equals("email 1");
                    assert userDTO.getRol().equals("rol 1");
                    assert userDTO.getIdFirebase().equals("User 1");
                    return true;
                }).verifyComplete();

        verify(userRepository).findAll();
    }

}