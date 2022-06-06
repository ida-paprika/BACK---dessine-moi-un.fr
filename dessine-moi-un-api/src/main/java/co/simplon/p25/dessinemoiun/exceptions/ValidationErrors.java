package co.simplon.p25.dessinemoiun.exceptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Encapsulates global and field {@code ValidationError}s. <b>Global errors</b>
 * are backed by a {@code Collection} of {@code ValidationError}s; <b>field
 * errors</b> by a {@code Map} where the field name is the key and its related
 * errors a {@code Collection} of {@code ValidationError}s.
 */
final class ValidationErrors {

    private final Collection<ValidationError> globalErrors;

    private final Map<String, Collection<ValidationError>> fieldErrors;

    /**
     * Creates a new {@code ValidationErrors}.
     */
    ValidationErrors() {
	globalErrors = new ArrayList<>();
	fieldErrors = new HashMap<>();
    }

    /**
     * Adds a global error to this {@code ValidationErrors} with given error
     * code.
     *
     * @param code an error code
     * @throws NullPointerException if {@code code} is {@code null}
     */
    void addGlobalError(String code) {
	globalErrors.add(new ValidationError(code));
    }

    /**
     * Adds a field error to this {@code ValidationErrors} with given field name
     * and error code.
     *
     * @param name a field name
     * @param code an error code
     * @throws NullPointerException if either {@code name} or {@code code} is
     *                              {@code null}
     */
    void addFieldError(String name, String code) {
	Collection<ValidationError> errors = init(name);
	errors.add(new ValidationError(code));
    }

    private Collection<ValidationError> init(String name) {
	Collection<ValidationError> errors = fieldErrors.get(name);
	if (errors == null) {
	    errors = new ArrayList<>();
	    fieldErrors.put(name, errors);
	}
	return errors;
    }

    /**
     * Returns an immutable view of the global errors.
     *
     * @return an immutable view of the global errors
     */
    public Collection<ValidationError> getGlobalErrors() {
	return Collections.unmodifiableCollection(globalErrors);
    }

    /**
     * Returns an immutable view of the field errors.
     *
     * @return an immutable view of the field errors
     */
    public Map<String, Collection<ValidationError>> getFieldErrors() {
	return Collections.unmodifiableMap(fieldErrors);
    }

    @Override
    public String toString() {
	return String.format("{globalErrors=%s, fieldErrors=%s}",
		globalErrors.size(), fieldErrors.size());
    }
}
