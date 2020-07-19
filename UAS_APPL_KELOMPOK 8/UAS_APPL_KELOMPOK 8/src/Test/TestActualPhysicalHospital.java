package Test;

/*Nama : Hanifah Sholihat
  Nim  : 181524012
*/ 
import static org.junit.Assert.*;

import org.junit.Test;

import Services.ActualPhysicalHospital;

public class TestActualPhysicalHospital {
	private ActualPhysicalHospital test = new ActualPhysicalHospital();
	
	@Test
	public void testHospitalCleanLevel() {
		test.hosptialCleanLevel();
	}
	
	@Test
	public void testHospitalPhones() {
		test.hospitalPhones();
	}
	
	@Test
	public void testPhysicalHospital() {
		test.incrementPhysicalHospital();;
	}
	
	@Test
	public void tsetCleanHospital() {
		test.cleanHospital();
	}

}
