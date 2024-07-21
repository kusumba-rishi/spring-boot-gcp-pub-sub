package com.projects147.google_pub_sub.activator;

import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage;
import com.projects147.google_pub_sub.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class EventMessageActivator {

    @ServiceActivator(inputChannel = Constants.EVENT_CHANNEL_SAMPLE_INPUT_MESSAGE_CHANNEL)
    public void listenSampleEvents(String payload, @Header(Constants.GCP_PUBSUB_ORIGINAL_MESSAGE)
    BasicAcknowledgeablePubsubMessage message) {
        log.info("message: {}", message);
        log.info("payload: {}", payload);
        message.ack();
    }

}
