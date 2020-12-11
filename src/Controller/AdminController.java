package Controller;

import Services.MemberService;
import UI.IUI;
import UI.UI;

import java.util.Scanner;

public class AdminController {
    IUI ui = new UI();
    MemberService ms = new MemberService();
    Scanner sc = new Scanner(System.in);
    int choice = 0;

    public void runAdminMenu() {
        while (choice != 9) {
            ui.showAdminMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ms.addMember();
                    break;
                case 2:
                    ms.showAllMembers();
                    System.out.println("\n");
                    break;
                case 4:
                    ui.showUserMenu();
                    choice = 9;
                    break;
                default:
                    choice = 9;
                    break;
            }
        }
    }
}
