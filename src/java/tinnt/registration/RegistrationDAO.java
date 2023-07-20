/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinnt.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import tinnt.util.DBHelper;

/**
 *
 * @author Tin
 */
public class RegistrationDAO implements Serializable {

    private List<RegistrationDTO> accounts;

    public RegistrationDTO checkLogin(String username, String password)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        RegistrationDTO result = null;

        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT username, password, lastname, isAdmin "
                        + "FROM Registration "
                        + "WHERE username = ? "
                        + "AND password = ?";
                //3. Create SQL Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4 Excute Statement to get result 
                rs = stm.executeQuery();
                //5. Process Result
                if (rs.next()) {
                    String fullName = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");

                    result = new RegistrationDTO(username, password, fullName, role);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public List<RegistrationDTO> getAccounts() {
        return accounts;
    }

    public List<RegistrationDTO> searchLastname(String searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RegistrationDTO> listDTO = new ArrayList<RegistrationDTO>();
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT username, password, lastname, isAdmin "
                        + "FROM Registration "
                        + "WHERE lastname Like ?";
                //3. Create SQL Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //4 Excute Statement to get result 
                rs = stm.executeQuery();
                //5. Process Result
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String fullName = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");

                    RegistrationDTO dto = new RegistrationDTO(username, password, fullName, role);
                    listDTO.add(dto);
                } //end traverse Result set
            } // process when connection is existed
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listDTO;
    }

    public boolean deleteRecord(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "Delete From Registration "
                        + "WHERE username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);

                int row = stm.executeUpdate();

                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updatePassRole(String username, String password, boolean role)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;

        try {

            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "UPDATE Registration "
                        + "SET password = ?, "
                        + "isAdmin = ? "
                        + "WHERE username = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setBoolean(2, role);
                stm.setString(3, username);

                int row = stm.executeUpdate();

                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean createNewAccount(String username, String password, String lastname, boolean role)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;

        try {

            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "INSERT into Registration(username, password, lastname, isAdmin)"
                        + " Values(?, ?, ?, ?)";

                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, lastname);
                stm.setBoolean(4, role);

                int row = stm.executeUpdate();

                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return false;
    }

}
