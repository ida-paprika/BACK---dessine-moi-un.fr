package co.simplon.p25.dessinemoiun.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.p25.dessinemoiun.entities.Artist;
import co.simplon.p25.dessinemoiun.entities.Profile;
import co.simplon.p25.dessinemoiun.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByArtist(Artist artist);

    List<Project> findAllByProfile(Profile profile);

}
