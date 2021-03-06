package nl.qien.playground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Test
    public void shouldReturnUsers() throws Exception {
        User user = new User();
        user.setUsername("alex");
        User user2 = new User();
        user.setId(100);
        user2.setUsername("jan");
        userRepository.save(user);
        userRepository.save(user2);

        this.mockMvc.perform(get("/api/user/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].username", is("jan")))
                .andExpect(jsonPath("$.[1].username", is("alex")));
    }
}