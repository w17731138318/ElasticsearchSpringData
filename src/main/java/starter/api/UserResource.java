package starter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import starter.model.User;
import starter.service.UserService;

import java.net.URI;
import java.util.List;

/**
 * Created by nasir on 14/11/17.
 */
@RestController
@RequestMapping("/es")
public class UserResource {

    private UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User addMovie(@RequestBody User user) {
        User saved = userService.addMovie(user);
        return saved;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable("id") Long id) {
        userService.delete(id);
    }
    @GetMapping("/get/{id}")
    public User findMovieByName(@PathVariable("id") Long id) {
        User user = userService.getById(id);

        return user;
    }
    @GetMapping("/getbyname/{name}")
    public List<User> findMovieByName(@PathVariable("name") String name) {
        List<User> list = userService.getByName(name);
        return list;
    }
}
