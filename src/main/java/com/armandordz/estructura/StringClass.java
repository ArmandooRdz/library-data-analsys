package com.armandordz.estructura;

public class StringClass implements Cell{

    private String value;
    private boolean isNaN = true;


    public StringClass(String value) {
        this.value = value;
        this.isNaN = false;
    }



    public void setValue(String value) {
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
        System.out.println(this.value);
    }


    @Override
    public void toNaN() {

    }

    @Override
    public Object getValue() {
        return this.value;
    }

}
