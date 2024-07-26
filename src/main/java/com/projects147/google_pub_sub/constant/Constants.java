package com.projects147.google_pub_sub.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final String MOVIES_INPUT_MESSAGE_CHANNEL = "moviesInputMessageChannel";
    public static final String GCP_PUBSUB_MESSAGE_HEADER = "gcp_pubsub_original_message";

}
