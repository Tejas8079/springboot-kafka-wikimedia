package com.springboot.kafka.producer;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.StreamException;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WikimediaChangesProducer {

    @SuppressWarnings("unused")
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;


    public WikimediaChangesProducer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws StreamException, InterruptedException {
        String topicName = "wikimedia-recent-change-1";

        // to read realtime stream data from wikimedia, use event source
        BackgroundEventHandler backgroundEventHandler = new WikimediaChangeHandler(kafkaTemplate, topicName);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        // Create EventSource.Builder
        EventSource.Builder eventSourceBuilder = new EventSource.Builder(
                URI.create(url));

        // Create BackgroundEventSource
        BackgroundEventSource eventSource = new BackgroundEventSource.Builder(backgroundEventHandler,
                eventSourceBuilder)
                .build();

        // Start the event source
        eventSource.start();

        TimeUnit.MINUTES.sleep(2);

    }
}
