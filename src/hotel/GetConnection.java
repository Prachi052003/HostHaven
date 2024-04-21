package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
    private String url;
    private String user;
    private String pwd;
    private Connection connect;

    public GetConnection() {
        url = "jdbc:mysql://localhost:3306/hotel";
        user = "root";
        pwd = "prachi@123";
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Explicitly load the driver class
            connect = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connect;
    }
}
