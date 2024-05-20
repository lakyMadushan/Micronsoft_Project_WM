package dt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Vidura samitha
 */
public class DB {

    static Connection c;

    public static Connection createConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/wm?useSSL=false", "root", "1234");
        return c;
    }

    public static void iud(String sql) throws Exception {
        if (c == null) {
            createConnection();
        }

        c.createStatement().executeUpdate(sql);
    }

    public static ResultSet search(String sql) throws Exception {
        if (c == null) {
            createConnection();
        }
        return c.createStatement().executeQuery(sql);
    }
}
