package ec.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ec.ftt.model.Password;
import ec.ftt.util.DBUtil;

public class PasswordDao {

    private Connection connection;

    public PasswordDao() {
        connection = DBUtil.getConnection();
    } //UserDao

    public void addPassword(Password password) {
        
    	//https://www.devmedia.com.br/assertions-em-java/28781
    	
    	try {
    		
    		System.out.println("add Passowrd...");
    		
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO ftt.PASSWORD (NAME, EMAIL, PASSWORD, SITE) VALUES (?, ?, ?, ?)");
            
            // Parameters start with 1
            preparedStatement.setString(1, password.getName());
            preparedStatement.setString(2, password.getEmail());
            preparedStatement.setString(3, password.getPassword());
            preparedStatement.setString(4, password.getSite());

            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //addUser
    
    public void deletePassord(Long id) {
    	
    	Password password = new Password();
    	password.setId(id);
    	
    	deletePassword(password);
    	
    } // deleteUser long

    public void deletePassword(Password password) {
        try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM ftt.PASSWORD WHERE ID=?");
        	
            preparedStatement.setLong(1, password.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //deleteUser

    public void updatePassword(Password password) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE ftt.PASSWORD SET NAME=?, " 
                    		                          + "EMAIL=?, " 
                    		                          + "PASSWORD=?, " 
                    		                          + "SITE=? " 
                    		                          + "WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setString(1, password.getName());
            preparedStatement.setString(2, password.getEmail());
            preparedStatement.setString(3, password.getPassword());
            preparedStatement.setString(4, password.getSite());
            
            preparedStatement.setLong(5, password.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //updateUser

    public List<Password> getAllPassword() {
        
    	List<Password> passwordlist = new ArrayList<Password>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ftt.PASSWORD");
            while (rs.next()) {
                
            	Password password = new Password();
                
            	password.setId(rs.getLong("ID"));
            	password.setName(rs.getString("NAME"));
            	password.setEmail(rs.getString("EMAIL"));
            	password.setPassword(rs.getString("PASSWORD"));
            	password.setSite(rs.getString("SITE"));

            	passwordlist.add(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return passwordlist;
    } //getAllUser

    public Password getPasswordById(Long id) {
    	
    	Password password = new Password();
    	password.setId(id);
    	
    	return getPasswordById(password);
    	
    } // getUserById long
    
    
    	
    public Password getPasswordById(Password password) {

    	Password passwordOutput = new Password();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * from ftt.PASSWORD WHERE ID=?");
            
            preparedStatement.setLong(1, password.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	passwordOutput.setId(rs.getLong("ID"));
            	passwordOutput.setName(rs.getString("NAME"));
            	passwordOutput.setEmail(rs.getString("EMAIL"));
            	passwordOutput.setPassword(rs.getString("PASSWORD"));
            	passwordOutput.setSite(rs.getString("SITE"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return passwordOutput;
    } //getUserById
    
    public String getDbDate() {

    	String output="";
    	
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT now() NOW");
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	output = rs.getString("NOW");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    } //getDbDate
    
} //UserDao