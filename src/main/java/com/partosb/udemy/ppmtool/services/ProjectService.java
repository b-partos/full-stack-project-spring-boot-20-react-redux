package com.partosb.udemy.ppmtool.services;

import com.partosb.udemy.ppmtool.domain.Project;
import com.partosb.udemy.ppmtool.exceptions.ProjectIdException;
import com.partosb.udemy.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists.");
        }

    }

    public Project findProjectByIdentifier(String projectId) {
        final Project project = projectRepository.findByProjectIdentifier(projectId);

        checkExistenceWithMessage(project, "Project ID '" + projectId + " doesn't exist.");

        return project;
    }

    public Iterable<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    protected void checkExistenceWithMessage(Project project, String message) {

        if ( null == project ) {
            throw  new ProjectIdException(message);
        }
    }


    public void deleteProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId);

        checkExistenceWithMessage(project, "Cannot delete Project with ID '" + projectId + "'. Id not found.");

        projectRepository.delete(project);

    }


}
