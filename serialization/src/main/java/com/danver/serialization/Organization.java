package com.danver.serialization;


//import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Organization {
    private static final long serialVersionUID = 1L;

    private String name;
    private Address address;
    private List<Person> employees;
    private List<Phone> phones;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "%Y-%m-%d")
    private LocalDate foundationDate;

    public Organization(){
    }

    public Organization(String name, Address address, LocalDate foundationDate) {
        this.name = name;
        this.address = address;
        this.employees = new ArrayList<>();
        this.phones = new ArrayList<>();
        this.foundationDate = foundationDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }


}
