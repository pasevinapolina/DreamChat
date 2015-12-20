package by.bsu.fpmi.pasevina.listenit.handlers.impl;

import by.bsu.fpmi.pasevina.listenit.handlers.PasswordMatches;
import by.bsu.fpmi.pasevina.listenit.models.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {}
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        User user = (User) obj;
        if (user == null) {
            return false;
        }
        if (user.getPassword() == null || user.getMatchingPassword() == null) {
            return false;
        }
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
