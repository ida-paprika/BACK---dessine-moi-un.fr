package co.simplon.p25.dessinemoiun.dtos.profile;

public class ProfileNamesView {

    private String firstName;
    private String lastName;

    public ProfileNamesView() {
	//
    }

    public ProfileNamesView(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
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
	return String.format("ProfileNamesView [firstName=%s, lastName=%s]",
		firstName, lastName);
    }

}
