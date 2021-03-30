package com.danver.serialization;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private int postalCode;
    private String country;
    private String city;
    private String street;
    private int houseNumber;
    private int apartmentNumber;

    public Address(){

    }

    public Address(int postalCode, String country, String city, String street, int houseNumber, int apartmentNumber) {
        this.postalCode = postalCode;
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return postalCode == address.postalCode && houseNumber == address.houseNumber && apartmentNumber == address.apartmentNumber && Objects.equals(country, address.country) && Objects.equals(city, address.city) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode, country, city, street, houseNumber, apartmentNumber);
    }
}
