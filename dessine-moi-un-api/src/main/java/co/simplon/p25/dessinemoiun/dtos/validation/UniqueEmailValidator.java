package co.simplon.p25.dessinemoiun.dtos.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.p25.dessinemoiun.repositories.ProfileRepository;

public class UniqueEmailValidator
	implements ConstraintValidator<UniqueEmail, String> {

    private final ProfileRepository profilesRepo;

    public UniqueEmailValidator(ProfileRepository profilesRepo) {
	this.profilesRepo = profilesRepo;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
	return email != null
		&& !profilesRepo.findByEmailIgnoreCase(email).isPresent();

    }

}
