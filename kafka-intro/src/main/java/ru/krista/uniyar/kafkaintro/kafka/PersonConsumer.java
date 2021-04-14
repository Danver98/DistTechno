package ru.krista.uniyar.kafkaintro.kafka;

import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;
import ru.krista.uniyar.kafkaintro.models.Address;
import ru.krista.uniyar.kafkaintro.models.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;

@ApplicationScoped
public class PersonConsumer {
    private final Logger logger = Logger.getLogger(PersonConsumer.class);
    @Incoming("person-in")
    public void receive(Record<String,String> record){
        logger.infof("Got a person: %s - %s ", record.key(), record.value());
    }
}
