package model;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class SampleConsumer {

    public SampleConsumer() {

        Properties properties= new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "test");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer kafkaConsumer= new KafkaConsumer(properties);
        KafkaConsumer kafkaConsumer1= new KafkaConsumer(properties);

        kafkaConsumer.subscribe(Arrays.asList("ihub"));
        kafkaConsumer1.subscribe(Arrays.asList("ihub"));


        try {
            while (true) {

                ConsumerRecords consumerRecords = kafkaConsumer1.poll(100);
                for (Object records : consumerRecords) {
                    System.out.println(records.toString());
                }
            }
        }catch (Exception e){

        }
    }
}
