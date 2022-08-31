package school.hei.helloworldapi.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import school.hei.helloworldapi.model.User;
import school.hei.helloworldapi.repository.UserRepository;
import school.hei.helloworldapi.security.model.AppUserDetails;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public AppUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(username+" not found.");
        }
        return new AppUserDetails(user.get());
    }
}
