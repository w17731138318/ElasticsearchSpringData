package starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starter.repository.UserRepository;
import starter.model.User;

import java.util.List;

/**
 * Created by Nasir on 12-09-2015.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getByName(String name) {
        return userRepository.findByName(name);
    }



    public User addMovie(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }


    public User getById(Long id) {
        return userRepository.findOne(id);
    }
}
