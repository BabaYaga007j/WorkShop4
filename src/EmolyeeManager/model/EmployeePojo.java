package EmolyeeManager.model;



/*Program: Write a Java program to create a class called "EmployeeManager" with instance variables "employees" (a list of Employee objects) and "numEmployees" (the number of employees in the list). Include the following methods:
A method to add an employee to the list
    A method to remove an employee from the list
    A method to search for an employee by their ID
    A method to sort the employees in the list by their salary (ascending or descending order)
A method to calculate the average salary of all employees
    A method to print the details of all employees in the list*/
public class EmployeePojo {
	
	private String empID;
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private int salary;
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String toString() {
		return "EmployeeManagerPojo [empID=" + empID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", salary=" + salary + "]";
	}
	
	}
	
	

