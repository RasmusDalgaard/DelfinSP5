package Controller;

import Connector.*;
import Domain.Result;
import Services.*;
import UI.*;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CoachController {
    IUI ui = new UI();
    IMemberService ms = new MemberService();
    IResultService rs = new ResultService();
    ICoachService cs = new CoachService();
    IDBConnector dbc = new DBConnector();
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
                    ui.showDisciplineInputMessage();
                    try {
                        rs.showTopFiveJuniorByDiscipline(sc.nextLine());
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid discipline");
                        choice = 4;
                    }
                    System.out.println("\n");
                    break;
                case 5:
                    ui.showDisciplineInputMessage();
                    try {
                        rs.showTopFiveSeniorByDiscipline(sc.nextLine());
                    } catch (InputMismatchException mismatchException) {
                        System.out.println("Invalid discipline");
                        choice = 5;
                    }
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
