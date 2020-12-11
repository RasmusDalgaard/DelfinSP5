package Domain;

public class Coach {
    private int coachID;
    private String coachName;

    public Coach(int coachID, String coachName) {
        this.coachID = coachID;
        this.coachName = coachName;
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
}
