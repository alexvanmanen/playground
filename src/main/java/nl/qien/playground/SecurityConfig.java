//package nl.qien.playground;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.StandardPasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.inMemoryAuthentication().withUser("user")
//                .password(passwordEncoder().encode("password")).roles("USER");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
////                .antMatchers("/", "/home").access("hasRole('USER')")
////                .antMatchers("/admin/**").hasRole("ADMIN")
//                .and().formLogin();
//                //.loginPage("/login/login.html").permitAll();
//    }
//
//
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth)
////            throws Exception {
////        auth .jdbcAuthentication()
////                .dataSource(dataSource) .usersByUsernameQuery(
////                "select username, password, enabled from Users " +
////                        "where username=?") .authoritiesByUsernameQuery(
////                "select username, authority from UserAuthorities " +
////                        "where username=?")
////                .passwordEncoder(new StandardPasswordEncoder("53cr3t");
////    }
//}
