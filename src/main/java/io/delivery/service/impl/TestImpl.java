package io.delivery.service.impl;

import io.delivery.service.Test;

/**
 * Created by NortT on 02.04.2017.
 */
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
