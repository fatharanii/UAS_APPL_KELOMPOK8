package Services;
import Model.Employee;
import Model.Janitor;
import Model.Human;
import Model.Nurse;
import Model.Patient;
import Model.Surgeon;
import Model.Doctor;
import Model.Medical;
import Model.Receptionist;

import java.util.HashMap;
import java.util.Scanner;

public class HospitalMethods {
        public static Scanner userInput = new Scanner(System.in);
	private HashMap<String, Human> humans = new HashMap<String, Human>();
        private Doctor doctor;

	public void addHuman(Human hospitalStaff) {
		humans.put(hospitalStaff.getHumanName(), hospitalStaff);
	}

	private int tick = 0;

	public void calculatePay() {
		System.out.println("Here is the payroll information:");
		System.out.println("Name \tID \tSalary");
		for (Human human : humans.values()) {
			if (human instanceof Doctor) {
				System.out.println((((Doctor) human).getHumanName()) + " \t" + (((Doctor) human).getEmployeeId())
						+ " \t" + (((Doctor) human).getEmployeeSalary()));
			} else if (human instanceof Surgeon) {
				System.out.println((((Surgeon) human).getHumanName()) + "\t" + (((Surgeon) human).getEmployeeId())
						+ " \t" + (((Surgeon) human).getEmployeeSalary()));
			} else if (human instanceof Nurse) {
				System.out.println((((Nurse) human).getHumanName()) + " \t" + (((Nurse) human).getEmployeeId()) + " \t"
						+ (((Nurse) human).getEmployeeSalary()));
			} else if (human instanceof Receptionist) {
				System.out.println(
						(((Receptionist) human).getHumanName()) + " \t" + (((Receptionist) human).getEmployeeId())
								+ " \t" + (((Receptionist) human).getEmployeeSalary()));
			} else if (human instanceof Janitor) {
				System.out.println((((Janitor) human).getHumanName()) + "\t" + (((Janitor) human).getEmployeeId())
						+ " \t" + (((Janitor) human).getEmployeeSalary()));
			}
		}
		System.out.println("-----------------------------------------");
	}

//	public void allEmployeeId() {
//		for (Employee human : humans.values()) {
//			System.out.println((human).getEmployeeId());
//		}
//	}

	public void employeeList() {
		System.out.println("Here is a list of all employees");
		System.out.println("Title \t\tName \tID");
		for (Human human : humans.values()) {
			if (human instanceof Doctor) {
				System.out.println((((Doctor) human).getJobTitle()) + " \t\t" + (((Doctor) human).getHumanName())
						+ " \t" + (((Doctor) human).getEmployeeId()));
			} else if (human instanceof Surgeon) {
				System.out.println((((Surgeon) human).getJobTitle()) + "\t\t" + (((Surgeon) human).getHumanName())
						+ "\t" + (((Surgeon) human).getEmployeeId()));
			} else if (human instanceof Nurse) {
				System.out.println((((Nurse) human).getJobTitle()) + " \t\t" + (((Nurse) human).getHumanName()) + " \t"
						+ (((Nurse) human).getEmployeeId()));
			} else if (human instanceof Receptionist) {
				System.out.println((((Receptionist) human).getJobTitle()) + " \t"
						+ (((Receptionist) human).getHumanName()) + " \t" + (((Receptionist) human).getEmployeeId()));
			} else if (human instanceof Janitor) {
				System.out.println((((Janitor) human).getJobTitle()) + "\t\t" + (((Janitor) human).getHumanName())
						+ " \t" + (((Janitor) human).getEmployeeId()));
			}
		}
		System.out.println("-----------------------------------------");
	}

	public void anyoneWhoCanDrawBlood() {
		System.out.println("Here is a list of all employees who can draw blood samples");
		System.out.println("Title \tName \tID");
		for (Human human : humans.values()) {
			if (human instanceof Medical) {
				if (human instanceof Doctor) {
					System.out.println((((Doctor) human).getJobTitle()) + " \t" + (((Doctor) human).getHumanName())
							+ " \t" + (((Doctor) human).getEmployeeId()));
				} else if (human instanceof Surgeon) {
					System.out.println((((Surgeon) human).getJobTitle()) + "\t" + (((Surgeon) human).getHumanName())
							+ "\t" + (((Surgeon) human).getEmployeeId()));
				} else if (human instanceof Nurse) {
					System.out.println((((Nurse) human).getJobTitle()) + " \t" + (((Nurse) human).getHumanName())
							+ " \t" + (((Nurse) human).getEmployeeId()));
				} else if (human instanceof Receptionist) {
//			
				}
			}
		}
		System.out.println("-----------------------------------------");
	}

	public void nurseList() {
		System.out.println("Here is a list of all nurses");
		System.out.println("Title \tName \tID");
		for (Human human : humans.values()) {
			if (human instanceof Nurse) {
				System.out.println((((Nurse) human).getJobTitle()) + " \t" + (((Nurse) human).getHumanName()) + " \t"
						+ (((Nurse) human).getEmployeeId()));
			}
		}
	}

	public void patientList() {
		System.out.println("Here is a list of all patients");
		System.out.println("Name \tHealth Level \tBlood Level");
		for (Human human : humans.values()) {
			if (human instanceof Patient)
				System.out.println(((Patient) human).getHumanName() + "\t" + ((Patient) human).getHealthLevel() + "\t\t"
						+ ((Patient) human).getBloodLevel());
		}
		System.out.println("-----------------------------------------");
	}

	public void cureAllPatients() {
		for (Human human : humans.values()) {
			if (human instanceof Patient)
				((Patient) human).curePatients();
		}
	}

	public void selectPatientToCure() {
		for (Human human : humans.values()) {
			if (human instanceof Patient)
				((Patient) human).cureOnePatient();
		}
	}

	public Human getHuman(String selectedHuman) {
		return humans.get(selectedHuman);
	}

	public void incrementHospitalMethods() {
		tick++;
		for (Human human : humans.values()) {
			if (tick % 7 == 0) {
				if (human instanceof Patient) {
					((Patient) human).healthLevelDecrement();
				}
			}
			if (tick % 20 == 0) {
				if (human instanceof Patient) {
					((Patient) human).bloodLevelIncrement();
				}

			}
			if (human instanceof Patient) {
				if (((Patient) human).getHealthLevel() < 3) {
					System.out.println("Patient " + ((Patient) human).getHumanName()
							+ " is dying, \nyou should think about performing surgery.");
					System.out.println("Blood Level: " + ((Patient) human).getBloodLevel() + "\nHealth Level: "
							+ ((Patient) human).getHealthLevel());
				}
				if (((Patient) human).getBloodLevel() < 6) {
					System.out.println(
							"Patient " + ((Patient) human).getHumanName() + " has had too many blood samples taken.");
					System.out.println("Blood Level: " + ((Patient) human).getBloodLevel() + "\nHealth Level: "
							+ ((Patient) human).getHealthLevel());
				}
			}
			callDeath();
		}
	}

	public void takeBloodSamples() {
		for (Human human : humans.values()) {
			if (human instanceof Patient) {
				((Patient) human).bloodSamples();

			}
		}
	}

	public void performSurgery() {
		for (Human human : humans.values()) {
			if (human instanceof Patient) {
				((Patient) human).riskySurgery();
			}
		}

	}

	public void callDeath() {
		for (Human human : humans.values()) {
			if (human instanceof Patient) {
				if (((Patient) human).getHealthLevel() <= 0 || ((Patient) human).getBloodLevel() <= 0) {
					System.out.println("Patient " + ((Patient) human).getHumanName() + " has died.\nGame Over");
					System.exit(0);
					;
				}
			}
		}
	}
        /* Nama : Fatharani
            NIM : 181524009
         */
        public void deleteEmployee(){
            this.employeeList();
            System.out.println("Enter Name : ");
            String name = userInput.next();
            humans.remove(name);
            System.out.println("Employee Deleted");
            System.out.println("-----------------------------------------");
        }
        /* Nama : Fatharani
            NIM : 181524009
         */
        public boolean validation (String name){
            for (Human human : humans.values()){
                if (human.getHumanName().equals(name)){
                    return false;
                }
            }
            return true;
        }
        /* Nama : Fatharani
            NIM : 181524009
         */
        public void addPatients (int amount){
            Scanner patientInput = new Scanner (System.in);
            for (int i = 0; i<amount; i++){
                System.out.println("Enter Name : ");
                String name = patientInput.nextLine();
                boolean valid = this.validation(name);
                if (valid){
                    this.addHuman(new Patient (name, 20, 10));
                    System.out.println("Patient Added");
                    System.out.println("-----------------------------------------");
                }
                else {
                    System.out.println("Patient is Already Here");
                    System.out.println("-----------------------------------------");
                }
            }
        }
        /* Nama : Fatharani
            NIM : 181524009
         */
        public void addEmployee (int amount){
            for (int i = 0; i<amount; i++){
                System.out.println("Choose Employee Title");
                System.out.println("1. Doctor");
                System.out.println("2. Nurse");
                System.out.println("3. Surgeon");
                System.out.println("4. Receptionist");
                System.out.println("5. Janitor");
                int userMenuChoie = userInput.nextInt();
                userInput.nextLine();
                System.out.println("Enter Name : ");
                String name = userInput.nextLine();
                System.out.println("Enter Salary : ");
                int salary = userInput.nextInt();
                boolean valid = this.validation(name);
                if (valid){
                    switch (userMenuChoie){
                        case 1 :
                                this.addHuman(new Doctor (name,0,true,true,salary,null));
                                break;
                        case 2 :
                                this.addHuman(new Nurse (name,0,true,true,salary,null));
                                break;
                        case 3 :
                                this.addHuman(new Surgeon (name,0,true,true,salary,null));
                                break;
                        case 4 :
                                this.addHuman(new Receptionist (name,0,salary,null));
                                break;
                        case 5 :
                                this.addHuman(new Janitor (name,0,salary,null, false));
                                break;
                    }
                    System.out.println("Employee Added");
                    System.out.println("-----------------------------------------");
                }
                else {
                    System.out.println("The Name is Already Taken");
                    System.out.println("-----------------------------------------");
                }
            }
        }
        /* Nama : Fatharani
            NIM : 181524009
         */
        public void updateEmployee(){
            Scanner employeeInput = new Scanner(System.in);
            this.employeeList();
            String jobTitle;
            int id;
            int salary;
            boolean valid;
            System.out.println("Enter The Name of Employee You Want to Update: ");
            String name = userInput.next();
            for (Human human : humans.values()){
                if (human.getHumanName().equals(name)){
                    if (human instanceof Doctor) {
                            jobTitle = (((Doctor) human).getJobTitle());
                            id = (((Doctor) human).getEmployeeId());
                            salary = (((Doctor) human).getEmployeeSalary());
                            System.out.println(jobTitle + "\t" +  name + "\t" + id + "\t" + salary);
                            humans.remove(name);
                            System.out.println("Update Name : ");
                            name = employeeInput.nextLine();
                            System.out.println("Update Salary : ");
                            salary = employeeInput.nextInt();
                            valid = this.validation(name);
                            if (valid){
                                this.addHuman(new Doctor (name, id, true,true,salary,null));
                            }
                            break;
			} else if (human instanceof Surgeon) {
                            jobTitle = (((Surgeon) human).getJobTitle());
                            id = (((Surgeon) human).getEmployeeId());
                            salary = (((Surgeon) human).getEmployeeSalary());
                            System.out.println(jobTitle + "\t" +  name + "\t" + id + "\t" + salary);
                            humans.remove(name);
                            System.out.println("Update Name : ");
                            name = employeeInput.nextLine();
                            System.out.println("Update Salary : ");
                            salary = employeeInput.nextInt();
                            valid = this.validation(name);
                            if (valid){
                                this.addHuman(new Surgeon (name, id, true,true,salary,null));
                            }
                            break;
			} else if (human instanceof Nurse) {
                            jobTitle = (((Nurse) human).getJobTitle());
                            id = (((Nurse) human).getEmployeeId());
                            salary = (((Nurse) human).getEmployeeSalary());
                            System.out.println(jobTitle + "\t" +  name + "\t" + id + "\t" + salary);
                            humans.remove(name);
                            System.out.println("Update Name : ");
                            name = employeeInput.nextLine();
                            System.out.println("Update Salary : ");
                            salary = employeeInput.nextInt();
                            valid = this.validation(name);
                            if (valid){
                                this.addHuman(new Nurse (name, id, true,true,salary,null));
                            }
                            break;
			} else if (human instanceof Receptionist) {
                            jobTitle = (((Receptionist) human).getJobTitle());
                            id = (((Receptionist) human).getEmployeeId());
                            salary = (((Receptionist) human).getEmployeeSalary());
                            System.out.println(jobTitle + "\t" +  name + "\t" + id + "\t" + salary);
                            humans.remove(name);
                            System.out.println("Update Name : ");
                            name = employeeInput.nextLine();
                            System.out.println("Update Salary : ");
                            salary = employeeInput.nextInt();
                            this.addHuman(new Receptionist (name, id, salary,null));
                            break;
			} else if (human instanceof Janitor) {
                            jobTitle = (((Janitor) human).getJobTitle());
                            id = (((Janitor) human).getEmployeeId());
                            salary = (((Janitor) human).getEmployeeSalary());
                            System.out.println(jobTitle + "\t" +  name + "\t" + id + "\t" + salary);
                            humans.remove(name);
                            System.out.println("Update Name : ");
                            name = employeeInput.nextLine();
                            System.out.println("Update Salary : ");
                            salary = employeeInput.nextInt();
                            this.addHuman(new Janitor (name, id, salary,null, false));
                            break;
			}
                }
                System.out.println("Employee Updated");
		System.out.println("-----------------------------------------");
            }
        }
        /* Nama : Fatharani
            NIM : 181524009
         */
        public void deletePatient (){
            this.patientList();
            Scanner patientInput = new Scanner(System.in);
            System.out.println("Enter The Name of Patient You Want to Delete: ");
            String name = userInput.next();
            for (Human human : humans.values()){
               if (human.getHumanName().equals(name)){
                   if (human instanceof Patient){
                        int healthLevel = ((Patient) human).getHealthLevel();
                        int bloodLevel = ((Patient) human).getBloodLevel();
                        System.out.println(((Patient) human).getHumanName() + "\t" + healthLevel + "\t\t"+ bloodLevel);
                        humans.remove(name);
                        break;
                   }
               }
           }
            System.out.println("Patient1 Updated");
            System.out.println("-----------------------------------------");
        }
}