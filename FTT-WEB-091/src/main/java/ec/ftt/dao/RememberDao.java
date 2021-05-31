package ec.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ec.ftt.model.Remember;
import ec.ftt.util.DBUtil;

public class RememberDao {
	
	private Connection connection;

    public RememberDao() {
        connection = DBUtil.getConnection();
    } //UserDao

    public void addRemember(Remember remember) {
        
    	//https://www.devmedia.com.br/assertions-em-java/28781
    	
    	try {
    		
    		System.out.println("add Remember...");
    		
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO ftt.REMEMBER (QUESTION, ANSWER, SITE) VALUES (?, ?, ?)");
            
            // Parameters start with 1
            preparedStatement.setString(1, remember.getQuestion());
            preparedStatement.setString(2, remember.getAnswer());
            preparedStatement.setString(3, remember.getSite());

            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //addUser
    
    public void deleteRemember(Long id) {
    	
    	Remember remember = new Remember();
    	remember.setId(id);
    	
    	deleteRemember(remember);
    	
    } // deleteUser long

    public void deleteRemember(Remember remember) {
        try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM ftt.REMEMBER WHERE ID=?");
        	
            preparedStatement.setLong(1, remember.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //deleteUser

    public void updateRemember(Remember remember) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE ftt.REMEMBER SET QUESTION=?, " 
                    		                          + "ANSWER=?, " 
                    		                          + "SITE=? " 
                    		                          + "WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setString(1, remember.getQuestion());
            preparedStatement.setString(2, remember.getAnswer());
            preparedStatement.setString(3, remember.getSite());
            
            preparedStatement.setLong(4, remember.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //updateUser

    public List<Remember> getAllRemembers() {
        
    	List<Remember> rememberlist = new ArrayList<Remember>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ftt.REMEMBER");
            while (rs.next()) {
                
            	Remember remember = new Remember();
                
            	remember.setId(rs.getLong("ID"));
            	remember.setQuestion(rs.getString("QUESTION"));
            	remember.setAnswer(rs.getString("ANSWER"));
            	remember.setSite(rs.getString("SITE"));

            	rememberlist.add(remember);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rememberlist;
    } //getAllUser

    public Remember getRememberById(Long id) {
    	
    	Remember remember = new Remember();
    	remember.setId(id);
    	
    	return getRememberById(remember);
    	
    } // getUserById long
    
    
    	
    public Remember getRememberById(Remember remember) {

    	Remember rememberOutput = new Remember();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * from ftt.REMEMBER WHERE ID=?");
            
            preparedStatement.setLong(1, remember.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	rememberOutput.setId(rs.getLong("ID"));
            	rememberOutput.setQuestion(rs.getString("QUESTION"));
            	rememberOutput.setAnswer(rs.getString("ANSWER"));
            	rememberOutput.setSite(rs.getString("SITE"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rememberOutput;
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

}
