package Services;

import Connector.DBConnector;
import Connector.IDBConnector;
import Domain.*;
import UI.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberService implements IMemberService {
    IDBConnector dbc = new DBConnector();
    IUI ui = new UI();

    //int memberID, String memberName, int age, boolean membershipStatus, double membershipPrice, boolean competetive
    public void addMember() {
        Member member = new Member();
        String memberName = ui.setMemberName();
        int age = ui.setMemberAge();
        boolean membershipStatus = ui.setMemberStatus();
        boolean competitive = ui.setMemberCompetitive();
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

    public void showAllMembers() {
        for (Member m : getAllMembers()) {
            System.out.println(m);
        }
    }

}
