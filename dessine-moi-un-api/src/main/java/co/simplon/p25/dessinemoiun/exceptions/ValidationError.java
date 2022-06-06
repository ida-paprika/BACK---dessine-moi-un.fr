package co.simplon.p25.dessinemoiun.exceptions;

import java.util.Objects;

/**
 * Encapsulates global and field {@code ValidationError}s. <b>Global errors</b>
 * are backed by a {@code Collection} of {@code ValidationError}s; <b>field
 * errors</b> by a {@code Map} where the field name is the key and its related
 * errors a {@code Collection} of {@code ValidationError}s.
 */
final class ValidationError {

    private final String code;

    /**
     * Creates a new {@code ValidationError} with given code.
     *
     * @param code a validation error code
     * @throws NullPointerException if {@code code} is {@code null}
     */
    ValidationError(String code) {
	Objects.requireNonNull(code, "code cannot be null");
	this.code = code;
    }

    /**
     * Returns the code of this validation error.
     *
     * @return the code; never {@code null}
     */
    public String getCode() {
	return code;
    }

    @Override
    public String toString() {
	return String.format("{code=%s}", code);
    }
}
