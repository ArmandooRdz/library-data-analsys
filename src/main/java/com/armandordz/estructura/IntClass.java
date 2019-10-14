package com.armandordz.estructura;

public class IntClass implements Cell {

    private int value;
    private boolean isNaN = true;


    public IntClass(int value) {
        this.value = value;
        this.isNaN = false;
    }

    public boolean isNaN() {
        return isNaN;
    }

    public void setNaN(boolean naN) {
        isNaN = naN;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public void printValue() {

    }

    @Override
    public void toNaN() {

    }

    @Override
    public Object getValue() {
        return this.value;
    }




}
