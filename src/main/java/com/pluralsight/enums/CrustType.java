package com.pluralsight.enums;

public enum CrustType {

    THIN("Thin");
    REGULAR("Regula");
    THICK("Thick");
    CAULIFLOWER("Cauliflower");

    private final String name;

    CrustType(String name){

        this.name = name;
    }
    public String getName() {

        return name;
    }

    @Override
    public String toString() {

        return name;
    }
}
