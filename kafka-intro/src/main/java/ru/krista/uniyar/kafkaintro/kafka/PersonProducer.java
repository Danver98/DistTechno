package ru.krista.uniyar.kafkaintro.kafka;

import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import ru.krista.uniyar.kafkaintro.models.Person;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PersonProducer {
    @Inject
    @Channel("person-out")
    Emitter<Record<String,String>> emitter;

    public void sendPerson(Person person){
        emitter.send(Record.of(person.getName(), person.getSurname()));
    }
}
