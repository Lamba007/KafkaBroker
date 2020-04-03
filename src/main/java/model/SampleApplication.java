package model;

import example.customeExceptions.IllegalTopicException;
import io.netty.util.internal.StringUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SampleApplication {

    String topic;
    String keyName;
    String value;

    public SampleApplication(String topic, String keyName, String value) throws IllegalTopicException {

        if(StringUtil.isNullOrEmpty(topic)){
            throw new IllegalTopicException("topic is blank");
        }
        else {
            this.topic=topic;
        }

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("retries","2");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        ProducerRecord producerRecord = new ProducerRecord(topic, value);
        KafkaProducer kafkaProducer = new KafkaProducer(properties);

        for(int i=1;i<10;i++){

            kafkaProducer.send(producerRecord);
        }
        kafkaProducer.close();
    }
}
