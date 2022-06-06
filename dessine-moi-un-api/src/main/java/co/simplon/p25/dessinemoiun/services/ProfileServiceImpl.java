package co.simplon.p25.dessinemoiun.services;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import co.simplon.p25.dessinemoiun.dtos.profile.ProfileNamesUpdate;
import co.simplon.p25.dessinemoiun.dtos.profile.ProfileNamesView;
import co.simplon.p25.dessinemoiun.entities.Profile;
import co.simplon.p25.dessinemoiun.repositories.ProfileRepository;
import co.simplon.p25.dessinemoiun.security.SecurityHelper;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepo;

    public ProfileServiceImpl(ProfileRepository profileRepo) {
	this.profileRepo = profileRepo;
    }

    @Override
    public ProfileNamesView updateProfileNames(
	    @Valid ProfileNamesUpdate userInputs) {
	Profile entity = getActualUserProfile();
	entity.setFirstName(StringUtils.capitalize(userInputs.getFirstName()));
	entity.setLastName(StringUtils.capitalize(userInputs.getLastName()));

	profileRepo.save(entity);
	return new ProfileNamesView(entity.getFirstName(),
		entity.getLastName());

    }

    @Override
    public ProfileNamesView getProfileNames() {
	Profile entity = getActualUserProfile();
	return new ProfileNamesView(entity.getFirstName(),
		entity.getLastName());
    }

    private Profile getActualUserProfile() {
	UUID uuid = UUID.fromString(SecurityHelper.authenticatedProfileUuid());
	Profile profile = profileRepo.findOneByUuid(uuid);
	return profile;
    }

}
