package com.pluralsight.enums;

public enum CrustType {

    //declaring my crust type names
    THIN("Thin"),
    REGULAR("Regular"),
    THICK("Thick"),
    CAULIFLOWER("Cauliflower");

    private final String name;

    //my constructor to assign a display name to each crust type
    CrustType(String name) {
        this.name = name;
    }

    //returning the display name of the crust type
    public String getName() {
        return name;
    }

    //returning the display name when the enum is used as a string
    @Override
    public String toString() {
        return name;
    }
}
