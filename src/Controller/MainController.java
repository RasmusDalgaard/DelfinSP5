package Controller;

import java.util.Scanner;

import UI.*;

public class MainController {
    Scanner sc = new Scanner(System.in);
    AdminController ac = new AdminController();
    CoachController cc = new CoachController();
    CashierController csc = new CashierController();
    IUI ui = new UI();
    int choice = 0;

    public void runProgram() {
        ui.showUserMenu();
        while (choice != 9) {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ac.runAdminMenu();
                    break;
                case 2:
                    cc.runCoachMenu();
                    break;
                case 3:
                    csc.runCashierMenu();
                    break;
                default:
                    ui.printExitMessage();
                    choice = 9;
                    break;
            }
        }
    }
}
