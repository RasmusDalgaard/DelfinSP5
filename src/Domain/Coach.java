package Domain;

import UI.*;

public class Coach {
    private int coachID;
    private String coachName;
    private String team;
    private IUI ui = new UI();

    public Coach(int coachID, String coachName, String team) {
        this.coachID = coachID;
        this.coachName = coachName;
        this.team = team;
    }

    public int getCoachID() {
        return coachID;
    }

    public void setCoachID(int coachID) {
        this.coachID = coachID;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        String ID = ui.addWordWithSpacing(Integer.toString(coachID), 25);
        String name = ui.addWordWithSpacing(coachName, 25);
        String teamName = ui.addWordWithSpacing(team, 25);

        return "Coach ID: " + ID + "Name: " + name + "Team: " + teamName;
    }
}
