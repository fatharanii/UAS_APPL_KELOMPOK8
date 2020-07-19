package Test;

/*	Nama : Hanifah Sholihat
	Nim  : 181524012
*/ 
import static org.junit.Assert.*;

import org.junit.Test;

import Services.HospitalMethods;

public class TestHospitalMethods {

	private HospitalMethods test = new HospitalMethods();
	//private ActualPhysicalHospital test1 = new ActualPhysicalHospital();
	
	
	@Test
	public void testEmployeeList() {
		test.employeeList();;
	}
	@Test
	public void testCalculatePay() {
		test.calculatePay();
	}
	
	@Test
	public void testAnyoneWhoCanDrawBlood() {
		test.anyoneWhoCanDrawBlood();
	}
	
	@Test
	public void testPatientList() {
		test.patientList();
	}
	
	@Test
	public void testAddEmployee() {
		test.addEmployee(1);
	}
	
	@Test
	public void testdeleteEmployee() {
		test.deleteEmployee();
	}
	
	@Test
	public void testUpdateEmployee() {
		test.updateEmployee();
	}
	
	@Test
	public void testAddPatient() {
		test.addPatients(1);
	}
	
	@Test
	public void testDeletePatient() {
		test.deletePatient();;
	}
	
	@Test
	public void testCureAllPatient() {
		test.cureAllPatients();
	}
	
	@Test
	public void testtakeBloodSamples() {
		test.takeBloodSamples();
	}
	
	@Test
	public void testincrementHospitalMethods() {
		test.incrementHospitalMethods();
	}
}
