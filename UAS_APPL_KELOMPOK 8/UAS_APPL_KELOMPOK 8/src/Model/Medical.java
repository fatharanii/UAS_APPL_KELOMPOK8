package Model;

public abstract class Medical extends Employee {

	private boolean canDrawBlood;
	private boolean canCareForPatients;

	public Medical(String humanName, int employeeId, boolean canDrawBlood, boolean canCareForPatients) {

		super(humanName, employeeId);

		this.canCareForPatients = true;
		this.canDrawBlood = true;

	}

	public void drawBlood() {

	}

	public void administerCare() {

	}

}