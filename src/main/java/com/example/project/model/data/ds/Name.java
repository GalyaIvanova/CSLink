package com.example.project.model.data.ds;

import jakarta.persistence.Embeddable;
import org.springframework.lang.NonNull;

@Embeddable
public class Name {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // getters and setters
}
