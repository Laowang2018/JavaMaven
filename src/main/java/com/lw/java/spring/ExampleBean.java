package com.lw.java.spring;

import java.beans.ConstructorProperties;

public class ExampleBean {

    private int years;
    private String name;

    @ConstructorProperties({"years", "name"})
    public ExampleBean(int years, String name) {
        this.years = years;
        this.name = name;
    }
}
