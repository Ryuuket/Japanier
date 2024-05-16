package co.simplon.japanier.japanierbusiness.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NonExistentValidator.class)
public @interface NonExistent {
    String message() default "{Already exists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
