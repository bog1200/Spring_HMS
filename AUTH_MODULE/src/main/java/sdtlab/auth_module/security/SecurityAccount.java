package sdtlab.auth_module.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sdtlab.auth_module.model.Role;
import sdtlab.auth_module.model.User;

import java.util.HashSet;
import java.util.Collection;
import java.util.Set;

public class SecurityAccount implements UserDetails {
    private final Set<GrantedAuthority> authorities;
    private final String username;
    public SecurityAccount(User account) {
        this.username = String.valueOf(account.getName());
        Set<GrantedAuthority> auths = new HashSet<>();

        for (Role role : account.getRoles()) {

            auths.add(new SimpleGrantedAuthority(role.toString()));
        }
        this.authorities = auths;
    }

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
}

@Override
public String getPassword() {
    return null;
}

@Override
public String getUsername() {
    return null;
}

@Override
public boolean isAccountNonExpired() {
    return true;
}

@Override
public boolean isAccountNonLocked() {
    return true;
}

@Override
public boolean isCredentialsNonExpired() {
    return true;
}

@Override
public boolean isEnabled() {
    return true;
}
}
