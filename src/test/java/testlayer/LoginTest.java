package testlayer;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basejava.BaseHRMclass;
import pompackage.Pomlogins;
import testdata.Excelsheet;

public class LoginTest extends BaseHRMclass {
	
	Pomlogins log;
	
	public LoginTest() {
       
		super();
	}
		
	@BeforeMethod
	public void initsetup() {
		initiation();
		screenshot("Login");
		
		log=new Pomlogins();
	}
	
	@Test(priority=1)
	public void Title() {
		String actual=log.verify();
		System.out.println(actual);
		Assert.assertEquals(actual,"OrangeHRM");
	}
	@DataProvider
	public Object Details() throws InterruptedException {
		Object result[][]=Excelsheet.readdata("Sheet1");
		Thread.sleep(2500);
		return result;
	}

@Test (priority=2,dataProvider ="Details")
	public void login(String name,String Password) {
		log.typeusername(name);
		log.typepasswor(Password);
		//log.clickbtn();
	}
}
