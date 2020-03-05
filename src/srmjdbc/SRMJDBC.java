/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srmjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author achavhan
 */
public class SRMJDBC {

    /**
     * @param args the command line arguments
     */
    private static final String connectionStr = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)"
                                        + "(HOST=192.168.30.3)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=ptguidev)))";
    private static final String userName = "tsi";
    private static final String password = "Iptiks_st";
    
    public static void main(String[] args) {
        String sqlStatement = "SELECT * FROM ARCF WHERE ROWNUM <= 2";
        try {
            try (Connection connection = DriverManager.getConnection(SRMJDBC.connectionStr, SRMJDBC.userName, SRMJDBC.password)) {
                ResultSet res = connection.createStatement().executeQuery(sqlStatement);
                while (res.next()) {
                    String firstName = res.getString("arcf_name");
                    String lastName = res.getString("cs_id");
                    System.out.println("   "+firstName+" "+lastName);
                }
            }   
        } catch (SQLException ex) {
            Logger.getLogger(SRMJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
