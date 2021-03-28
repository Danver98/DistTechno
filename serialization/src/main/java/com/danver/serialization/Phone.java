package com.danver.serialization;

//import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;
    private String number;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "%Y-%m-%d")
    private LocalDate creationDate;

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
}
