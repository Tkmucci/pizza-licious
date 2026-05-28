package com.pluralsight.enums;

public enum SauceType {

    //declaring the sauce names
    MARINARA("Marinara"),
    ALFREDO("Alfredo"),
    PESTO("Pesto"),
    BBQ("BBQ"),
    BUFFALO("Buffalo"),
    OLIVE_OIL("Olive Oil");

    //my variable
    private String sauceName;

    //my constructor
    SauceType(String sauceName) {
        this.sauceName = sauceName;
    }

    @Override
    public String toString() {

        return sauceName;
    }

}
