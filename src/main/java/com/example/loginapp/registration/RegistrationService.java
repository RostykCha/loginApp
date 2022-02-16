package com.example.loginapp.registration;

import com.example.loginapp.appuser.AppUser;
import com.example.loginapp.appuser.AppUserRole;
import com.example.loginapp.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("invalid email");
        }
        return appUserService.signUpUSer
                (new AppUser(
                                request.getFirstName(),
                                request.getLastName(),
                                request.getEmail(),
                                request.getPassword(),
                                AppUserRole.USER
                        )

                );
    }
}
