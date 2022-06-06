package co.simplon.p25.dessinemoiun.dtos.profile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProfileNamesUpdate {

    @NotBlank
    @Size(min = 2, max = 20)
//    @Pattern(regexp = "^[A-Za-z0-9çéè-]+$")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 50)
//    @Pattern(regexp = "^[A-Za-z0-9çéè-]+$")
    private String lastName;

    public ProfileNamesUpdate() {
	//
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    @Override
    public String toString() {
	return String.format("ProfileNames [firstName=%s, lastName=%s]",
		firstName, lastName);
    }

}
