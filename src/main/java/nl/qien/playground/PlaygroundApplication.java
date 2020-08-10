package nl.qien.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

@SpringBootApplication
public class PlaygroundApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PlaygroundApplication.class, args);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        User user = new User();
        user.setUsername("alex");
        user.setPassword(passwordEncoder.encode("alex"));
        userRepository.save(user);
    }
}
