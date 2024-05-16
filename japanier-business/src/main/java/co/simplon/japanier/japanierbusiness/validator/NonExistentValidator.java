package co.simplon.japanier.japanierbusiness.validator;

import org.springframework.beans.factory.annotation.Autowired;

import co.simplon.japanier.japanierbusiness.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonExistentValidator implements ConstraintValidator<NonExistent, String> {
    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

	return false;
    }

}
