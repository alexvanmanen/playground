package nl.qien.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserRepository userRepository;
//org.springframework.data.jpa.repository.support.SimpleJpaRepository@35858c5a
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<User> getUsers(){
       return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer  id) throws SQLIntegrityConstraintViolationException {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not find id:" +id ));
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
