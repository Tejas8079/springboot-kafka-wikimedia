package com.springboot.kafka.wikimedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.springboot.kafka.wikimedia.repository")
public class SpringKafkaWikimediaConsumer {
    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaWikimediaConsumer.class, args);
    }
}