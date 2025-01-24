# Kafka in Spring Boot

## App props

```properties
# Consumers
spring.kafka.consumer.bootstrap-servers: <host1:port1>,<host2:port2>,<host13:port3>
spring.kafka.consumer.group-id: <group_id>
spring.kafka.consumer.auto-offset-reset: earliest

spring.kafka.consumer.key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer: org.apache.kafka.common.serialization.StringDeserializer

# Producers
spring.kafka.producer.bootstrap-servers: <host1:port1>,<host2:port2>,<host13:port3>
spring.kafka.producer.key-serializer: org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer: org.apache.kafka.common.serialization.StringSerializer
```

