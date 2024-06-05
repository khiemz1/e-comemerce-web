package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBcontext {
    protected Connection connection;
    public DBcontext()
    {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName= BTL_WEB";
            String username = "sa";
            String password = "admin";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
}
