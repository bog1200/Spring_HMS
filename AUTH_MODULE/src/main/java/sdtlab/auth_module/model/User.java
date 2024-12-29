package sdtlab.auth_module.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Data
public class User {
    // Getters and Setters

    private String name;
    private String email;
    private Set<Role> roles = new HashSet<>();
}