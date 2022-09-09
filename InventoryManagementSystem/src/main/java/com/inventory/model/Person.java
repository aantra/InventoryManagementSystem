package com.inventory.model;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Person {
    protected final String id;
    protected final String name;

    public Person(final String id, final String name) {
        this.id = id;
        this.name = name;
    }
}