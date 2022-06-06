package co.simplon.p25.dessinemoiun.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.p25.dessinemoiun.dtos.profile.ProfileNamesUpdate;
import co.simplon.p25.dessinemoiun.dtos.profile.ProfileNamesView;
import co.simplon.p25.dessinemoiun.services.ProfileService;

@RestController
@RequestMapping("profiles")
public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service) {
	this.service = service;
    }

    @GetMapping("/names")
    public ProfileNamesView getProfileNames() {
	return service.getProfileNames();
    }

    @PatchMapping("/update-names")
    public ProfileNamesView updateProfileNames(
	    @Valid @RequestBody ProfileNamesUpdate userInputs) {
	System.out.println(userInputs);
	return service.updateProfileNames(userInputs);
    }

}
