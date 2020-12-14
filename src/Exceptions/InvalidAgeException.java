package Exceptions;

public class InvalidAgeException extends Exception {

    public void printErrorMessage() {
        System.out.println("Please enter a valid age");
    }
}
