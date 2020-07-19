package Services;

public class ActualPhysicalHospital {
	private int hospitalCleanliness;
	private int phoneCallers;
	private int tick;

	public ActualPhysicalHospital(int hospitalCleanliness, int phoneCallers, int tick) {
		this.hospitalCleanliness = hospitalCleanliness;
		this.phoneCallers = phoneCallers;
		this.tick = 0;
	}



	public ActualPhysicalHospital() {
		
	}

	public int getHospitalCleanliness() {
		return hospitalCleanliness;
	}

	public int getPhoneCallers() {
		return phoneCallers;
	}

	public void hospitalPhones() {
		if (phoneCallers == 0) {
			System.out.println("*There is no calls on the line");
		} else if (phoneCallers > 0 && phoneCallers <= 2) {
			System.out.println("*There is " + phoneCallers + " callers on hold.");
			System.out.println("You should ask the receptionist to \nanswer those.");
		} else if (phoneCallers > 2 && phoneCallers <= 5) {
			System.out.println("*There is " + phoneCallers + " callers on hold.");
			System.out.println("Now would be a good time to have the \nreceptionist answer the phones.");
		} else if (phoneCallers > 5 && phoneCallers <= 7) {
			System.out.println("*There is " + phoneCallers + " callers on hold.");
			System.out.println("Do your job and tell the receptionist \n to do her job.");
		} else if (phoneCallers > 7) {
			System.out.println("*There is " + phoneCallers + " callers on hold.");
			System.out.println("If you don't have the receptionist answer \nthese calls, you will be fired!");
		}
		System.out.println("-----------------------------------------");
	}

	public void hosptialCleanLevel() {
		if (hospitalCleanliness <= 20) {
			System.out.println("This place is on the verge of being \nshut down for health code violations.");
			System.out.println("You should have the Janitor clean.");
		} else if (hospitalCleanliness > 20 && hospitalCleanliness <= 40) {
			System.out.println(
					"Theres a lot of blood and vomit on the \nfloor, people might think we're running \na haunted house.");
			System.out.println("You should have the Janitor clean.");
		} else if (hospitalCleanliness > 40 && hospitalCleanliness <= 60) {
			System.out.println("The place is looking a bit dirty");
			System.out.println("You should have the Janitor clean");
		} else if (hospitalCleanliness > 60 && hospitalCleanliness <= 75) {
			System.out.println("The hospital is looking nice and clean!");
		} else if (hospitalCleanliness > 75 && hospitalCleanliness <= 90) {
			System.out.println(
					"The hospital is pretty clean, we should \nhave the health inspector come while \nit still looks nice");
		} else if (hospitalCleanliness > 90 && hospitalCleanliness <= 100) {
			System.out.println(
					"The hospital is so clean, the Surgeon \ncould do a triple bypass surgery right in \nthe lobby!");
		}
		System.out.println("-----------------------------------------");
	}

	public void incrementPhysicalHospital() {
		tick++;
		if (hospitalCleanliness > 100) {
			hospitalCleanliness = 100;
		}
		hospitalCleanliness -= 5;
		if (hospitalCleanliness == 90 || hospitalCleanliness == 40 || hospitalCleanliness == 20) {
			hosptialCleanLevel();
		}
		if (tick % 5 == 0) {
			phoneCallers++;
			System.out.println("**Ring Ring**");
		}
	}

	public void pickUpPhone() {
		phoneCallers--;
	}

	public void cleanHospital() {
		hospitalCleanliness = hospitalCleanliness + 25;
	}

	public void hospitalShutDown() {
		if (hospitalCleanliness > 10) {
			System.out.println("Your hospital is in shambles, \nThe health department has shut you down \nGAME OVER");
			System.exit(0);
		} else if (phoneCallers <= 0) {
			System.out.println(
					"You failed to perform your manaerial duties. \nYour boss fired you for failing to answer phone calls, \nWhich is kinda lame.");
			System.exit(0);
		}
	}
}
