package br.com.impactaproject.ecommerce.entities;

import lombok.Getter;

@Getter
public enum Profile {

    MEMBER("ROLE_MEMBER"),
    REGULAR("ROLE_REGULAR");


    private String description;

    Profile(String description) {
        this.description = description;
    }
}