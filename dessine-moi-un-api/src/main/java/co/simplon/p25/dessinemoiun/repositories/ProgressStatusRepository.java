package co.simplon.p25.dessinemoiun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.p25.dessinemoiun.entities.ProgressStatus;

public interface ProgressStatusRepository
	extends JpaRepository<ProgressStatus, Long> {

}
