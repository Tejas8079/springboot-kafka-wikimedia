package com.springboot.kafka.wikimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.kafka.producer.WikimediaChangesProducer;

@SpringBootApplication(scanBasePackages = "com.springboot.kafka")
public class SpringBootKafkaProducerApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaProducerApplication.class, args);
    }

    @Autowired(required=true)
    private WikimediaChangesProducer wikimediaProducer;

    @Override
    public void run(String... args) throws Exception {
        wikimediaProducer.sendMessage();
    }
}