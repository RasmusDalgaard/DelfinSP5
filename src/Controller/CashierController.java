package Controller;

import Services.IMemberService;
import Services.IPaymentService;
import Services.PaymentService;
import UI.*;

import java.util.Scanner;

public class CashierController {
    IUI ui = new UI();
    IPaymentService ps = new PaymentService();
    Scanner sc = new Scanner(System.in);
    int choice = 0;

    public void runCashierMenu() {
        while (choice != 9) {
            ui.showCashierMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ps.showMemberDebt();
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
