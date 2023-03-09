package EmolyeeManager.controller;

import java.sql.SQLException;
import java.util.Scanner;

import EmolyeeManager.exceptions.EmployeeAlreadyExistException;
import EmolyeeManager.exceptions.EmployeeNotFound;
import EmolyeeManager.exceptions.MobileNumberException;
import EmolyeeManager.interfaces.InterfaceEmployeeManager;
import EmolyeeManager.model.EmployeePojo;
import EmolyeeManager.services.ImpOfEmployeeManager;


/*A method to add an employee to the list
    A method to remove an employee from the list
    A method to search for an employee by their ID
    A method to sort the employees in the list by their salary (ascending or descending order)
A method to calculate the average salary of all employees
    A method to print the details of all employees in the list*/
public class EmployeeManagerMain {


	private static Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {

		InterfaceEmployeeManager employeeManager = new ImpOfEmployeeManager();

		byte menueChoice =0;
		try
		{
		do 
		{
			System.out.println("Welcome to EmployeeManager System");

			System.out.println("1. Add Details of Employee ");
			System.out.println("2. Remove Employee From List ");
			System.out.println("3. Search Employee by Id ");
			System.out.println("4. Sort Employee by Salary ");
			System.out.println("5. Average Salary ");
			System.out.println("6. Print all Details ");

			byte userChoice= SCANNER.nextByte();
			switch(userChoice)
			{
			case 1:
				System.out.println("Creating");
				EmployeePojo employeeManagerPojo = getEmployeelist();
				int index1= employeeManager.createContact(employeeManagerPojo);
				System.out.println("Employee id index "+index1);
				break;

			case 2:
				System.out.println("Enter FirstName of employee to remove :: ");
				String firstName1= SCANNER.next();
				employeeManager.removeEmployee(firstName1);

				break;
			case 3:
				System.out.println("Enter EmpId to search :: ");
				String empId1= SCANNER.next();
				employeeManager.searchEmployee(empId1);

				break;
			case 4:
				employeeManager.sortBySalary();

				break;
			case 5:
				employeeManager.calculateavgSalary();

				break;
			case 6:
				employeeManager.printDetails();

				break;
				
				default:
					System.out.println("Invalid Choice ");
			}
			System.out.println("Press 1 to continue "+'\n'+"Any number to exit");
			menueChoice = SCANNER.nextByte();
		}while(menueChoice==1);
		}
		catch (EmployeeAlreadyExistException e) {
			System.out.println(e);
		}
		catch (EmployeeNotFound e) {
			System.out.println(e);
		}
		catch (SQLException e) {
			System.out.println(e);
		}catch (MobileNumberException e) {
			System.out.println(e);
		}
		catch (Exception e) {
		System.out.println(e);
		}
		
	}
		

		private static EmployeePojo getEmployeelist()
		{
			EmployeePojo employeeManagerPojo = new EmployeePojo();
			System.out.println("Enter EmpId :: ");
			String empID = SCANNER.next();
			employeeManagerPojo.setEmpID(empID);

			System.out.println("Enter FirstName :: ");
			String firstName= SCANNER.next();
			employeeManagerPojo.setFirstName(firstName);

			System.out.println("Enter LastName :: ");
			String lastName= SCANNER.next();
			employeeManagerPojo.setLastName(lastName);

			System.out.println("Enter Phone Number :: ");
			Long phoneNumber= SCANNER.nextLong();
			employeeManagerPojo.setPhoneNumber(phoneNumber);

			System.out.println("Enter Salary :: ");
			int salary= SCANNER.nextInt();
			employeeManagerPojo.setSalary(salary);
			return employeeManagerPojo;
		}
	}
