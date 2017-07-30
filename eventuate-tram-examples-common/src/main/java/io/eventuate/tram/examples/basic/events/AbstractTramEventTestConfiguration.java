package io.eventuate.tram.examples.basic.events;

import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.examples.basic.events.domain.AccountDebited;
import io.eventuate.tram.messaging.consumer.MessageConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Collections;

import static java.util.Collections.singleton;

@Configuration
@Import(TramEventsPublisherConfiguration.class)
public class AbstractTramEventTestConfiguration {

  @Bean
  public AbstractTramEventTestConfig abstractTramEventTestConfig() {
    return new AbstractTramEventTestConfig();
  }

  @Bean
  public DomainEventDispatcher domainEventDispatcher(AbstractTramEventTestConfig config, TramEventTestEventConsumer target, MessageConsumer messageConsumer) {
    return new DomainEventDispatcher("eventDispatcherId" + config.getUniqueId(),
            Collections.singletonMap(config.getAggregateType(),
                    singleton(AccountDebited.class.getName())),
            target, messageConsumer);
  }

  @Bean
  public TramEventTestEventConsumer tramEventTestTarget() {
    return new TramEventTestEventConsumer();
  }


}
