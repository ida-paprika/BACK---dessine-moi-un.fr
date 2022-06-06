package co.simplon.p25.dessinemoiun.services;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import co.simplon.p25.dessinemoiun.dtos.artist.ArtistCreate;
import co.simplon.p25.dessinemoiun.dtos.profile.LostPassword;
import co.simplon.p25.dessinemoiun.dtos.profile.ProfileCreate;
import co.simplon.p25.dessinemoiun.dtos.profile.ProfileEmail;
import co.simplon.p25.dessinemoiun.dtos.profile.ProfileLogin;
import co.simplon.p25.dessinemoiun.dtos.profile.ProfileUuid;
import co.simplon.p25.dessinemoiun.dtos.profile.ResetPassword;
import co.simplon.p25.dessinemoiun.entities.Artist;
import co.simplon.p25.dessinemoiun.entities.Profile;
import co.simplon.p25.dessinemoiun.repositories.ArtistRepository;
import co.simplon.p25.dessinemoiun.repositories.ProfileRepository;
import co.simplon.p25.dessinemoiun.security.GandalfJwt;
import co.simplon.p25.dessinemoiun.security.Jwt;
import co.simplon.p25.dessinemoiun.security.SecurityHelper;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Value("${dessinemoiun.api.root-uri}")
    private String apiUri;

    private final ProfileRepository profileRepo;

    private final ArtistRepository artistRepo;

    private final RestTemplate gandalf;

    public AuthenticationServiceImpl(ProfileRepository profileRepo,
	    ArtistRepository artistRepo, RestTemplate gandalfRestTemplate) {
	this.profileRepo = profileRepo;
	this.artistRepo = artistRepo;
	this.gandalf = gandalfRestTemplate;
    }

    @Transactional
    @Override
    public void createOrderer(@Valid ProfileCreate userInputs) {
	userInputs.setRole("ROLE_ORDERER");
	Profile newProfile = this.createGandalfUser(userInputs);
	profileRepo.save(newProfile);
    }

    @Transactional
    @Override
    public void createArtist(@Valid ArtistCreate userInputs) {
	ProfileCreate profile = new ProfileCreate(userInputs.getEmail(),
		userInputs.getPassword());

	profile.setRole("ROLE_ARTIST");

	Profile newProfile = this.createGandalfUser(profile);
	profileRepo.save(newProfile);

	Artist newArtist = new Artist(userInputs.getArtistName(), false,
		newProfile);
	artistRepo.save(newArtist);

    }

    @Override
    public Jwt login(ProfileLogin userInputs) throws BadCredentialsException {

	profileRepo.findByEmailIgnoreCase(userInputs.getEmail()).orElseThrow(
		() -> new BadCredentialsException("Profile not found"));

	ResponseEntity<GandalfJwt> response = gandalf
		.postForEntity("/users/login", userInputs, GandalfJwt.class);

	Jwt token = new Jwt(response.getBody().getToken());

	return token;
    }

    @Override
    public void lostPassword(@Valid ProfileEmail email) {
	Profile profile = profileRepo.findByEmailIgnoreCase(email.getEmail())
		.orElseThrow(() -> new BadCredentialsException("Unknown user"));
	LostPassword lostPwd = new LostPassword();

	lostPwd.setUserUuid(profile.getUuid());
	lostPwd.setMailHeader("<h3>Bonjour</h3>");
	lostPwd.setMailFooter("<i>A bientôt sur <a href=\"" + apiUri
		+ "\">Dessine moi un</a></i>");

	gandalf.patchForObject("/users/lost-password", lostPwd, String.class);

    }

    @Override
    public void resetPassword(@Valid ResetPassword inputs) {
	UUID tokenUuid = UUID
		.fromString(SecurityHelper.authenticatedProfileUuid());
	inputs.setUserUuid(tokenUuid);

	gandalf.patchForObject("/users/reset-password", inputs, String.class);
    }

    private Profile createGandalfUser(ProfileCreate profileDto) {
	ResponseEntity<ProfileUuid> response = gandalf
		.postForEntity("/users/create", profileDto, ProfileUuid.class);

	UUID uuid = response.getBody().getUuid();

	return new Profile(uuid, profileDto.getEmail());
    }

}
