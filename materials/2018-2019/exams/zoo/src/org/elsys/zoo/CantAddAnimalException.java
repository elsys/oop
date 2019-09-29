package org.elsys.zoo;

public class CantAddAnimalException extends RuntimeException {
    public CantAddAnimalException(String errorMessage){
        super(errorMessage);
    }
}
