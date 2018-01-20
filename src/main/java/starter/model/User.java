package starter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

/**
 * Created by Nasir on 12-09-2015.
 * indexName：索引 ==mysql的数据库
 * type：类型 ==mysql的表
 * Documents：mysql的一行数据 一个json对象 每个document可包含多个field
 * Fields：对应mysql的列
 * shards：碎片
 * replicas：备份
 * Relational DB  ⇒ Databases ⇒ Tables  ⇒ Rows      ⇒ Columns
 * Elasticsearch  ⇒ Indices   ⇒ Types   ⇒ Documents ⇒ Fields
 */
@Document(indexName = "springboot", type = "user", shards = 5, replicas = 1)
public class User {

    @Id
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
