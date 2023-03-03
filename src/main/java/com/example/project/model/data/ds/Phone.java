package com.example.project.model.data.ds;

import jakarta.persistence.Embeddable;
import org.springframework.lang.NonNull;

@Embeddable
public class Phone {

    private String countryCode;
    private String areaCode;

    @NonNull
    private String number;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
