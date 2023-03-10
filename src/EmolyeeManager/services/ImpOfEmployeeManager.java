package EmolyeeManager.services;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.Scanner;

import EmolyeeManager.dao.EmployeeAdd;
import EmolyeeManager.dao.EmployeeRemove;
import EmolyeeManager.exceptions.EmployeeAlreadyExistException;
import EmolyeeManager.exceptions.EmployeeNotFound;
import EmolyeeManager.exceptions.MobileNumberException;
import EmolyeeManager.interfaces.InterfaceEmployeeManager;
import EmolyeeManager.model.EmployeePojo;
import EmolyeeManager.utility.IRegexEmployeeRegistration;
import EmolyeeManager.utility.RegexEmployeeRegistration;


public class ImpOfEmployeeManager implements InterfaceEmployeeManager
{

	static int sal=0;
	static Scanner SCANNER = new  Scanner(System.in);
	private static EmployeePojo[] employeePojo = new EmployeePojo[10];

	static EmployeeAdd add = new  EmployeeAdd();
	static EmployeeRemove remove = new EmployeeRemove();
	static IRegexEmployeeRegistration regx = new RegexEmployeeRegistration();
	
	public int createContact(EmployeePojo employee) throws SQLException, EmployeeAlreadyExistException, MobileNumberException {

	
		int index = getIndexForNextEmptyLocation();
		if(index != -1 && regx.validMobileNumber(employee.getFirstName()))
		{
		employeePojo[index]= employee;
		System.out.println("Employee Added at index :: "+index);
		add.addEmployee(employee);
		printDetails();
		}
		else
		{
			System.out.println("Cannot Add");
		}
		return index;
	}
	private int getIndexForNextEmptyLocation()
	{
		for (int i=0;i<employeePojo.length;i++)
		{
			if(employeePojo[i]==null)
			{
				return i;
			}
		}
		return -1;
	}

	public void removeEmployee(String firstName) throws SQLException, EmployeeNotFound, EmployeeAlreadyExistException 
	{
		boolean employeeRemoved= false;
		for (int i = 0; i<employeePojo.length;i++)
		{
			if(employeePojo[i] != null && employeePojo[i].getFirstName().equals(firstName))
			{
				employeePojo[i]= null;
				System.out.println(firstName + " has been removed .");
				employeeRemoved=true;
				remove.removeEmployee(firstName);
				break;
			}
			
		}
		if(!employeeRemoved)
		{
			System.out.println("Not Found");
		}
	}

	public void searchEmployee(String empID) 
	{

		int index = findById(empID);
		if(index != -1)
		{
			showEmployeeDetails(employeePojo[index]);
		}
		else
			System.out.println("No records Found of "+empID);

	}
	
	private int findById(String empID)
	{
		for (int i =0; i<employeePojo.length;i++)
		{
			if(employeePojo[i] != null && employeePojo[i].getEmpID().equals(empID))
			{
				return i;
			}
		}
		return -1;

	}

	public void sortBySalary() 
	{

		System.out.println("Sorting by Salary :: ");
		for (int i =0; i<employeePojo.length;i++)
		{
			for (int j =i+1; j<employeePojo.length;j++)
			{
				if(employeePojo[i] != null && employeePojo[j] != null && employeePojo[i].getSalary()<employeePojo[j].getSalary())
				{
					EmployeePojo temp = employeePojo[i];
					employeePojo[i]= employeePojo[j];
					employeePojo[j]= temp;
				}

			}
		}
		printDetails();
	}

	public void calculateavgSalary()
	{
		int totalSalary=0;
		int count =0;
		for (int i =0; i<employeePojo.length;i++)
		{
			if(employeePojo[i] != null)
			{
				totalSalary += employeePojo[i].getSalary();
				count++;
			}
		}
		double avgSalary = (double)totalSalary/count;
		System.out.println("Average salary :: "+avgSalary);

	}

	public void printDetails()
	{
		for (int i = 0; i<employeePojo.length;i++)
		{
			showEmployeeDetails(employeePojo[i]);
		}
	}
	private void showEmployeeDetails(EmployeePojo employee)
	{
		if(employee != null)
		{
			System.out.println("<<<<<<Employee Details>>>>>>");
			System.out.println("Employee Id :: "+ employee.getEmpID());
			System.out.println("First Name :: "+employee.getFirstName());
			System.out.println("Last Name :: "+employee.getLastName());
			System.out.println("Employee Phone Number :: "+employee.getPhoneNumber());
			System.out.println("Salary :: "+employee.getSalary());

		}

	}

}
