package io.delivery.service.impl;

import io.delivery.service.Test;

public class TestImpl implements Test {
    private String s;
    public TestImpl(){}

    public TestImpl(String s) {
        this.s = s;
    }

    @Override
    public String toString(){
        return s;
    }

}
