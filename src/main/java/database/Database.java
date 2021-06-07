package database;

import java.sql.DriverManager;
import java.sql.Connection;

public class Database
{
    private static final String URL = "jdbc:sqlite:C:\\Users\\ahoju\\OneDrive\\Työpöytä\\Koulutyöt2021Kevät\\puuntiheysjuhis\\puuntiheysjuhis\\Balsalevy.sqlite";
    
    public Connection connect() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(URL);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}