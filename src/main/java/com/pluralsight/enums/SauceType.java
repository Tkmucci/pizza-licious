package com.pluralsight.enums;

public enum SauceType {

    MARINARA("Marinara"),
    ALFREDO("Alfredo"),
    PESTO("Pesto"),
    BBQ("BBQ"),
    BUFFALO("Buffalo"),
    OLIVE_OIL("Olive Oil");

    private String sauceName;

    SauceType(String sauceName) {
        this.sauceName = sauceName;
    }

    public String getSauceName() {
        return sauceName;
    }

    @Override
    public String toString() {

        return sauceName;
    }

}
