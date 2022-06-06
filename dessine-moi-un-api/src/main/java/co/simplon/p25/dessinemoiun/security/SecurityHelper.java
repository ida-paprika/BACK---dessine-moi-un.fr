package co.simplon.p25.dessinemoiun.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityHelper {

    public SecurityHelper() {
	//
    }

    public static String authenticatedProfileUuid() {
	Authentication auth = SecurityContextHolder.getContext()
		.getAuthentication();
	return auth.getName();
    }

}
