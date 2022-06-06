package co.simplon.p25.dessinemoiun.security;

import java.util.UUID;

public final class GandalfJwt {

    private String token;

    private UUID uuid;

    public GandalfJwt() {
	//
    }

    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    public UUID getUuid() {
	return uuid;
    }

    public void setUuid(UUID uuid) {
	this.uuid = uuid;
    }

    @Override
    public String toString() {
	return String.format("Jwt [token=%s, uuid=%s]", "[PROTECTED]", uuid);
    }

}
