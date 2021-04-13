package org.acme.rest.json;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.acme.rest.json.models.Person;
import org.jboss.resteasy.annotations.jaxrs.PathParam;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;


@RegisterForReflection
@Path("/persons")
public class PersonResource {

    private Set<Person> persons = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
    private int id= 0;

    public PersonResource(){
        persons.add(new Person(1,"Alex","Ivanov", LocalDate.of(2000,5,30)));
        persons.add(new Person(2,"Ivan","Petrov", LocalDate.of(1990,3,21)));
        persons.add(new Person(3,"Mark","Sidorov", LocalDate.of(1980,11,9)));
        id = persons.size() + 1;
    }

    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public Set<Person> getAll(){
        return this.persons;
    }

    @GET
    @Path("/{id}")
    public Person getById(@PathParam int id){
        for(Person p: persons){
            if(id == p.getId())
                return p;
        }
        return null;
    }

    @POST
    public Response create(Person p) throws URISyntaxException {
        this.persons.add(p);
        return Response.created(new URI("/persons/" +p.getId())).build();
    }

    @PUT
    public void update(Person person){
        for(Person p: persons){
                if(person.getId() == p.getId()){
                    persons.remove(p);
                    persons.add(person);
                    break;
                }
        }
    }

    @DELETE
    public void delete(Person p){
        this.persons.removeIf(existingPerson -> existingPerson.getId() == p.getId());
    }


    @DELETE
    public void deleteById(@PathParam int id){
        this.persons.removeIf(existingPerson -> existingPerson.getId() == id);
    }
}