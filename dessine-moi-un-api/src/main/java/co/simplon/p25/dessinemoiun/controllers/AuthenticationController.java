package co.simplon.p25.dessinemoiun.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.p25.dessinemoiun.dtos.artist.ArtistCreate;
import co.simplon.p25.dessinemoiun.dtos.profile.ProfileCreate;
import co.simplon.p25.dessinemoiun.dtos.profile.ProfileEmail;
import co.simplon.p25.dessinemoiun.dtos.profile.ProfileLogin;
import co.simplon.p25.dessinemoiun.dtos.profile.ResetPassword;
import co.simplon.p25.dessinemoiun.security.Jwt;
import co.simplon.p25.dessinemoiun.services.AuthenticationService;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
	this.service = service;
    }

    @PostMapping("/create-orderer")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody ProfileCreate userInputs) {
	service.createOrderer(userInputs);
    }

    @PostMapping("/create-artist")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody ArtistCreate userInputs) {
	service.createArtist(userInputs);
    }

    @PostMapping("/login")
    public Jwt loginUser(@Valid @RequestBody ProfileLogin userInputs) {
	return service.login(userInputs);
    }

    @PatchMapping("/lost-password")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void lostPassword(@Valid @RequestBody ProfileEmail email) {
	service.lostPassword(email);
    }

    @PatchMapping("/reset-password")
    public void ResetPassword(@Valid @RequestBody ResetPassword inputs) {
	service.resetPassword(inputs);
    }

}
