package com.projects147.google_pub_sub.activator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage;
import com.projects147.google_pub_sub.model.MovieMessagePayload;
import com.projects147.google_pub_sub.service.MovieEventsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import static com.projects147.google_pub_sub.constant.Constants.GCP_PUBSUB_MESSAGE_HEADER;
import static com.projects147.google_pub_sub.constant.Constants.MOVIES_INPUT_MESSAGE_CHANNEL;

@Component
@RequiredArgsConstructor
@Slf4j
public class MoviesEventMessageActivator {

    private final MovieEventsService movieEventsService;
    private final ObjectMapper objectMapper;

    @ServiceActivator(inputChannel = MOVIES_INPUT_MESSAGE_CHANNEL)
    public void processMoviesEvents(String payload,
                                    @Header(GCP_PUBSUB_MESSAGE_HEADER) BasicAcknowledgeablePubsubMessage message) throws JsonProcessingException {
        log.info("MessageId: {} received on subscription: {}", message.getPubsubMessage().getMessageId(), message.getProjectSubscriptionName().getSubscription());
        log.info("Message Payload: {}", payload);
        MovieMessagePayload movieMessagePayload = objectMapper.readValue(payload, MovieMessagePayload.class);
        log.info("MovieMessagePayload: {}", movieMessagePayload);
        try {
            movieEventsService.processEvents(movieMessagePayload);
            log.info("Acknowledged Message: {}", message.getPubsubMessage().getMessageId());
            message.ack();
        } catch (Exception e) {
            log.info("Negative Acknowledged Message: {}", message.getPubsubMessage().getMessageId());
            message.nack();
        }
    }

}
