package co.simplon.p25.dessinemoiun.dtos.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UniqueArtistNameValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueArtistName {
    String message() default "artist_name_exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
