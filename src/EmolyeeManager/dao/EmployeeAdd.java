package EmolyeeManager.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import EmolyeeManager.connections.DatabaseConnection;
import EmolyeeManager.exceptions.EmployeeAlreadyExistException;
import EmolyeeManager.model.EmployeePojo;

public class EmployeeAdd {
	
		
		public static boolean employeeExistOrNot(String firstName) throws SQLException {
			Connection connection = DatabaseConnection.getConnection();//singleton Pattern
		
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Employee where firstName ='"+firstName+"' ;");
			
			if(resultSet.getRow() == 0) {
				return false;
			}
			return true;
		}
		
		public void addEmployee(EmployeePojo pojo) throws SQLException, EmployeeAlreadyExistException {
			Connection connection = DatabaseConnection.getConnection();//singleton Pattern
			
			
			try {
				if(employeeExistOrNot(pojo.getFirstName())) {
					throw new EmployeeAlreadyExistException(" Employee Already Exist ");
				}
				else {
				PreparedStatement statement = connection.prepareStatement("insert into Employee (firstName,lastName,phoneNumber,salary) values(? , ? , ?, ? );");
				statement.setString(1, pojo.getFirstName());
				statement.setString(2, pojo.getLastName());
				statement.setLong(3, pojo.getPhoneNumber());
				statement.setInt(4, pojo.getSalary());
				
				int confirm = statement.executeUpdate();
				System.out.println(confirm==1? "Employee Added ":" Error while Adding Employee");
				statement.close();
				connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		}

