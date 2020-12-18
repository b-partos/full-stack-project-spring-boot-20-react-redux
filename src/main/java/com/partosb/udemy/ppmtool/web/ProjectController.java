package com.partosb.udemy.ppmtool.web;

import com.partosb.udemy.ppmtool.domain.Project;
import com.partosb.udemy.ppmtool.services.MapValidationErrorService;
import com.partosb.udemy.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {


        final ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (null != errorMap) return errorMap;

        return new ResponseEntity<>(projectService.saveOrUpdateProject(project), HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId) {

        Project project = projectService.findProjectByIdentifier(projectId);

        return new ResponseEntity<>(project, HttpStatus.OK);

    }

    @GetMapping("/all")
    public Iterable<Project> getAllProjects() {
        System.out.println("All request recieved.");
        return projectService.findAllProjects();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId) {
        projectService.deleteProjectByIdentifier(projectId);

        return new ResponseEntity<>("Project with ID: '" + projectId + "' was deleted.", HttpStatus.OK);
    }


}
