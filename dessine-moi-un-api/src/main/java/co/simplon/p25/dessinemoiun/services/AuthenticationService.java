package co.simplon.p25.dessinemoiun.services;

import javax.validation.Valid;

import co.simplon.p25.dessinemoiun.dtos.artist.ArtistCreate;
import co.simplon.p25.dessinemoiun.dtos.profile.ProfileCreate;
import co.simplon.p25.dessinemoiun.dtos.profile.ProfileEmail;
import co.simplon.p25.dessinemoiun.dtos.profile.ProfileLogin;
import co.simplon.p25.dessinemoiun.dtos.profile.ResetPassword;
import co.simplon.p25.dessinemoiun.security.Jwt;

public interface AuthenticationService {

    void createOrderer(@Valid ProfileCreate userInputs);

    void createArtist(@Valid ArtistCreate userInputs);

    Jwt login(ProfileLogin userInputs);

    void lostPassword(@Valid ProfileEmail email);

    void resetPassword(@Valid ResetPassword inputs);

}
