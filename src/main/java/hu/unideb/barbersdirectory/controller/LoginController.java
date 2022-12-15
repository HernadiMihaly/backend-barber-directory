package hu.unideb.barbersdirectory.controller;

import hu.unideb.barbersdirectory.model.User;
import hu.unideb.barbersdirectory.service.UserService;
import hu.unideb.barbersdirectory.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    private final UserService userService;
    private final UserValidator userValidator;

    @Autowired
    public LoginController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }


    @GetMapping("/login")
    @CrossOrigin("http://localhost:4200/")
    public String login() {
        return "success";
    }

    @PostMapping("/register")
    @CrossOrigin("http://localhost:4200/")
    public ResponseEntity<User> processRegistration(@RequestBody User user, BindingResult bindingResult) throws Exception {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new Exception("Bad form!");
        }
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


}
