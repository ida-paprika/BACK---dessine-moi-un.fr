package co.simplon.p25.dessinemoiun.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.p25.dessinemoiun.dtos.project.ProjectCreate;
import co.simplon.p25.dessinemoiun.dtos.project.ProjectUpdate;
import co.simplon.p25.dessinemoiun.dtos.project.ProjectView;
import co.simplon.p25.dessinemoiun.services.ProjectService;

@RestController
@RequestMapping("projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
	this.service = service;
    }

    @GetMapping("/price")
    public int getEstimatedPrice(@RequestParam(name = "mediumId") Long mediumId,
	    @RequestParam(name = "formatId") Long formatId) {
	return service.getEstimatedPrice(mediumId, formatId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProject(@Valid @RequestBody ProjectCreate inputs) {
	service.create(inputs);
    }

    @GetMapping("/artist")
    public List<ProjectView> getArtistProjects() {
	return service.getArtistProjects();
    }

    @GetMapping("/orderer")
    public List<ProjectView> getOrdererProjects() {
	return service.getOrdererProjects();
    }

    @PatchMapping("/accept")
    public void acceptProject(@RequestBody Long projectId) {
	service.acceptProject(projectId);
    }

    @PatchMapping
    public void updateProject(@Valid @RequestBody ProjectUpdate inputs) {
	service.update(inputs);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable("id") Long projectId) {
	service.deleteProject(projectId);
    }

}
