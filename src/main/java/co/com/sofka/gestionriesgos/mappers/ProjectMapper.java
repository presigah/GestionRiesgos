package co.com.sofka.gestionriesgos.mappers;

import co.com.sofka.gestionriesgos.collections.Project;
import co.com.sofka.gestionriesgos.model.ProjectDTO;

import java.util.function.Function;

public class ProjectMapper {

    public Function<ProjectDTO, Project> toProject(){
        return newProject -> {
            var project = new Project();
            project.setName(newProject.getName());
            project.setStartDate(newProject.getStartDate());
            project.setEndingDate(newProject.getEndingDate());
            project.setLabels(newProject.getLabels());
            project.setEmails(newProject.getEmails());
            project.setDescription(newProject.getDescription());
            return project;
        };
    }

    public Function<Project, ProjectDTO> toProjectDTO(){
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
