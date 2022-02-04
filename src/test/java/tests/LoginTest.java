package tests;

import utilities.Driver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pages.LoginPage_WithCredential;

public class LoginTest {

    LoginPage_WithCredential log = new LoginPage_WithCredential();
    Actions action = new Actions(Driver.getDriver());

    @BeforeMethod
    
    public void setUp(){
       
        log.url();
        
    }

    @AfterMethod
    public void tear() {
        Driver.closeDriver();
    }

    @Test
    public void css(){
        log.ccsAssertion();

    }
    @Test
    public void loginPage(){
        
       
        log.login("tomsmith","SuperSecretPassword!");
        log.assertion();
    }

    @Test
    public void backward(){
        log.login("tomsmith","SuperSecretPassword!");
        log.logout();

    }

    
}
