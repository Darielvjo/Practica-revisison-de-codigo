package screensframework.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private static Connection conn;
    private static String url = "jdbc:postgresql://localhost:5432/ventas";
    private static String user = "postgres";
    private static String pass = "wilpolanco";
    /*
    private static String url = "jdbc:mysql://localhost/sysventas";
    private static String user = "root";
    private static String pass = "";*/
    
    /*public static Connection connect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Error al conectar a la base de datos", e);
        }
        return conn;
    }/*
     * 
     */
    public static Connection connect() throws SQLException{
        try {
                Class.forName("org.postgresql.Driver").newInstance();
                //Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch(ClassNotFoundException cnfe) {
                System.err.println("Error: "+cnfe.getMessage());
        } catch(InstantiationException ie) {
                System.err.println("Error: "+ie.getMessage());
        } catch(IllegalAccessException iae) {
                System.err.println("Error: "+iae.getMessage());
        }
                conn = DriverManager.getConnection(url,user,pass);
                return conn;
        }
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conn == null || conn.isClosed()) {
            connect();
        }
        return conn;
    }
}
