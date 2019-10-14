package com.armandordz.estructura;

public class FloatClass implements Cell {

    private float value;
    private boolean isNaN = true;


    public FloatClass(float value) {
        this.value = value;
        this.isNaN = false;
    }


    public void setValue(float value) {
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
