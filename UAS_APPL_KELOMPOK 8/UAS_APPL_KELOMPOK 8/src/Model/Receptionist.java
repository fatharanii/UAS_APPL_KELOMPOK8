package Model;
import Interfaces.*;

public class Receptionist extends Employee implements getDataInterface{

	private int employeeSalary;
	private String jobTitle;

	public Receptionist(String humanName, int employeeId, int employeeSalary, String jobTitle) {
		super(humanName, employeeId);

		this.employeeSalary = employeeSalary;
		this.jobTitle = "Receptionist";

	}
        @Override
	public String getJobTitle() {
		return jobTitle;
	}
        @Override
	public int getEmployeeSalary() {
		return employeeSalary;
	}

}