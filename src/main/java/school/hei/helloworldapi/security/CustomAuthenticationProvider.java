package school.hei.helloworldapi.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import school.hei.helloworldapi.model.User;
import school.hei.helloworldapi.repository.UserRepository;

import java.util.Arrays;

/**
 * This class provides a different for authentication which Spring Security uses
 */
@AllArgsConstructor
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private UserRepository repository;

    /**
     * The authenticate method is where you define how to authenticate.
     * Here, it is a simple comparison, but you can add more filters and mechanisms
     * Like a BCrypt hash for example, and you would match the password with the hash in your database
     * @param authentication
     * @return
     * @throws BadCredentialsException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws BadCredentialsException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = repository.findByUsername(name)
                .orElse(null);

        if(user != null && user.getPassword().equals(password)){
                return new UsernamePasswordAuthenticationToken(name, password, Arrays.asList(user.getRole()));
        }else{
            throw new BadCredentialsException("Invalid credentials, please check your password and username.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
