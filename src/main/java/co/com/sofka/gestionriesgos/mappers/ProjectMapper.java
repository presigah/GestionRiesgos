package co.com.sofka.gestionriesgos.mappers;

import co.com.sofka.gestionriesgos.collections.Project;
import co.com.sofka.gestionriesgos.model.ProjectDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class ProjectMapper {

    public Function<ProjectDTO, Project> mapperToProject(String id){
        return updatePorject -> {
            var project = new Project();
            project.setId(id);
            project.setName(updatePorject.getName());
            project.setStartDate(updatePorject.getStartDate());
            project.setEndingDate(updatePorject.getEndingDate());
            project.setLabels(updatePorject.getLabels());
            project.setEmails(updatePorject.getEmails());
            project.setDescription(updatePorject.getDescription());
            return project;
        };
    }

    public Function<Project, ProjectDTO> EntityToProjectDTO(){
        return entity -> new ProjectDTO(
                entity.getId(),
                entity.getName(),
                entity.getStartDate(),
                entity.getEndingDate(),
                entity.getLabels(),
                entity.getEmails(),
                entity.getDescription()
        );
    }
}
