package co.simplon.p25.dessinemoiun.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.p25.dessinemoiun.entities.ArtFormat;

public interface ArtFormatRepository extends JpaRepository<ArtFormat, Long> {

    <T> List<T> findAllProjectedByOrderByLabel(Class<T> type);

}
