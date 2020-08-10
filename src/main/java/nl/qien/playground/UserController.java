package nl.qien.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<User> getUsers(){
        userRepository.findByName("alex");
       return userRepository.findAllUsers(Sort.by("name"));
    }

    @PostMapping("/")
    public User add() {
        User user = new User();
        user.setName("alex");
        return userRepository.save(user);
    }

    @PutMapping("/")
    public User update() {
        User user = userRepository.findById(0).get();
        user.setName("xxxx");
        return userRepository.save(user);
    }

    @DeleteMapping("/")
    public void delete() {
        jdbcTemplate.execute("DELETE FROM USER");
    }
}
