package co.simplon.p25.dessinemoiun.security;

public final class Jwt {

    private final String token;

    public Jwt(String token) {
	this.token = token;
    }

    public String getToken() {
	return token;
    }

    @Override
    public String toString() {
	return String.format("Jwt [token=%s]", "[PROTECTED]");
    }

}
