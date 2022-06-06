package co.simplon.p25.dessinemoiun.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.p25.dessinemoiun.dtos.ArtMediumView;
import co.simplon.p25.dessinemoiun.repositories.ArtMediumRepository;

@Service
public class ArtMediumServiceImpl implements ArtMediumService {

    private final ArtMediumRepository mediumRepo;

    public ArtMediumServiceImpl(ArtMediumRepository mediumRepo) {
	this.mediumRepo = mediumRepo;
    }

    @Override
    public List<ArtMediumView> getAllMediums() {
	return mediumRepo.findAllProjectedByOrderByLabel(ArtMediumView.class);
    }

}
