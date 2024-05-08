package TestCases;
 
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

import pageObjects.CarInsurance;
import pageObjects.TravelInsurance;

//Author: Rishasri, Sri Devi
//Date of creation: 28/04/2024
//Date of updation: 03/05/2024

public class tests extends baseclass {
	TravelInsurance obj1;
	CarInsurance obj2;
	
	// Author: Sri Devi
	// Date of creation: 28/04/2024
	//Date of updation: 30/04/2024
	
	@Test(priority=1)
	public void open_travel_insurance() throws InterruptedException
	{
		obj1=new TravelInsurance(driver);
		obj1.clickTravelInsurance();
	}
	
	// Author: Sri Devi
	// Date of creation: 28/04/2024
	//Date of updation: 30/04/2024
	
	@Test(priority=2)
	public void select_destination() throws InterruptedException
	{
		obj1.clickDestination();
		obj1.clickUnitedKingdom();
		obj1.clickNext();
	}
 
	// Author: Sri Devi
	// Date of creation: 28/04/2024
	//Date of updation: 30/04/2024
	
	@Test(priority=3)
	public void click_Date()
	{
		obj1.clickDate();
		obj1.selectDates();
		obj1.clickNext2();
	}
 
	// Author: Sri Devi
	// Date of creation: 29/04/2024
	//Date of updation: 02/05/2024
	
	@Test(priority=4)
	public void click_No_of_persons() throws InterruptedException
	{
		obj1.clickNoOfPersons();
		obj1.clickdrop_1();
		obj1.selectAge_22();
		obj1.clickdrop_2();
		obj1.selectAge_21();
		obj1.clickNext3();
	}
	
	// Author: Sri Devi
	// Date of creation: 29/04/2024
	//Date of updation: 02/05/2024
	
	@Test(priority=5)
	public void MedicalHistory() throws InterruptedException
	{
		obj1.click_yes();
		obj1.CheckBox1();
		obj1.CheckBox2();
		obj1.clickNext4();
	}
	
	// Author: Rishasri
	// Date of creation: 29/04/2024
	//Date of updation: 02/05/2024
	
	@Test(priority=6)
	public void enter_mob_no() throws InterruptedException
	{
		obj1.click_mobNo();
		obj1.enter_mobNo();
		obj1.click_view_plan();
	}
	
	// Author: Rishasri
	// Date of creation: 29/04/2024
	//Date of updation: 02/05/2024
	
	@Test(priority=7)
	public void Viewplan() throws InterruptedException
	{
		obj1.plans();
		obj1.days();
		obj1.apply();
	}
	
	// Author: Rishasri
	// Date of creation: 30/04/2024
	//Date of updation: 03/05/2024
	
	@Test(priority=8)
	public void lowest_prices_of_three_insurances() throws InterruptedException
	{
	obj1.select_low_to_high();	
	}
	
	// Author: Rishasri
	// Date of creation: 30/04/2024
	//Date of updation: 03/05/2024
	
	@Test(priority=9)
	public void print_First_Three_companies()
	{
		obj1.companiesName();
		obj1.prices();
	}
	
	// Author: Rishasri
	// Date of creation: 28/04/2024
	//Date of updation: 30/04/2024
	
	@Test(priority=10)
	public void go_To_Home_Page()
	{
		obj2=new CarInsurance(driver);
		obj2.click_policy_bazaar_logo();
		obj2.insuranceproduct();
	}
	
	// Author: Rishasri
	// Date of creation: 28/04/2024
	//Date of updation: 30/04/2024
	
	@Test(priority=11)
	public void carInsurance() throws InterruptedException {	
		obj2.carinsurance();
		obj2.Clickhere();
	}
	
	// Author: Rishasri
	// Date of creation: 29/04/2024
	//Date of updation: 02/05/2024
	
	@Test(priority=12)
	public void cardetails() throws InterruptedException {
		obj2.city();
		obj2.rto();
		obj2.brand();
		obj2.model();
		obj2.Fuel();
		obj2.variant();
	}
	
	// Author: Sri Devi
	// Date of creation: 29/04/2024
	//Date of updation: 03/05/2024
	
	@Test(priority=13)
	public void InputValues() {
		obj2.name();
		obj2.email();
		obj2.mobnum();
		obj2.viewprice();		
	}
 
}