package sdtlab.auth_module.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sdtlab.auth_module.model.User;
import sdtlab.auth_module.service.UserService;
import sdtlab.auth_module.service.UserServiceImpl;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login/home")
    public String home(@AuthenticationPrincipal OAuth2User principal, Model model) {
        // Add user name to the model
        User user = userService.createUser(principal);
        model.addAttribute("name", principal.getAttribute("name"));
        model.addAttribute("email", principal.getAttribute("email"));
        model.addAttribute("roles", user.getRoles());
        System.out.println(principal);
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}