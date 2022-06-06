package co.simplon.p25.dessinemoiun.dtos.profile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ProfileEmail {

    @NotBlank
    @Email
    private String email;

    public ProfileEmail() {
	//
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    @Override
    public String toString() {
	return String.format("ProfileEmail [email=%s]", email);
    }

}
