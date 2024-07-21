package com.projects147.google_pub_sub.config;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.AckMode;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.MessageChannel;

import static com.projects147.google_pub_sub.constant.Constants.EVENT_CHANNEL_SAMPLE_INPUT_MESSAGE_CHANNEL;

@Configuration
public class PubSubEventConfiguration {

    @Bean
    public PubSubInboundChannelAdapter sampleInboundChannelAdapter(
            @Qualifier(EVENT_CHANNEL_SAMPLE_INPUT_MESSAGE_CHANNEL) MessageChannel messageChannel,
            PubSubTemplate pubSubTemplate) {
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "SampleSubscription1");
        adapter.setOutputChannel(messageChannel);
        adapter.setAckMode(AckMode.MANUAL);
        adapter.setPayloadType(String.class);
        return adapter;
    }

    @Bean
    public MessageChannel sampleInputMessageChannel() {
        return new PublishSubscribeChannel();
    }

}
