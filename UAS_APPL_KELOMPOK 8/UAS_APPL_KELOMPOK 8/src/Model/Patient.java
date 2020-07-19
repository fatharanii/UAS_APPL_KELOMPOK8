package Model;
import Interfaces.*;

public class Patient extends Human {
	private static final int BLOOD_LEVEL = 20;
	private static final int HEALTH_LEVEL = 10;

	private int bloodLevel;
	private int healthLevel;

	public Patient(String humanName, int bloodLevel, int healthLevel) {
		super(humanName);
		this.bloodLevel = bloodLevel;
		this.healthLevel = healthLevel;
	}

	public int getBloodLevel() {
		return bloodLevel;
	}

	public int getHealthLevel() {
		return healthLevel;
	}

	public void curePatients() {
		healthLevel = healthLevel + 1;
		if (healthLevel > HEALTH_LEVEL) {
			healthLevel = 10;
		}

		// incrementing by =+ is not working for some reason
	}

	public void cureOnePatient() {
		healthLevel = healthLevel + 3;
		if (healthLevel > HEALTH_LEVEL) {
			healthLevel = 10;
		}
	}

	public void healthLevelDecrement() {
		healthLevel--;
	}

	public void bloodLevelIncrement() {
		if (bloodLevel < BLOOD_LEVEL) {
			bloodLevel++;
		}
	}

	public void bloodSamples() {
		bloodLevel = bloodLevel - 5;
	}

	public void riskySurgery() {
		if (bloodLevel < 10) {
			healthLevel = 0;
		} else {
			healthLevel = 9;
		}
	}
}
