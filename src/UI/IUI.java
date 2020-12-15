package UI;

import Exceptions.WrongNameException;

public interface IUI {

    public void showUserMenu();

    public void showAdminMenu();

    public void showCoachMenu();

    public void showCashierMenu();

    public void showDisciplineInputMessage();

    public String setMemberName() throws WrongNameException;

    public int setMemberAge();

    public boolean setMemberStatus();

    public boolean setMemberCompetitive();

    public void printExitMessage();

    public String addWordWithSpacing(String word, int length);

}
