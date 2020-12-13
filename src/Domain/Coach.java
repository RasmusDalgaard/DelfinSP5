package Domain;

public class Coach {
    private int coachID;
    private String coachName;
    private String team;

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
        return coachName;
    }
}
