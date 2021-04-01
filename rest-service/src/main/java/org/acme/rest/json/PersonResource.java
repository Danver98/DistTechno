package org.acme.rest.json;

import org.acme.rest.json.models.Person;
import org.jboss.resteasy.annotations.jaxrs.PathParam;


import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


@Path("/persons")
public class PersonResource {

    private Set<Person> persons = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public PersonResource(){
        persons.add(new Person(1,"Alex","Ivanov", LocalDate.of(2000,05,30)));
        persons.add(new Person(2,"Ivan","Petrov", LocalDate.of(1990,3,21)));
        persons.add(new Person(3,"Mark","Sidorov", LocalDate.of(1980,11,9)));
    }

    @GET
    public Set<Person> getAll(){
        return this.persons;
    }

    @GET
    @Path("{id}")
    public String getById(PathParam id){
        return "Hello World";
        /*for(Person p: persons){
            if(Integer.parseInt(String.valueOf(id)) == p.getId())
                return p;
        }
        return null;*/
    }

    @GET
    @Path("some")
    public String get(PathParam id){
        return "Hello World";
        /*for(Person p: persons){
            if(Integer.parseInt(String.valueOf(id)) == p.getId())
                return p;
        }
        return null;*/
    }

    @POST
    public Set<Person> create(Person p){
        this.persons.add(p);
        return this.persons;
    }

    /*@PUT
    public void update(Person person){
        for(Person p: persons){
                if(person.getId() == p.getId()){
                    persons.remove(p);
                    persons.add(person);
                    break;
                }
        }
    }*/

    @DELETE
    public void delete(Person p){
        this.persons.removeIf(existingPerson -> existingPerson.getId() == p.getId());
    }



}