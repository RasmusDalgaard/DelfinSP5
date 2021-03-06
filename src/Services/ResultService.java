package Services;

import Connector.DBConnector;
import Domain.Member;
import Domain.Result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ResultService implements IResultService {
    DBConnector dbc = new DBConnector();
    IMemberService ms = new MemberService();
    List<Member> memberList;
    Scanner sc = new Scanner(System.in);

    public ResultService() {
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
                int time = res.getInt(5);
                String discipline = res.getString(6);
                Member member = ms.getMemberByID(memberID);

                tmpResult = new Result(resultID, member, compName, compDate, time, discipline);
                results.add(tmpResult);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<Result> getTopJuniorResultsByDiscipline(String discipline) {
        List<Result> allResults = getAllResults();
        List<Result> juniorDiscipline = new ArrayList<>();
        for (Result res : allResults) {
            if (res.getDiscipline().equals(discipline) && res.getMember().getAge() < 18) {
                juniorDiscipline.add(res);
            }
        }
        Collections.sort(juniorDiscipline);
        return juniorDiscipline;
    }

    public List<Result> getTopSeniorResultsByDiscipline(String discipline) {
        List<Result> allResults = getAllResults();
        List<Result> seniorDiscipline = new ArrayList<>();
        for (Result res : allResults) {
            if (res.getDiscipline().equals(discipline) && res.getMember().getAge() >= 18 && res.getMember().getAge() < 60) {
                seniorDiscipline.add(res);
            }
        }
        Collections.sort(seniorDiscipline);
        return seniorDiscipline;
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

    public void showAllResults() {
        for (Result res : getAllResults()) {
            System.out.println(res);
        }
    }

    public void showTopFiveJuniorByDiscipline(String input) {
        input = sc.nextLine();
        if (input != null && input != "" && !input.matches(("Crawl|Butterfly|Backcrawl|Breaststroke"))) {
            throw new InputMismatchException();
        } else {
            for (Result res : getTopJuniorResultsByDiscipline(input)) {
                System.out.println(res);
            }
        }
    }


    public void showTopFiveSeniorByDiscipline(String input) {
        input = sc.nextLine();
        if (input != null && input != "" && !input.matches(("Crawl|Butterfly|Backcrawl|Breaststroke"))) {
            throw new InputMismatchException();
        } else {
            for (Result res : getTopSeniorResultsByDiscipline(input)) {
                System.out.println(res);
            }
        }
    }
}