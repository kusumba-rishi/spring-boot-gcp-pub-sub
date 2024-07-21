package com.projects147.google_pub_sub.activator;

import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class EventMessageActivator {

    /**
     * Define what happens to the messages that arrive to
     * message channel - sampleInputMessageChannel
     */
    @ServiceActivator(inputChannel = "sampleInputMessageChannel")
    public void listenSampleEvents(String payload, @Header("gcp_pubsub_original_message")
    BasicAcknowledgeablePubsubMessage message) {
        log.info("message: {}", message);
        log.info("payload: {}", payload);
        message.ack();
    }

}
