package Domain;

import UI.*;

public class Result {
    private int resultID;
    private String compName;
    private String compDate;
    private Member member;
    private int time;
    private String discipline;
    IUI ui = new UI();

    public Result(int resultID, Member member, String compName, String compDate, int time, String discipline) {
        this.resultID = resultID;
        this.member = member;
        this.compName = compName;
        this.compDate = compDate;
        this.time = time;
        this.discipline = discipline;
    }

    public Result(int resultID, Member member, String memberName, int memberAge, String compName, String compDate, int time, String discipline) {
        this.resultID = resultID;
        this.member = member;
        memberName = member.getMemberName();
        memberAge = member.getAge();
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

    @Override
    //int resultID, Member member, String compName, String compDate, int time, String discipline
    public String toString() {
        String resID = ui.addWordWithSpacing(Integer.toString(resultID), 25);
        String memberName = ui.addWordWithSpacing(member.getMemberName(), 25);
        String competitionName = ui.addWordWithSpacing(compName, 25);
        String resTime = ui.addWordWithSpacing(Integer.toString(time), 25);
        String disci = ui.addWordWithSpacing(discipline, 25);
        return "Result ID: " + resID + "Member name: " + memberName + "Competition name: " + competitionName + "Time: " + resTime + "Discipline: " + disci;
    }
}
