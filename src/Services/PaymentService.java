package Services;

import Connector.*;
import Domain.Member;
import Domain.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentService implements IPaymentService {
    IDBConnector dbc = new DBConnector();
    IMemberService ms = new MemberService();
    List<Payment> missingPayments;
    List<Member> memberList;

    public PaymentService() {
        missingPayments = new ArrayList<>();
        memberList = ms.getAllMembers();
    }

    public List<Payment> getMemberDebt() {
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;
        String sql = "";
        Payment tmpPayment = null;
        connection = dbc.getMyConnection();
        try {
            stmt = connection.createStatement();
            sql = "SELECT p.memberID, m.memberName, p.hasPaid, m.price\n" +
                    "FROM payment p, members m\n" +
                    "WHERE p.memberID = m.memberID\n" +
                    "AND p.hasPaid = false\n" +
                    "order BY memberID";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                int memberID = res.getInt(1);
                String memberName = res.getString(2);
                boolean hasPaid = res.getBoolean(3);
                double debt = res.getDouble(4);
                Member member = ms.getMemberByID(memberID);
                tmpPayment = new Payment(member, memberName, hasPaid, debt);
                missingPayments.add(tmpPayment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return missingPayments;
    }

    public void showMemberDebt() {
        for (Payment p : getMemberDebt()) {
            System.out.println(p);
        }
    }
}
