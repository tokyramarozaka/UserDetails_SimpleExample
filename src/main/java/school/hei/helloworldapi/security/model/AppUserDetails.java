package school.hei.helloworldapi.security.model;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import school.hei.helloworldapi.model.User;

import java.util.Collection;
import java.util.List;

/**
 * The user and its details as specified by the UserDetails interface of Spring
 * You can add the other fields eventually to check if an account is still working or not.
 */
@AllArgsConstructor
@ToString
public class AppUserDetails implements UserDetails {
    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(user.getRole());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
        return user.getEnabled();
    }
}
