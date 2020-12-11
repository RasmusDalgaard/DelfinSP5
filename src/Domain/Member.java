package Domain;

public class Member {
    private int memberID;
    private String memberName;
    private int age;
    private boolean membershipStatus;
    private double membershipPrice;
    private boolean competetive;

    public Member(int memberID, String memberName, int age, boolean membershipStatus, double membershipPrice, boolean competetive) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.age = age;
        this.membershipStatus = membershipStatus;
        this.membershipPrice = membershipPrice;
        this.competetive = competetive;
    }

    public Member() {
        this.memberID = memberID;
        this.memberName = memberName;
        this.age = age;
        this.membershipStatus = membershipStatus;
        this.membershipPrice = membershipPrice;
        this.competetive = competetive;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(boolean membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public double getMembershipPrice() {
        if (!membershipStatus) {
            membershipPrice = 500;
        } else if (membershipStatus && age > 6 && age < 18) {
            membershipPrice = 1000;
        } else if (membershipStatus && age >= 18 && age < 60) {
            membershipPrice = 1600;
        } else if (membershipStatus && age >= 60) {
            membershipPrice = 1600 * 0.75;
        } else {
            membershipPrice = 0; // Exception handling if age < 6.
        }
        return membershipPrice;
    }

    public void setMembershipPrice(double membershipPrice) {
        this.membershipPrice = membershipPrice;
    }

    public boolean isCompetetive() {
        return competetive;
    }

    public void setCompetetive(boolean competetive) {
        this.competetive = competetive;
    }

    //(int memberID, String memberName, int age, boolean membershipStatus, double membershipPrice, boolean competetive)
    @Override
    public String toString() {
        return memberID + ", " + memberName + ", " + age + ", Is active: " + membershipStatus + ", " + membershipPrice + ", Competition Member: " + competetive;
    }
}
