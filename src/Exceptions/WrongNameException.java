package Exceptions;

public class WrongNameException extends Exception{

    public void printErrorMessager() {
        System.out.println("You must enter a valid name - Try again");
    }
}
