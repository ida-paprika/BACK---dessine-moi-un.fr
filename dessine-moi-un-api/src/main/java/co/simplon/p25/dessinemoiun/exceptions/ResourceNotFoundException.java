package co.simplon.p25.dessinemoiun.exceptions;

import org.springframework.security.authentication.BadCredentialsException;

@SuppressWarnings("serial")
public final class ResourceNotFoundException extends BadCredentialsException {

    public ResourceNotFoundException(String message) {
	super(message);
    }
}
