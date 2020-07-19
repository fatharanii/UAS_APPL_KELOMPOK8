package Main;

import Services.ActualPhysicalHospital;
import Services.HospitalMethods;
import Model.Employee;
import Model.Janitor;
import Model.Human;
import Model.Nurse;
import Model.Patient;
import Model.Surgeon;
import Model.Doctor;
import Model.Medical;
import Model.Receptionist;
import java.util.Scanner;

public class Application {
	public static Scanner userInput = new Scanner(System.in);
	public static HospitalMethods virtualHospital = new HospitalMethods();
	public static ActualPhysicalHospital physicalHospital = new ActualPhysicalHospital(91, 8, 0);

	public static void main(String[] args) {
		int nurseTicker = 0;
		int doctorTicker = 0;
		int surgeonTicker = 0;
		int receptionistTicker = 0;
		int janitorTicker = 0;

		// TODO Auto-generated method stub

		Employee employee1 = new Doctor("Heimer", 0, true, true, 1000, null);
		Employee employee2 = new Surgeon("Schmidt", 0, true, true, 2000, null);
		Employee employee3 = new Nurse("John", 0, true, true, 3000, null);
		Employee employee4 = new Receptionist("Jacob", 0, 2000, null);
		Employee employee5 = new Janitor("Jingle", 0, 300, null, false);
		Patient patient1 = new Patient("Lacey", 20, 10);
		Patient patient2 = new Patient("Kendra", 20, 10);
		Patient patient3 = new Patient("Donnie", 20, 10);
		Patient patient4 = new Patient("Allen", 20, 10);
		Patient patient5 = new Patient("Anthony", 20, 10);
		Patient patient6 = new Patient("Jessica", 20, 10);
		Patient patient7 = new Patient("Person", 20, 10);

		virtualHospital.addHuman(employee1);
		virtualHospital.addHuman(employee2);
		virtualHospital.addHuman(employee3);
		virtualHospital.addHuman(employee4);
		virtualHospital.addHuman(employee5);
		virtualHospital.addHuman(employee5);
		virtualHospital.addHuman(patient1);

		System.out.println("*****************************************");
		System.out.println("Welcome To The Hospital Management System");
		System.out.println("*****************************************");

		System.out.println("\tEnter 1 to Start The Game");
		System.out.println("*****************************************");
		int userMenuChoice = userInput.nextInt();
		userInput.nextLine();

		while (userMenuChoice != 13) {

			System.out.println("What would you like to do?");
			System.out.println("*****************************************");
			System.out.println("1. View List Of Employees");
			System.out.println("2. View Payroll Information");
			System.out.println("3. View Who Can Take A Blood Sample");
			System.out.println("4. Check The Status Of The Patients");
			System.out.println("5. Check The Cleanliness Of The Hospital");
			System.out.println("6. Check The Phones");
                        System.out.println("7. Add Employee");
                        System.out.println("8. Delete Employee");
                        System.out.println("9. Add Patients");
                        System.out.println("10. Update Employee");
                        System.out.println("11. Delete Patient");
			System.out.println("12. Enter Task Menu");
			System.out.println("13. Exit");
			System.out.println("-----------------------------------------");
			userMenuChoice = userInput.nextInt();
			userInput.nextLine();

			switch (userMenuChoice) {

			case 1:
				virtualHospital.employeeList();
				break;
			case 2:
				virtualHospital.calculatePay();
				break;
			case 3:
				virtualHospital.anyoneWhoCanDrawBlood();
				break;
			case 4:
				virtualHospital.patientList();
				break;
			case 5:
				physicalHospital.hosptialCleanLevel();
				break;
			case 6:
				physicalHospital.hospitalPhones();
				break;
                        case 7:
                                System.out.println("Enter The Amount of Employee that Wants to be added : ");
                                int amount = userInput.nextInt();
                                virtualHospital.addEmployee(amount);
				physicalHospital.hospitalPhones();
				break;
                        case 8:
				virtualHospital.deleteEmployee();
				break;
                        case 9:
                                System.out.println("Enter The Amount of Patients that Wants to be added : ");
                                amount = userInput.nextInt();
                                virtualHospital.addPatients(amount);
				physicalHospital.hospitalPhones();
				break;
                        case 10:
				virtualHospital.updateEmployee();
				break;
                        case 11:
				virtualHospital.deletePatient();
				break;
			case 12:
				System.out.println("*****************************************");
				System.out.println("You have entered the task menu, \n enter 1 to continue");
				System.out.println("-----------------------------------------");
				String userMenuChoice1 = userInput.nextLine();
				while (!userMenuChoice1.equals("9")) {
					System.out.println("What would you like to do?");
					System.out.println("*****************************************");
					System.out.println("1. Have nurse check on all patients.");
					System.out.println("2. Have doctor check on one patient.");
					System.out.println("3. Have receptionist take a call.");
					System.out.println("4. Have janitor clean.");
					System.out.println("5. Have surgeon perform surgery.");
					System.out.println("9. Exit to Main Menu");
					System.out.println("-----------------------------------------");

					userMenuChoice1 = userInput.nextLine();
					switch (userMenuChoice1) {
					case "1":
						if (nurseTicker == 0) {
							System.out.println(
									"the nurse will do rounds and check on all patients \nThis may take some time");
							virtualHospital.cureAllPatients();
							virtualHospital.takeBloodSamples();
							nurseTicker = nurseTicker + 15;
						} else {
							System.out.println("The nurse is busy.");
						}
						physicalHospital.incrementPhysicalHospital();
						virtualHospital.incrementHospitalMethods();
						if (nurseTicker > 0) {
							nurseTicker--;
						}
						if (janitorTicker > 0) {
							janitorTicker--;
						}
						if (receptionistTicker > 0) {
							receptionistTicker--;
						}
						if (doctorTicker > 0) {
							doctorTicker--;
						}
						if (surgeonTicker > 0) {
							surgeonTicker--;
						}
						break;
					case "2":
						if (doctorTicker == 0) {
							System.out.println("Select the patient you want to examine");
							virtualHospital.patientList();
							Human x = virtualHospital.getHuman(userInput.next());
							((Patient) x).curePatients();
							System.out.println("The doctor will check on the patient, \nThis may take some time");
							doctorTicker = doctorTicker + 10;
						} else {
							System.out.println("The doctor is busy with another patient");
						}
						physicalHospital.incrementPhysicalHospital();
						virtualHospital.incrementHospitalMethods();
						if (nurseTicker > 0) {
							nurseTicker--;
						}
						if (janitorTicker > 0) {
							janitorTicker--;
						}
						if (receptionistTicker > 0) {
							receptionistTicker--;
						}
						if (doctorTicker > 0) {
							doctorTicker--;
						}
						if (surgeonTicker > 0) {
							surgeonTicker--;
						}
						break;
					case "3":
						if (receptionistTicker == 0) {
							System.out.println("The receptionist picks up the phone \nThis might take a few minutes");
							receptionistTicker = receptionistTicker + 3;
							physicalHospital.pickUpPhone();
						} else {
							System.out.println("The receptionist is busy with another caller.");
						}
						physicalHospital.incrementPhysicalHospital();
						virtualHospital.incrementHospitalMethods();
						if (nurseTicker > 0) {
							nurseTicker--;
						}
						if (janitorTicker > 0) {
							janitorTicker--;
						}
						if (receptionistTicker > 0) {
							receptionistTicker--;
						}
						if (doctorTicker > 0) {
							doctorTicker--;
						}
						if (surgeonTicker > 0) {
							surgeonTicker--;
						}
						break;
					case "4":
						if (janitorTicker == 0) {
							System.out.println("The janitor grabs his mop  \nThis might take a while");
							janitorTicker = janitorTicker + 15;
							physicalHospital.cleanHospital();
						} else {
							System.out.println("The janitor is busy cleaning already");
						}
						physicalHospital.incrementPhysicalHospital();
						virtualHospital.incrementHospitalMethods();
						if (nurseTicker > 0) {
							nurseTicker--;
						}
						if (janitorTicker > 0) {
							janitorTicker--;
						}
						if (receptionistTicker > 0) {
							receptionistTicker--;
						}
						if (doctorTicker > 0) {
							doctorTicker--;
						}
						if (surgeonTicker > 0) {
							surgeonTicker--;
						}
						break;
					case "5":
						if (surgeonTicker == 0) {
							System.out.println(
									"Performing surgery is dangerous, \nthere is a chance the patient could die \nhowever if it is succesful the patient's \nhealth will increase substantially. \n Are you sure you want to perform surgery?");
							System.out.println("y/n?");
							{
								String yesNo = userInput.nextLine();
								if (yesNo.equalsIgnoreCase("y")) {
									System.out.println("Select the patient you want to perform surgery on.");
									virtualHospital.patientList();
									Human x = virtualHospital.getHuman(userInput.next());
									System.out
											.println("The surgeon will now attempt to save a life \nThis will a while");
									surgeonTicker = surgeonTicker + 35;
									virtualHospital.performSurgery();
								} else {
									break;
								}
							}
						} else {
							System.out.println("The surgeon is busy operating.");
						}
						physicalHospital.incrementPhysicalHospital();
						virtualHospital.incrementHospitalMethods();
						if (nurseTicker > 0) {
							nurseTicker--;
						}
						if (janitorTicker > 0) {
							janitorTicker--;
						}
						if (receptionistTicker > 0) {
							receptionistTicker--;
						}
						if (doctorTicker > 0) {
							doctorTicker--;
						}
						if (surgeonTicker > 0) {
							surgeonTicker--;
						}
						break;

					case "9":
						physicalHospital.incrementPhysicalHospital();
						virtualHospital.incrementHospitalMethods();
						if (nurseTicker > 0) {
							nurseTicker--;
						}
						if (janitorTicker > 0) {
							janitorTicker--;
						}
						if (receptionistTicker > 0) {
							receptionistTicker--;
						}
						if (doctorTicker > 0) {
							doctorTicker--;
						}
						if (surgeonTicker > 0) {
							surgeonTicker--;
						}
						break;

					}
				}
				break;
			case 13:
				break;
			}
			physicalHospital.incrementPhysicalHospital();
			virtualHospital.incrementHospitalMethods();
			if (nurseTicker > 0) {
				nurseTicker--;
			}
			if (janitorTicker > 0) {
				janitorTicker--;
			}
			if (receptionistTicker > 0) {
				receptionistTicker--;
			}
			if (doctorTicker > 0) {
				doctorTicker--;
			}
			if (surgeonTicker > 0) {
				surgeonTicker--;
			}

		}
		System.out.println("\t Application Closed");
		System.out.println("\t     Goodbye.");
	}
}
