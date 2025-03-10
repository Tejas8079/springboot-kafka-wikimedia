package com.springboot.kafka.producer;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;


public class WikimediaChangeHandler implements BackgroundEventHandler {

    // private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangeHandler.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    private String topicName;

    public WikimediaChangeHandler(KafkaTemplate<String, String> kafkaTemplate, String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
//        LOGGER.info(String.format("Event data -> %s", messageEvent.getData()));
        kafkaTemplate.send(topicName, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
