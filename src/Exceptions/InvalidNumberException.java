package Exceptions;

public class InvalidNumberException extends Exception{

    public void printErrorMessage() {
        System.out.println("Please enter a valid number");
    }
}
