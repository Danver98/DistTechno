package com.danver.serialization;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;
    private String number;
    @JsonSerialize(using= LocalDateSerializer.class)
    @JsonDeserialize(using= LocalDateDeserializer.class)
    private LocalDate creationDate;

    public Phone(){

    }

    public Phone(int code, String number, LocalDate creationDate) {
        this.code = code;
        this.number = number;
        this.creationDate = creationDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return code == phone.code && number.equals(phone.number) && Objects.equals(creationDate, phone.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, number, creationDate);
    }
}
