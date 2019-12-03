package com.example.kafkaproducderwithkstream.producer;

/**
 * created by lovedeep in com.example.kafkaproducderwithkstream.producer
 */


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.example.kafkaproducderwithkstream.Interface.KafkaBindings;
import com.example.kafkaproducderwithkstream.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProducerForUser implements ApplicationRunner {
    private final Log log = LogFactory.getLog(this.getClass());
    private final List<String> pages = Arrays.asList("google", "facebook", "linkdien", "stackoverflow", "wikipedia", "about", "colophon");
    private final List<String> users = Arrays.asList("bootle", "watter", "iphone", "sangha", "lovedeep");
    private final MessageChannel out;

    public ProducerForUser(KafkaBindings binding) {
        this.out = binding.pageViewEventsOut();
    }

    public void run(ApplicationArguments args) throws Exception {
        Runnable runnable = () -> {
								User pageViewEvent = new User(random(this.users), random(this.pages));
								Message<User> message = MessageBuilder
									.withPayload(pageViewEvent)
									.setHeader(KafkaHeaders.MESSAGE_KEY, pageViewEvent.getName().getBytes())
									.build();
								try {
										this.out.send(message);
										this.log.info("sent " + pageViewEvent.getName());
								}
								catch (Exception e) {
										this.log.error(e);
								}
						};
						Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
        }

        private static <T> T random(List<T> ts) {
            return ts.get(new Random().nextInt(ts.size()));
        }
}
