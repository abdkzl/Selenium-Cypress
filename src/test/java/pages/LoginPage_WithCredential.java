package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Driver;
import utilities.ReusableMethods;

public class LoginPage_WithCredential {

    public LoginPage_WithCredential() {
        PageFactory.initElements(utilities.Driver.getDriver(), this);
    }

    Actions action = new Actions(Driver.getDriver());

    @FindBy(xpath = "//h2[text()='Login Page']")
    public WebElement title;

    @FindBy(css = "input[name='username']")
    public WebElement userName;

    @FindBy(css = "input[name='password']")
    public WebElement userPassword;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[text()[normalize-space()='']] ")
    public WebElement loggedMessage;

    @FindBy(xpath = "//div[text()[normalize-space()='You logged out of the secure area!']] ")
    public WebElement loggedOutMessage;

    @FindBy(xpath = "//h2[normalize-space()='Secure Area']")
    public WebElement loggedPageTitle;

    @FindBy(xpath = "//i[normalize-space()='Logout']")
    public WebElement logoutButton;

    public void url() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/login");

    }

    public void login(String username, String password) {
        userName.sendKeys(username);
        userPassword.sendKeys(password);
        loginButton.click();

    }

    public void assertion() {
        String actualResult = loggedMessage.getText();
        String expectedResult = "You logged into a secure area!";

        System.out.println(actualResult);
        System.out.println(expectedResult);
        Assert.assertTrue(actualResult.contains(expectedResult));
        System.out.println(loggedPageTitle.getText());
        Assert.assertEquals(loggedPageTitle.getText(), "Secure Area");
    }

    public void logout(){
        logoutButton.click();

        System.out.println(loggedOutMessage.getText());
        String actualResult =loggedOutMessage.getText();
        String expectedResult ="You logged out of the secure area!";
        Assert.assertTrue(actualResult.contains(expectedResult));
       

    }

    public void ccsAssertion(){
        action.moveToElement(loginButton).perform();
        String shadowElement =loginButton.getCssValue("box-shadow");//rgba(255, 255, 255, 0.5) 0px 1px 0px 0px inset
        Assert.assertEquals(shadowElement, "rgba(255, 255, 255, 0.5) 0px 1px 0px 0px inset");
        System.out.println(shadowElement);

        String colorElement =loginButton.getCssValue("box-shadow");//rgba(255, 255, 255, 0.5) 0px 1px 0px 0px inset
        Assert.assertEquals(colorElement, "rgba(255, 255, 255, 0.5) 0px 1px 0px 0px inset");
        System.out.println(colorElement);


        //ReusableMethods.waitFor(10);



       // String colorBefore=w.getCssValue("color"); //rgba(34, 34, 34, 1)
        //String hexBefore=Colors.fromString(colorBefore).asHex(); //#DA4B4B
       
       
       // Assert.assertEquals(hexBefore, "#da4b4b");
   
      // actions.moveToElement(w).perform();
       
       // String colorAfter=w.getCssValue("color");
       // String hexAfter=Color.fromString(colorAfter).asHex();
       // Assert.assertEquals(hexAfter, "#000000");



    }

}
