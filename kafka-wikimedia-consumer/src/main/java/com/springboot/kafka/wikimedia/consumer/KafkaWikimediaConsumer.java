package com.springboot.kafka.wikimedia.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springboot.kafka.wikimedia.entity.Wikimedia;
import com.springboot.kafka.wikimedia.repository.WikimediaRepository;

@Service
public class KafkaWikimediaConsumer {
    private static final Logger LOGGER =  LoggerFactory.getLogger(KafkaWikimediaConsumer.class);

    @Autowired
    private WikimediaRepository wikimediaRepository;

    @KafkaListener(topics = "wikimedia-recent-change-1", groupId = "wikimedia-consumer-group-1")
    public void consume(String message){
        LOGGER.info("Received : "+message);
        
        Wikimedia wikimedia = new Wikimedia();
        wikimedia.setWikiEventData(message);

        wikimediaRepository.insert(wikimedia);
    }
}
