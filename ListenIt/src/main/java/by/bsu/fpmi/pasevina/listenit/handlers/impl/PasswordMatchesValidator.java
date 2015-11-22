package by.bsu.fpmi.pasevina.listenit.handlers.impl;

import by.bsu.fpmi.pasevina.listenit.dao.UserDao;
import by.bsu.fpmi.pasevina.listenit.handlers.PasswordMatches;
import by.bsu.fpmi.pasevina.listenit.models.User;
import org.springframework.validation.ValidationUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        User user = (User) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
