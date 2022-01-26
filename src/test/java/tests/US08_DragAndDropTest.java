package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.US08_DragAndDropPage;
import pages.HomePage;
//import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US08_DragAndDropTest {
    HomePage hp = new HomePage();
    US08_DragAndDropPage dp = new US08_DragAndDropPage();
    Actions action = new Actions(Driver.getDriver());

    @Test
    public void drogAndDrop() {
        hp.clik_On_Subpages(11);  //1.yol
        // Driver.getDriver().get(ConfigurationReader.getProperty("url"));   //2.yol
        // ReusableMethods.waitForPageToLoad(10);
        // dp.dragAndDropButton.click();

        ReusableMethods.waitFor(5);
        Assert.assertEquals(dp.columnA.getText(), "A");
        Assert.assertEquals(dp.columnB.getText(),"B");

        action.dragAndDrop(dp.columnA, dp.columnB).build().perform();
        
        ReusableMethods.waitFor(5);
        Assert.assertEquals(dp.columnA.getText(), "B");
        Assert.assertEquals(dp.columnB.getText(),"A");

    }
}
