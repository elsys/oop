package org.elsys_bg.generics;

public class BoxType <T>{
    //T - type
    //E - element
    //K - key
    //V - value
    //N - number
    //U, Z,P - other types
    private T type;

    public BoxType(T type) {
        this.type = type;
    }

    public BoxType() {

    }

    T getType() {
        return type;
    }

    void setType(T type) {
        this.type = type;
    }
}
