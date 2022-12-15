package hu.unideb.barbersdirectory.service;

import hu.unideb.barbersdirectory.model.User;
import org.springframework.security.core.Authentication;

public interface UserService {
    User save(User user);
    User findByEmail(String email);

    Long getUserIdFromAuth(Authentication authentication);
}
