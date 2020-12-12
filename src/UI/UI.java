package UI;

import Services.IMemberService;
import Services.MemberService;

import java.util.Scanner;

import Domain.*;

public class UI implements IUI {
    Scanner sc = new Scanner(System.in);

    //MainController
    public void showUserMenu() {
        System.out.println("1) Admin");
        System.out.println("2  Coach");
        System.out.println("3) Cashier");
        System.out.println("9) Exit");
    }

    public void showAdminMenu() {
        System.out.println("1) Add member");
        System.out.println("2) Show members");
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

    //MemberService
    public String setMemberName() {
        String name = "";
        System.out.println("Enter member name: ");
        name = sc.nextLine();
        //Exception missing
        return name;
    }

    //MemberService
    public int setMemberAge() {
        int age = 0;
        System.out.println("Enter member age: ");
        age = sc.nextInt();
        return age;
    }

    //MemberService
    public boolean setMemberStatus() {
        boolean status = false;
        int choice = 0;
        System.out.println("Set membership status: ");
        System.out.println("(1) Active / (2) Passive");
        choice = sc.nextInt();
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

    //MemberService
    public boolean setMemberCompetitive() {
        boolean competitionStatus = false;
        int choice = 0;
        System.out.println("Set membership competition status: ");
        System.out.println("(1) Competitive / (2) Exercise");
        System.out.println("Note! If you are a passive member you will automatically be put as exercise");
        choice = sc.nextInt();
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
        return  word;
    }

    public void printExitMessage() {
        System.out.println("Exiting..");
    }

}
