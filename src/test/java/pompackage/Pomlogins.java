package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basejava.BaseHRMclass;

public class Pomlogins extends BaseHRMclass {
	
		//object repositry
	
	@FindBy(id="txtUsername") WebElement Username;  //@findby replacing driver.findelements by.id
	@FindBy (id="txtPassword")WebElement Password;     //and we are stroing value in variable
    @FindBy (id="btnLogin") WebElement Loginbtn;
    
    
    //intiate page elements
    
    public Pomlogins () {
    	
    	PageFactory.initElements(driver,this); //initElemnts is to acces element on that page its mandatory 
    	
    }
    public void typeusername(String name) {
    	
    Username.sendKeys(name);
    }
    public void typepasswor(String name) {
    	
        Password.sendKeys(name);
    }
    public void clickbtn() {
    	
        Loginbtn.click();
    }
    public String verify() {
    	return driver.getTitle();
    }
}
