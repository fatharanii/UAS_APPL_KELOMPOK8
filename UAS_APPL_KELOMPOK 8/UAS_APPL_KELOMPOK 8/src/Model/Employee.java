package Model;

import java.util.Random;

public abstract class Employee extends Human {
	Random employeeIdnumber = new Random();
	private int employeeId;

	public Employee(String humanName, int employeeId) {
		super(humanName);
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		if (employeeId == 0) {
			this.employeeId = employeeIdnumber.nextInt(1000);
		}
		return employeeId;
	}

	public void incrementStatus() {
		return;

	}

}
