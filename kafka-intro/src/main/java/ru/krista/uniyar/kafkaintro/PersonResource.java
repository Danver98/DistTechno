package ru.krista.uniyar.kafkaintro;

import ru.krista.uniyar.kafkaintro.kafka.PersonProducer;
import ru.krista.uniyar.kafkaintro.models.Person;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/persons")
public class PersonResource {
    @Inject
    public PersonProducer producer;

    private Set<Person> persons = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public PersonResource(){
        persons.add(new Person("Ivan","Ivanov"));
        persons.add(new Person("Petr","Petrov"));
        persons.add(new Person("Vasily","Vasilyev"));
    }

    @GET
    public Set<Person> getAll(){
        return persons;
    }

    @POST
    public Response sendInfo(Person p){
        producer.sendPerson(p);
        return Response.accepted().build();
    }
}
