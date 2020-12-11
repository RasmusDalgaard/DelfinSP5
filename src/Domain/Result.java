package Domain;

public class Result {
    private int resultID;
    private String compName;
    private String compDate;
    private Member member;
    private int time;
    private String discipline;

    public Result(int resultID, Member member, String compName, String compDate, int time, String discipline) {
        this.resultID = resultID;
        this.member = member;
        this.compName = compName;
        this.compDate = compDate;
        this.time = time;
        this.discipline = discipline;
    }

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompDate() {
        return compDate;
    }

    public void setCompDate(String compDate) {
        this.compDate = compDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
