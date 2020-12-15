package UI;

import Exceptions.WrongNameException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI implements IUI {
    Scanner sc = new Scanner(System.in);

    public void showUserMenu() {
        System.out.println("1) Admin");
        System.out.println("2  Coach");
        System.out.println("3) Cashier");
        System.out.println("9) Exit");
    }

    public void showAdminMenu() {
        System.out.println("1) Add member");
        System.out.println("2) Show members");
        System.out.println("3) Show coaches");
        System.out.println("4) Go back");
    }

    public void showCoachMenu() {
        System.out.println("1) Show Junior team");
        System.out.println("2) Show Senior team");
        System.out.println("3) Show all results");
        System.out.println("4) Show top 5 Junior");
        System.out.println("5) Show top 5 Senior");
        System.out.println("6) Go back");
    }

    public void showDisciplineInputMessage() {
        System.out.println("Type the desired discipline (Butterfly, Crawl, Backcrawl, Breaststroke) Note! Case Sensitive");
    }

    public void showCashierMenu() {
        System.out.println("1) Show member debt");
        System.out.println("4) Go back");
    }

    public String setMemberName() throws WrongNameException {
        String name = "";
        System.out.println("Enter member name: ");
        name = sc.nextLine();
        for (int i = 0; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            if (name.contains(" ")) {
                continue;
            }
            if (name == null || !(currentChar >= 'A' && currentChar <= 'Z') && !(currentChar >= 'a' && currentChar <= 'z')) {
                throw new WrongNameException();
            }
        }
        return name;
    }

    public int setMemberAge() {
        int age = 0;
        System.out.println("Enter member age: ");
        try {
            age = sc.nextInt();
            if (age <= 6) {
                System.out.println("Children with the age of 6 years or less get in for free");
                setMemberAge();
            } else if (age <= 0) {
                System.out.println("Invalid age");
            } else if (age > 100) {
                System.out.println("Too old for this Dolfin");
            }
        } catch (InputMismatchException e) {
            sc.next();
            System.out.println("Please enter a valid age");
            setMemberAge();
        }

        return age;
    }

    public boolean setMemberStatus() {
        boolean status = false;
        int choice = 0;
        System.out.println("Set membership status: ");
        System.out.println("(1) Active / (2) Passive");
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number");
            sc.next();
            setMemberStatus();
        }
        switch (choice) {
            case 1:
                status = true;
                break;
            case 2:
                status = false;
                break;
        }
        return status;
    }

    public boolean setMemberCompetitive() {
        boolean competitionStatus = false;
        int choice = 0;
        System.out.println("Set membership competition status: ");
        System.out.println("(1) Competitive / (2) Exercise");
        System.out.println("Note! If you are a passive member you will automatically be put as exercise");
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.next();
            System.out.println("Please enter a valid number");
            setMemberCompetitive();
        }
        switch (choice) {
            case 1:
                competitionStatus = true;
                break;
            case 2:
                competitionStatus = false;
                break;
        }
        return competitionStatus;
    }

    public String addWordWithSpacing(String word, int length) {
        String spacing = " ";
        spacing = spacing.repeat(length - word.length());
        word = word + spacing;
        return word;
    }

    public void printExitMessage() {
        System.out.println("Exiting..");
    }

}
