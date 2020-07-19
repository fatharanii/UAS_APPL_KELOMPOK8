package Model;
import Interfaces.*;

public class Janitor extends Employee implements getDataInterface{

	private String jobTitle;
	private int employeeSalary;
	private boolean isSweeping;

	public Janitor(String humanName, int employeeId, int employeeSalary, String jobTitle, boolean isSweeping) {
		super(humanName, employeeId);
		this.employeeSalary = employeeSalary;
		this.jobTitle = "Janitor";
	}
        @Override
	public String getJobTitle() {
		return jobTitle;
	}
        @Override
	public int getEmployeeSalary() {
		return employeeSalary;
	}

	public boolean getIsSweeping() {
		return isSweeping;
	}

}
