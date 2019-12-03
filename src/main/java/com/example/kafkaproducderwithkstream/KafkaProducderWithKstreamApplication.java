package com.example.kafkaproducderwithkstream;

import com.example.kafkaproducderwithkstream.Interface.KafkaBindings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({KafkaBindings.class})
@SpringBootApplication
public class KafkaProducderWithKstreamApplication {
    public KafkaProducderWithKstreamApplication() {
    }
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducderWithKstreamApplication.class, args);
    }

}
