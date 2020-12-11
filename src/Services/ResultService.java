package Services;

import Connector.DBConnector;
import Domain.Member;
import Domain.Result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ResultService {
    DBConnector dbc = new DBConnector();
    IMemberService ms = new MemberService();
    List<Member> memberList;

    public ResultService () {
        memberList = ms.getAllMembers();
    }

    public List<Result> getAllResults() {
        List<Result> results = new ArrayList<>();

        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;
        String sql = "";
        Result tmpResult = null;
        connection = dbc.getMyConnection();

        try {
            stmt = connection.createStatement();
            sql = "SELECT * FROM results";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                int resultID = res.getInt(1);
                int memberID = res.getInt(2);
                String compName = res.getString(3);
                String compDate = res.getString(4);
                int placement = res.getInt(5);
                int time = res.getInt(6);
                String discipline = res.getString(7);
                Member member = ms.getMemberByID(memberID);

                tmpResult = new Result(resultID, member, compName, compDate, placement, time, discipline);
                results.add(tmpResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public Result getResultByID(int id) {
        Result result = null;
        for (Result res : getAllResults()) {
            if (res.getResultID() == id) {
                return res;
            }
        }
        return result;
    }
}
