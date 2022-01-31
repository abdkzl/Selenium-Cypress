package tests;


import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class DynamicControlsTest {

    DynamicControlsPage dynamicControlsPage=new DynamicControlsPage();
    int timeToWaitInSec=10;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeToWaitInSec));

    @BeforeMethod
    public void setUp(){
     
     Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");
    
    }
    
    @Test
    public void checkboxTest(){
        dynamicControlsPage.checkbox.click();
        Assert.assertTrue(dynamicControlsPage.checkbox.isSelected());
        Assert.assertEquals(dynamicControlsPage.remove_add_button.getText(), "Remove");

        dynamicControlsPage.remove_add_button.click();
        ReusableMethods.waitForVisibility(dynamicControlsPage.loadingMessage, 5);
        Assert.assertTrue(dynamicControlsPage.loadingMessage.isDisplayed());
        Assert.assertEquals(dynamicControlsPage.loadingMessage.getText(), "Wait for it...");

        //webelementin invisible olmasini bekliyoruz.
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingMessage));
        
        ReusableMethods.waitForVisibility(dynamicControlsPage.generalMessage, 5);
        Assert.assertEquals(dynamicControlsPage.generalMessage.getText(), "It's gone!");
        Assert.assertEquals(dynamicControlsPage.remove_add_button.getText(), "Add");

        dynamicControlsPage.remove_add_button.click();
        ReusableMethods.waitForVisibility(dynamicControlsPage.loadingMessage, 5);
        Assert.assertTrue(dynamicControlsPage.loadingMessage.isDisplayed());
        Assert.assertEquals(dynamicControlsPage.loadingMessage.getText(), "Wait for it...");
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingMessage));
        ReusableMethods.waitForVisibility(dynamicControlsPage.generalMessage, 5);
        Assert.assertEquals(dynamicControlsPage.generalMessage.getText(), "It's back!");
    }

    
    @Test
    public void enabled_disabledButtonTest(){
        Assert.assertFalse(dynamicControlsPage.input_enable_button.isEnabled());
        dynamicControlsPage.enable_disable_button.click();
        ReusableMethods.waitForVisibility(dynamicControlsPage.loadingMessage, 5);
        Assert.assertTrue(dynamicControlsPage.loadingMessage.isDisplayed());
        Assert.assertEquals(dynamicControlsPage.loadingMessage.getText(), "Wait for it...");

        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingMessage));
        ReusableMethods.waitForClickablility(dynamicControlsPage.input_enable_button, 5);
        Assert.assertTrue(dynamicControlsPage.input_enable_button.isEnabled());

        ReusableMethods.waitForVisibility(dynamicControlsPage.generalMessage, 5);
        Assert.assertEquals(dynamicControlsPage.generalMessage.getText(), "It's enabled!");
        dynamicControlsPage.input_enable_button.sendKeys("Test Passed");

        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingMessage));
        //Assert.assertEquals(dynamicControlsPage.input_enable_button.getText(), "Test Passed");

        Assert.assertEquals(dynamicControlsPage.enable_disable_button.getText(), "Disable");

        dynamicControlsPage.enable_disable_button.click();

        ReusableMethods.waitForVisibility(dynamicControlsPage.loadingMessage, 5);
        Assert.assertTrue(dynamicControlsPage.loadingMessage.isDisplayed());
        Assert.assertEquals(dynamicControlsPage.loadingMessage.getText(), "Wait for it...");

        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingMessage));
        
        Assert.assertFalse(dynamicControlsPage.input_enable_button.isEnabled());
        ReusableMethods.waitForVisibility(dynamicControlsPage.generalMessage, 5);
        Assert.assertEquals(dynamicControlsPage.generalMessage.getText(), "It's disabled!");
        Assert.assertEquals(dynamicControlsPage.enable_disable_button.getText(), "Enable");


    }
    
}
