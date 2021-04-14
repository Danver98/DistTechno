package ru.krista.uniyar.kafkaintro.models;

import java.util.Objects;

public class Address{
    private String Country;
    private String city;
    private String street;
    private int postalCode;
    private int house;
    private int apartment;

    public Address() {
    }

    public Address(String country, String city, String street, int postalCode, int house, int apartment) {
        Country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.house = house;
        this.apartment = apartment;
    }

    public String getCountry() {
        return Country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public int getHouse() {
        return house;
    }

    public int getApartment() {
        return apartment;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Address address = (Address) object;
        return postalCode == address.postalCode && house == address.house && apartment == address.apartment && Country.equals(address.Country) && city.equals(address.city) && street.equals(address.street);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), Country, city, street, postalCode, house, apartment);
    }
}