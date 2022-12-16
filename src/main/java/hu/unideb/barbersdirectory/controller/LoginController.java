package hu.unideb.barbersdirectory.controller;

import hu.unideb.barbersdirectory.model.User;
import hu.unideb.barbersdirectory.service.UserService;
import hu.unideb.barbersdirectory.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    private final UserService userService;
    private final UserValidator userValidator;
    private final AuthenticationManager authentication;

    @Autowired
    public LoginController(UserService userService, UserValidator userValidator, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.authentication= authenticationManager;
    }

    @PostMapping("/login")
    @CrossOrigin("http://localhost:4200/")
    public ResponseEntity<HttpStatus> login(@RequestBody User user) throws Exception {

        Authentication authObject;
        System.out.println(user.getEmail() + " " + user.getPassword());
        try{
            authObject = authentication.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail()
                    , user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authObject);
        }catch (BadCredentialsException e){
            throw new Exception("User not found! Please try with another credentials!");
        }

        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
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
