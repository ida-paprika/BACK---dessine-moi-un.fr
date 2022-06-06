package co.simplon.p25.dessinemoiun.services;

import javax.validation.Valid;

import co.simplon.p25.dessinemoiun.dtos.profile.ProfileNamesUpdate;
import co.simplon.p25.dessinemoiun.dtos.profile.ProfileNamesView;

public interface ProfileService {

    ProfileNamesView updateProfileNames(@Valid ProfileNamesUpdate userInputs);

    ProfileNamesView getProfileNames();

}
