package starter.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import starter.model.User;

import java.util.List;

/**
 * Created by Nasir on 12-09-2015.
 */
public interface UserRepository extends ElasticsearchRepository<User, Long> {

    List<User> findByName(String name);
}
