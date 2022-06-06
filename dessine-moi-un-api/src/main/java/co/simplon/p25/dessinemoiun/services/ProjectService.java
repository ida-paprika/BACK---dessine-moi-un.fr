package co.simplon.p25.dessinemoiun.services;

import java.util.List;

import javax.validation.Valid;

import co.simplon.p25.dessinemoiun.dtos.project.ProjectCreate;
import co.simplon.p25.dessinemoiun.dtos.project.ProjectUpdate;
import co.simplon.p25.dessinemoiun.dtos.project.ProjectView;

public interface ProjectService {

    void create(@Valid ProjectCreate inputs);

    void update(@Valid ProjectUpdate inputs);

    int getEstimatedPrice(Long mediumId, Long formatId);

    List<ProjectView> getArtistProjects();

    List<ProjectView> getOrdererProjects();

    void deleteProject(Long projectId);

    void acceptProject(Long projectId);

}
