package com.example.kafkaproducderwithkstream.Interface;

/**
 * created by lovedeep in com.example.kafkaproducderwithkstream.Interface
 */

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface KafkaBindings {

    String PAGE_VIEW_OUT = "pveo";

    @Output("pveo")
    MessageChannel pageViewEventsOut();
}
