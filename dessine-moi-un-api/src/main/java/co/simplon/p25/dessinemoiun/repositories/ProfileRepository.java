package co.simplon.p25.dessinemoiun.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.p25.dessinemoiun.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByEmailIgnoreCase(String email);

    Profile findOneByUuid(UUID uuid);

}
