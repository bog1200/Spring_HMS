package sdtlab.auth_module.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import sdtlab.auth_module.model.Role;
import sdtlab.auth_module.model.User;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    public User createUser(OAuth2User oAuth2User) {
        User user = new User();
        // Set user attributes from OAuth2User
        user.setName(oAuth2User.getAttribute("name"));
        user.setEmail(oAuth2User.getAttribute("email"));
        // Set user roles
        String roles = oAuth2User.getAttribute("role");
        for (String role : roles.split(",")) {
            if (role.equals("user"))
                user.getRoles().add(Role.ROLE_PATIENT);
            else
                user.getRoles().add(Role.valueOf(role));
        }
        System.out.println(user);
        return user;
    }
}