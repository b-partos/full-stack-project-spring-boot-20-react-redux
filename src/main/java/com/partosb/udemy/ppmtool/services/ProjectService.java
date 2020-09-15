package com.partosb.udemy.ppmtool.services;

import com.partosb.udemy.ppmtool.domain.Project;
import com.partosb.udemy.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {

        // Logic

        return projectRepository.save(project);
    }

}
