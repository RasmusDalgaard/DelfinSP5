package Domain;

import UI.*;

import java.util.List;

public class Payment {
    private Member member;
    private String memberName;
    private boolean hasPaid;
    private double memberDebt;
    IUI ui = new UI();


    public Payment(Member member, String memberName, boolean hasPaid, double memberDebt) {
        this.member = member;
        this.memberName = memberName;
        this.hasPaid = hasPaid;
        this.memberDebt = memberDebt;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public double getMemberDebt() {
        return memberDebt;
    }

    public void setMemberDebt(double memberDebt) {
        this.memberDebt = memberDebt;
    }

    @Override
    public String toString() {
        String membID = ui.addWordWithSpacing(Integer.toString(member.getMemberID()), 25);
        String membName = ui.addWordWithSpacing(memberName, 25);
        String paid  = ui.addWordWithSpacing(Boolean.toString(hasPaid), 25);
        String membDebt = ui.addWordWithSpacing(Double.toString(memberDebt), 25);

        return "Member ID: " + membID + "Member name: " + membName + "Debt: " + membDebt;
    }
}
