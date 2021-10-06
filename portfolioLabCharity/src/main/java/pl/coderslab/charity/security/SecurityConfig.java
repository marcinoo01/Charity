package pl.coderslab.charity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.charity.service.UserDetailsServiceImplementation;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public SecurityConfig(UserDetailsServiceImplementation userDetailsServiceImplementation) {
        this.userDetailsServiceImplementation = userDetailsServiceImplementation;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    private final UserDetailsServiceImplementation userDetailsServiceImplementation;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImplementation);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasAnyAuthority("ROLE_USER")
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/successLogin",true);
    }
}
