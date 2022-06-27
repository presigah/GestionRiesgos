package co.com.sofka.gestionriesgos.repositories;

import co.com.sofka.gestionriesgos.collections.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, String> {

}
