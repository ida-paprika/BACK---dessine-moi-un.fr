package co.simplon.p25.dessinemoiun.dtos.profile;

import java.util.UUID;

public class ProfileUuid {

    private UUID uuid;

    public ProfileUuid() {
	//
    }

    public UUID getUuid() {
	return uuid;
    }

    @Override
    public String toString() {
	return String.format("ProfileUuid [uuid=%s]", "[PROTECTED]");
    }

}
