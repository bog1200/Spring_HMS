package sdtlab.auth_module.service;

import org.springframework.security.oauth2.core.user.OAuth2User;
import sdtlab.auth_module.model.User;

public interface UserService {
    public User createUser(OAuth2User oAuth2User);
}
