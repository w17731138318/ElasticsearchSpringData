package starter.api;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import starter.model.User;

import java.util.Map;

/**
 * Created by nasir on 14/11/17.
 */
@RestController
public class ElasticResource {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @GetMapping("/elastic/details")
    public ResponseEntity<Map<String, String>> getElasticInformation() {

        Client client = elasticsearchOperations.getClient();
        Map<String, String> asMap = client.settings().getAsMap();
        return ResponseEntity.ok(asMap);
    }

    @PutMapping("/elastic/clear-indices")
    public void clearIndices() {
        elasticsearchTemplate.deleteIndex(User.class);
        elasticsearchTemplate.createIndex(User.class);
        elasticsearchTemplate.putMapping(User.class);
        elasticsearchTemplate.refresh(User.class);
    }
}
