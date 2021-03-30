package com.danver.serialization;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String surname;
    private int age;
    private boolean isMarried;
    private Address address;
    private Phone phone;

    public Person(){
    }

    public Person(String name,String surname, int age, boolean isMarried, Address address,Phone phone){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isMarried = isMarried;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && isMarried == person.isMarried && name.equals(person.name) && surname.equals(person.surname) && Objects.equals(address, person.address) && Objects.equals(phone, person.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, isMarried, address, phone);
    }
}