package Model;
import Interfaces.*;

public class Doctor extends Medical implements getDataInterface{
	private int employeeSalary;
	private String jobTitle;

	public Doctor(String humanName, int employeeId, boolean canDrawBlood, boolean canCareForPatients,
			int employeeSalary, String jobTitle) {
		super(humanName, employeeId, canDrawBlood, canCareForPatients);

		this.employeeSalary = employeeSalary;
		this.jobTitle = "Doctor";

	}
        @Override
	public int getEmployeeSalary() {
		return employeeSalary;
	}
        @Override
	public String getJobTitle() {
		return jobTitle;
	}

}
