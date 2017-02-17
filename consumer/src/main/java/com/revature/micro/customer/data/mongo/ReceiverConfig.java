package com.revature.micro.customer.data.mongo;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
public class ReceiverConfig {

    @Value("${kafka.bootstrap.servers}") //TODO add kafka server to your application.properties
    private String bootstrapServers;

    @SuppressWarnings({ "rawtypes", "unchecked", "resource" })
	@Bean
    public Map consumerConfigs() {
        Map props = new HashMap<>();
        // list of host:port pairs used for establishing the initial connections
        // to the Kakfa cluster
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServers);
        // Deserialize the key that identifies the Kafka message
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                IntegerDeserializer.class);
        // Deserialize the value of the Kafka message
        // This example uses JSON messaging 
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                new CustomerDeserializer().getClass()); 
        				// TODO use your JSONDeserializer to let Spring unwrap the Kafka message into a bean
        // consumer groups allow a pool of processes to divide the work of
        // consuming and processing records
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "helloworld");

        return props;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
    public ConsumerFactory consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
    public ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}