package UI;

import Exceptions.InvalidNumberException;
import Exceptions.WrongNameException;

public interface IUI {

    public void showUserMenu();

    public void showAdminMenu();

    public void showCoachMenu();

    public void showCashierMenu();

    public void showDisciplineInputMessage();

    public String setMemberName() throws WrongNameException;

    public int setMemberAge();

    public boolean setMemberStatus() throws InvalidNumberException;

    public boolean setMemberCompetitive() throws InvalidNumberException;

    public void printExitMessage();

    public String addWordWithSpacing(String word, int length);

}
