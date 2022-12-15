package hu.unideb.barbersdirectory.exceptionhandling;

public class BarberNotFoundException extends RuntimeException{
    public BarberNotFoundException(String message){
        super(message);
    }
}
