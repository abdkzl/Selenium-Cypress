package tests;


import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.US18_HoversPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US18_HoversTest {
    HomePage hp = new HomePage();
    US18_HoversPage hoversPage=new US18_HoversPage();
    Actions action = new Actions(Driver.getDriver());

    @Test
    public void hovers(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        ReusableMethods.waitForPageToLoad(10);
    }

    
    
    
    

    
    
    
    
    
    
    
    

    
	
	
	
	
	
	
	
	
	
	

    
    
}
