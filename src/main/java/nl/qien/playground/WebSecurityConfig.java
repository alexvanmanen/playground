package nl.qien.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("user")
                    .password(passwordEncoder().encode("Welkom01!"))
                    .roles("USER")

                    .and()

                    .withUser("alex")
                    .password(passwordEncoder().encode("alex"))
                    .roles("USER", "ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

        protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/", "/home").access("hasRole('USER')")
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .and()
                    // some more method calls
                    .formLogin();

    }
}
