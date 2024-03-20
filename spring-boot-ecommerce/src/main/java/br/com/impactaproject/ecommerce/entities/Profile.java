package br.com.impactaproject.ecommerce.entities;

import lombok.Getter;

public enum Profile {

    MEMBER("member"),
    REGULAR("regular");


    @Getter
    private String description;

    Profile(String description) {
        this.description = description;
    }
}