package javafall2017.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Programer: Andrew Gaines
 *
 * About: Java fall2017 HomeWork 4 Dr. Macevoy 10/31/2017 // program adds NBA
 * players name, pointesPerGame, and assistsPerGame to sqlite database 
 */
public class App {

    private Connection connect = null;
    Statement statement = null;
    ResultSet result = null;
    long id = -1;
    String player;

    // connect to sqlite
    public Connection connectToDataBase() {
        if (connect == null) {
            synchronized (this) {
                if (connect == null) {
                    try {
                        connect = DriverManager.getConnection("jdbc:sqlite:sample.db");
                    } catch (SQLException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return connect;
    }

    void reset() {
        try {
            connect = connectToDataBase();
            statement = connect.createStatement();
            statement.setQueryTimeout(3);

            statement.executeUpdate("drop table if exists playerStats");
            statement.executeUpdate("create table playerStats (id integer primary key,"
                    + " name string, pointsPerGame double, assistsPerGame double)");

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    long insert(String name, double pointsPerGame, double assistsPerGame) {
        String sql = "INSERT INTO playerStats(name,pointsPerGame, assistsPerGame) VALUES(?,?,?)";

        try {
            Connection connection = connectToDataBase();

            PreparedStatement ps
                    = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setDouble(2, pointsPerGame);
            ps.setDouble(3, assistsPerGame);
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            if (result != null && result.next()) {
                id = result.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    // returns name of player
    String getPlayer(long id) {
        try {
            Connection connect = connectToDataBase();
            String sql = "select name from playerStats where id=?";
            PreparedStatement ps = connect.prepareStatement(sql, Statement.NO_GENERATED_KEYS);
            ps.setLong(1, id);
            ResultSet result = ps.executeQuery();
            if (result != null && result.next()) {
                return result.getString("name");
            }

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // returns ppg
    double getPointsPerGame(long id) {
        try {
            Connection connect = connectToDataBase();
            String sql = "select pointsPerGame from playerStats where id=?";
            PreparedStatement ps = connect.prepareStatement(sql, Statement.NO_GENERATED_KEYS);
            ps.setLong(1, id);
            ResultSet result = ps.executeQuery();
            if (result != null && result.next()) {
                return result.getDouble("pointsPerGame");
            }

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    // returns apg
    double getAssistsPerGame(long id) {
        try {
            Connection connect = connectToDataBase();
            String sql = "select assistsPerGame from playerStats where id=?";
            PreparedStatement ps = connect.prepareStatement(sql, Statement.NO_GENERATED_KEYS);
            ps.setLong(1, id);
            ResultSet result = ps.executeQuery();
            if (result != null && result.next()) {
                return result.getDouble("assistsPerGame");
            }

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    void run() {
        reset();

        // adding player name to data base
        long jStocktonId = insert("John Stockton", 13.1, 10.5);
        long sCurryName = insert("Steph Curry", 29.2, 6.3);

        // printing out players id with name
        System.out.println("John Stockton Id = " + jStocktonId);
        System.out.println("John Stockton name = " + getPlayer(1));
        System.out.println("John Stockton PointPerGame = " + getPointsPerGame(1));
        System.out.println("John Stockton AssistsPerGame =" + getAssistsPerGame(1));
        System.out.println("Steph Curry id = " + sCurryName);
        System.out.println("Steph Curry name = " + getPlayer(2));
        System.out.println("Steph Curry PointPerGame = " + getPointsPerGame(2));
        System.out.println("Steph Curry AssistsPerGame =" + getAssistsPerGame(2));

    }
}
