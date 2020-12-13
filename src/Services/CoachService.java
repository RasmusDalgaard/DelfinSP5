package Services;

import Connector.DBConnector;
import Connector.IDBConnector;
import Domain.Coach;
import Domain.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoachService implements ICoachService {
    IDBConnector dbc = new DBConnector();

    public CoachService() {
    }

    public List<Coach> getAllCoaches() {
        List<Coach> coaches = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;
        String sql = "";
        Coach tmpCoach = null;
        connection = dbc.getMyConnection();
        try {
            stmt = connection.createStatement();
            sql = "SELECT * FROM coaches";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                int coachID = res.getInt(1);
                String coachName = res.getString(2);
                String team = res.getString(3);
                tmpCoach = new Coach(coachID, coachName, team);
                coaches.add(tmpCoach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coaches;
    }

    public void showAllCoaches() {
        for (Coach c : getAllCoaches()) {
            System.out.println(c + " Team: " + c.getTeam());
        }
    }


    public void showJuniorCoaches() {
        for (Coach c : getAllCoaches()) {
            if (c.getTeam().equals("Junior")) {
                System.out.println("Coach: " + c);
            }
        }
    }

    public void showSeniorCoaches() {
        for (Coach c : getAllCoaches()) {
            if (c.getTeam().equals("Senior")) {
                System.out.println("Coach: " + c);
            }
        }
    }
}
