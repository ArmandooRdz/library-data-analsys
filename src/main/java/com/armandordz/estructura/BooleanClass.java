package com.armandordz.estructura;

public class BooleanClass implements Cell {

    private boolean value;
    private boolean isNaN = true; // Por default es vacío


    public BooleanClass(boolean value) {
        this.value = value;
        this.isNaN = false;
    }


    public void setValue(boolean value) {
        this.value = value;
    }

    public boolean isNaN() {
        return isNaN;
    }

    public void setNaN(boolean naN) {
        isNaN = naN;
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
