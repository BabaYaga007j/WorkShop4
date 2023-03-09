package EmolyeeManager.interfaces;

import EmolyeeManager.model.EmployeePojo;


/*A method to add an employee to the list
    A method to remove an employee from the list
    A method to search for an employee by their ID
    A method to sort the employees in the list by their salary (ascending or descending order)
A method to calculate the average salary of all employees
    A method to print the details of all employees in the list*/

public interface InterfaceEmployeeManager {
	
	int createContact(EmployeePojo employeeManagerPojo);
	void removeEmployee(String firstName);
	void searchEmployee(String empID);
	void sortBySalary();
	void calculateavgSalary();
	void printDetails();
	

}
