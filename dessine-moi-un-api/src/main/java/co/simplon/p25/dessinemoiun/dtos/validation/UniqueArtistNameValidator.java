package co.simplon.p25.dessinemoiun.dtos.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.p25.dessinemoiun.repositories.ArtistRepository;

public class UniqueArtistNameValidator
	implements ConstraintValidator<UniqueArtistName, String> {

    private final ArtistRepository artistRepo;

    public UniqueArtistNameValidator(ArtistRepository artistRepo) {
	this.artistRepo = artistRepo;
    }

    @Override
    public boolean isValid(String artistName,
	    ConstraintValidatorContext context) {
	return artistName != null && !artistRepo
		.findByArtistNameIgnoreCase(artistName).isPresent();
    }

}
