package co.com.sofka.gestionriesgos.repositories;

import co.com.sofka.gestionriesgos.collections.Project;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends ReactiveCrudRepository<Project, String> {

}
