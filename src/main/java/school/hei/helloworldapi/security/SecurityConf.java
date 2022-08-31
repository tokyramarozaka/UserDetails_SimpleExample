package school.hei.helloworldapi.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import school.hei.helloworldapi.security.model.Role;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConf extends WebSecurityConfigurerAdapter {
    private CustomAuthenticationProvider authProvider;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/hello").permitAll()
                .antMatchers(HttpMethod.GET,"/students/**").hasAnyRole(Role.STUDENT.getRole(), Role.MANAGER.getRole())
                .antMatchers(HttpMethod.POST, "/students/**").hasRole(Role.MANAGER.getRole())
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }
}
