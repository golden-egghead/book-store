/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinnt.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Tin
 */
public class DBHelper implements Serializable {

    public static Connection makeConnection() throws NamingException, SQLException {
//        //1. Load Driver
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        //2. Create Connection String
//        String url = "jdbc:sqlserver:" 
//                    + "//localhost:1433;" 
//                    + "databaseName=loginDB";
//        //3. Open Connection
//        Connection con = DriverManager.getConnection(url, "sa", "ntin@260602");
//        return con;
        //1 get current context

        Context context = new InitialContext();
        //2 look up context tomcat
        Context tomcat = (Context) context.lookup("java:comp/env");
        //3 lookup DS
        DataSource ds = (DataSource) tomcat.lookup("loginDDB");

        //4 open connection
        Connection con = ds.getConnection();

        return con;
    }

}
