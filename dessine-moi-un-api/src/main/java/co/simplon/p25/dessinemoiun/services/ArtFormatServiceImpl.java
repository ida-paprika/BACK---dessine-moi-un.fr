package co.simplon.p25.dessinemoiun.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.p25.dessinemoiun.dtos.ArtFormatView;
import co.simplon.p25.dessinemoiun.repositories.ArtFormatRepository;

@Service
public class ArtFormatServiceImpl implements ArtFormatService {

    private final ArtFormatRepository formatRepo;

    public ArtFormatServiceImpl(ArtFormatRepository formatRepo) {
	this.formatRepo = formatRepo;
    }

//    @Override
//    public List<ArtFormatView> getAllFormats() {
//	List<ArtFormat> entityList = formatRepo.findAllByOrderByLabelAsc();
//	List<ArtFormatView> dtoList = new ArrayList<ArtFormatView>();
//
//	for (ArtFormat am : entityList) {
//	    ArtFormatView artFormat = new ArtFormatView();
//	    artFormat.setId(am.getId());
//	    artFormat.setLabel(am.getLabel());
//	    dtoList.add(artFormat);
//	}
//
//	return dtoList;
//    }

    @Override
    public List<ArtFormatView> getAllFormats() {
	return formatRepo.findAllProjectedByOrderByLabel(ArtFormatView.class);

    }

}
