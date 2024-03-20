package br.com.impactaproject.ecommerce.entities;

import lombok.Getter;

public enum Profile {

    MEMBER("MEMBER"),
    REGULAR("REGULAR");


    @Getter
    private String description;

    Profile(String description) {
        this.description = description;
    }
}