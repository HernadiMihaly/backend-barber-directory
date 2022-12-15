package hu.unideb.barbersdirectory.validator;

import hu.unideb.barbersdirectory.model.User;
import hu.unideb.barbersdirectory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> client) {
        return User.class.equals(client);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(userService.findByEmail(user.getEmail())!= null){
            errors.rejectValue("email", "email.duplicated");
        }
    }
}
