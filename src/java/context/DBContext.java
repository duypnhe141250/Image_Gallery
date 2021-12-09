
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBContext {

    /**
     * Create attributes
     */
    private final String serverName = "localhost";
    private final String dbname = "Photo";
    private final String portNumber = "1433";
    private final String username = "sa";
    private final String password = "123";

    /**
     * The method is GetConnection method connect to database
     *
     * @return connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbname;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("Connect Success");
        return DriverManager.getConnection(url, username, password);
    }
    /**
     * CloseConnection method close connect of connection
     *
     *
     * @param con . It is<code>Connection</code>
     * @throws SQLException
     */
    public void closeConnection(Connection con) throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
    /**
     * CloseConnection method close connect of ResultSet
     *
     *
     * @param rs . It is <code>ResultSet</code>
     * @throws SQLException
     */
    public void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    /**
     * CloseConnection method close connect of PreparedStatement
     *
     *
     * @param ps. It is <code>PreparedStatement</code>
     * @throws SQLException
     */
    public void closePreparedStatement(PreparedStatement ps) throws SQLException {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }
}
