package nl.qien.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api/user")
public class AdminController {

    private UserRepository userRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<User> getUsers(){
        userRepository.findByUsername("alex");
       return userRepository.findAllUsers(Sort.by("name"));
    }

    @PostMapping("/")
    public User add() {
        User user = new User();
        user.setUsername("alex");
        return userRepository.save(user);
    }

    @PutMapping("/")
    public User update() {
        User user = userRepository.findById(0).get();
        user.setUsername("xxxx");
        return userRepository.save(user);
    }

    @DeleteMapping("/")
    public void delete() {
        jdbcTemplate.execute("DELETE FROM USER");
    }
}
