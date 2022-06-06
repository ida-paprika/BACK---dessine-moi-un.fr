package co.simplon.p25.dessinemoiun.dtos.profile;

public class ProfileLogin {

    private String email;
    private String password;

    public ProfileLogin() {
	//
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
	return String.format("ProfileLogin [email=%s, password=%s]", email,
		"[PROTECTED]");
    }

}
