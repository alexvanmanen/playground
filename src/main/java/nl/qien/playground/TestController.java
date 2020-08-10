package nl.qien.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public String getTest(){
        throw new NullPointerException();
//        User user = new User();
//        user.setId(1);
//        user.setName("alex");
//        userRepository.save(user);
//        return userRepository.findAll().get(0).getName();
    }

//    @PostMapping("/add")
//    public String postTask(@RequestParam(name = "name") String name, @RequestParam(name = "age") String age) {
//        System.out.println(name + age);
//        return "<html><H1>"+name + age + "</H1></html>";
//    }

    @PostMapping("/")
    public Task postTask(@RequestBody Task task) {
        return task;
    }
}
