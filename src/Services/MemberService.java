package Services;

import Connector.DBConnector;
import Connector.IDBConnector;
import Domain.*;
import Exceptions.InvalidAgeException;
import Exceptions.InvalidNumberException;
import Exceptions.WrongNameException;
import UI.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberService implements IMemberService {
    IDBConnector dbc = new DBConnector();
    IUI ui = new UI();

    String memberName;
    int age;
    boolean membershipStatus;
    boolean competitive;

    //int memberID, String memberName, int age, boolean membershipStatus, double membershipPrice, boolean competetive
    public void addMember() {
        Member member = new Member();
        while (memberName == null) {
            try {
                memberName = ui.setMemberName();
            } catch (WrongNameException nameException) {
                nameException.printErrorMessager();
            }
        }

            try {
                age = ui.setMemberAge();
            } catch (InvalidAgeException ageException) {
                ageException.printErrorMessage();
            }

            try {
                membershipStatus = ui.setMemberStatus();
                competitive = ui.setMemberCompetitive();
            } catch (InvalidNumberException numberException) {
                numberException.printErrorMessage();
            }

        member.setMemberName(memberName);
        member.setAge(age);
        member.setMembershipStatus(membershipStatus);
        member.setCompetetive(competitive);
        double membershipPrice = member.getMembershipPrice();
        member.setMembershipPrice(membershipPrice);
        if (!member.isMembershipStatus()) {
            member.setCompetetive(false);
        }

        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        String sql = "";

        sql += "INSERT INTO members (memberID,memberName,age,membershipStatus,price,competitive) VALUES (?,?,?,?,?,?)";
        connection = dbc.getMyConnection();
        try {
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, member.getMemberID());
            stmt.setString(2, member.getMemberName());
            stmt.setInt(3, member.getAge());
            stmt.setBoolean(4, membershipStatus);
            stmt.setDouble(5, membershipPrice);
            stmt.setBoolean(6, competitive);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;
        String sql = "";
        Member tmpMember = null;
        connection = dbc.getMyConnection();
        try {
            stmt = connection.createStatement();
            sql = "SELECT * FROM members";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                int memberID = res.getInt(1);
                String memberName = res.getString(2);
                int age = res.getInt(3);
                boolean membershipStatus = res.getBoolean(4);
                double membershipPrice = res.getDouble(5);
                boolean competitive = res.getBoolean(6);
                tmpMember = new Member(memberID, memberName, age, membershipStatus, membershipPrice, competitive);
                members.add(tmpMember);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    public List<Member> getAllCompetitiveJuniors() {
        List<Member> juniorMembers = new ArrayList<>();
        for (Member m : getAllMembers()) {
            if (m.getAge() < 18 && m.isCompetetive()) {
                juniorMembers.add(m);
            }
        }
        return juniorMembers;
    }

    public List<Member> getAllCompetitiveSeniors() {
        List<Member> seniorMembers = new ArrayList<>();
        for (Member m : getAllMembers()) {
            if (m.getAge() >= 18 && m.getAge() < 60 && m.isCompetetive()) {
                seniorMembers.add(m);
            }
        }
        return seniorMembers;
    }

    public Member getMemberByID(int id) {
        Member member = null;
        for (Member m : getAllMembers()) {
            if (m.getMemberID() == id) {
                return m;
            }
        }
        return member;
    }

    public void showAllMembers() {
        for (Member m : getAllMembers()) {
            System.out.println(m);
        }
    }

    public void showJuniorMembers() {
        for (Member m : getAllCompetitiveJuniors()) {
            System.out.println(m);
        }
    }

    public void showSeniorMembers() {
        for (Member m : getAllCompetitiveSeniors()) {
            System.out.println(m);
        }
    }
}
