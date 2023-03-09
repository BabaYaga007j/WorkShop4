package EmolyeeManager.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import EmolyeeManager.connections.DatabaseConnection;
import EmolyeeManager.exceptions.EmployeeAlreadyExistException;
import EmolyeeManager.exceptions.EmployeeNotFound;


public class EmployeeRemove {
	
	public static boolean employeeExistOrNot(String firstName) throws SQLException {
		Connection connection = DatabaseConnection.getConnection();//singleton Pattern
	
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Employee where firstName ='"+firstName+"' ;");
		
		if(resultSet.getRow() == 0) {
			return false;
		}
		return true;
	}
	
	public void removeEmployee(String firstName) throws SQLException, EmployeeAlreadyExistException, EmployeeNotFound {
		Connection connection = DatabaseConnection.getConnection();//singleton Pattern
		
		
		try {
			if(!employeeExistOrNot(firstName)) {
				throw new EmployeeNotFound(" Employee Already Exist ");
			}
			else {
			PreparedStatement statement = connection.prepareStatement("delete from Employee where firstName = ?");
			statement.setString(1, firstName);
			
			
			int confirm = statement.executeUpdate();
			System.out.println(confirm==1? "Employee Removed ":" Error while Removing Employee");
			statement.close();
			connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
