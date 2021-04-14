package ru.krista.uniyar.kafkaintro.models;

import java.time.LocalDate;
import java.util.Objects;

public class Person{
    private String name;
    private String surname;
    /*private LocalDate birthdate;
    private Address address;*/

    public Person() {
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /*public Person(String name, String surname, LocalDate birthdate, Address address) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.address = address;
    }*/

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    /*public LocalDate getBirthdate() {
        return birthdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Person person = (Person) object;
        return name.equals(person.name) && surname.equals(person.surname) && birthdate.equals(person.birthdate) && Objects.equals(address, person.address);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, birthdate, address);
    }
*/}