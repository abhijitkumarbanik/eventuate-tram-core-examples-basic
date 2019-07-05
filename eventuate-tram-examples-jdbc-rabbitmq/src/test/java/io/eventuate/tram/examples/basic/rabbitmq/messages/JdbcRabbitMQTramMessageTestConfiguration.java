package io.eventuate.tram.examples.basic.rabbitmq.messages;

import io.eventuate.jdbcrabbitmq.TramJdbcRabbitMQConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import({TramJdbcRabbitMQConfiguration.class})
public class JdbcRabbitMQTramMessageTestConfiguration {
}
