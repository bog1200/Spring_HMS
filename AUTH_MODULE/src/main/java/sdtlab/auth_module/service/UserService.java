package sdtlab.auth_module.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import sdtlab.auth_module.model.Role;
import sdtlab.auth_module.model.User;

import java.util.Collection;

@Service
public class UserService {

    public User createUser(OAuth2User oAuth2User) {
        User user = new User();
        // Set user attributes from OAuth2User
        user.setName(oAuth2User.getAttribute("name"));
        user.setEmail(oAuth2User.getAttribute("email"));
        Collection<? extends GrantedAuthority> authorities = oAuth2User.getAuthorities();
        // if empty set default role
        if (authorities.isEmpty()) {
            user.getRoles().add(Role.ROLE_PATIENT);
        } else {
            // Set roles from authorities
            for (GrantedAuthority authority : authorities) {
                user.getRoles().add(Role.valueOf(authority.getAuthority()));
            }
        }
        return user;
    }
}