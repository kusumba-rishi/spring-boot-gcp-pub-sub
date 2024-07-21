package com.projects147.google_pub_sub.config;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.AckMode;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class PubSubEventConfiguration {

    /**
     * Create an inbound channel adapter to listen to the subscription
     * and send the messages to message channel
     */
    @Bean
    public PubSubInboundChannelAdapter sampleInboundChannelAdapter(
            @Qualifier("sampleInputMessageChannel") MessageChannel messageChannel,
            PubSubTemplate pubSubTemplate) {
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "SampleSubscription1");
        adapter.setOutputChannel(messageChannel);
        adapter.setAckMode(AckMode.MANUAL);
        adapter.setPayloadType(String.class);
        return adapter;
    }

    /**
     * Create an input message channel for messages arriving from the subscription
     */
    @Bean
    public MessageChannel sampleInputMessageChannel() {
        return new PublishSubscribeChannel();
    }

}
