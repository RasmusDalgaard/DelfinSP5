package Domain;

import Services.IMemberService;
import Services.MemberService;

import java.util.List;

public class Payment {
    private Member member;
    private String memberName;
    private boolean hasPaid;
    private double memberDebt;


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
        return member.getMemberID() + ", " + member.getMemberName() + ", " + hasPaid + ", " + member.getMembershipPrice();
    }
}
