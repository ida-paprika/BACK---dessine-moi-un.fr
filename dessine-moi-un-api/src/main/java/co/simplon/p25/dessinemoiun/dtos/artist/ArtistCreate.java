package co.simplon.p25.dessinemoiun.dtos.artist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import co.simplon.p25.dessinemoiun.dtos.validation.UniqueArtistName;
import co.simplon.p25.dessinemoiun.dtos.validation.UniqueEmail;

public class ArtistCreate {

    @UniqueArtistName(message = "Ce nom d'artist est déjà pris")
    @NotBlank
    @Size(min = 2, max = 50)
    private String artistName;

    @UniqueEmail(message = "Cet email existe déjà")
    @NotBlank
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")
    private String password;

    public ArtistCreate() {
	//
    }

    public String getArtistName() {
	return artistName;
    }

    public void setArtistName(String artistName) {
	this.artistName = artistName;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String toString() {
	return String.format(
		"ArtistCreate [artistName=%s, email=%s, password=%s]",
		artistName, email, "[PROTECTED]");
    }

}
