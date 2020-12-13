package Controller;

import Domain.Result;
import Services.*;
import UI.*;

import java.util.Scanner;

public class CoachController {
    IUI ui = new UI();
    IMemberService ms = new MemberService();
    IResultService rs = new ResultService();
    ICoachService cs = new CoachService();
    Scanner sc = new Scanner(System.in);
    int choice = 0;

    public void runCoachMenu() {
        while (choice != 9) {
            ui.showCoachMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    cs.showJuniorCoaches();
                    ms.showJuniorMembers();
                    System.out.println("\n");
                    break;
                case 2:
                    cs.showSeniorCoaches();
                    ms.showSeniorMembers();
                    System.out.println("\n");
                    break;
                case 3:
                    rs.showAllResults();
                    System.out.println("\n");
                    break;
                case 4:
                    rs.showTopFiveJuniorResultsCrawl();
                    System.out.println("\n");
                    break;
                case 5:
                    rs.showTopFiveSeniorResultsCrawl();
                    System.out.println("\n");
                    break;
                case 6:
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
