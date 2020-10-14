package hello;

import java.sql.*;

public class HelloWorld {
  public static void main( String[] args ) throws SQLException {
    //create connection for a server installed in localhost, with a user "root" with no password
    try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/", "root", null)) {
        // create a Statement
        try (Statement stmt = conn.createStatement()) {
            //execute query
            try (ResultSet rs = stmt.executeQuery("SELECT 'Hello World!' from sampletable where id=1")) {
                //position result to first
                rs.first();
                System.out.println(rs.getString(1)); //result is "Hello World!"
            }
        }
    }
}
}