package tests;

import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class HorizontalSlider extends JFrame {
    HomePage hp = new HomePage();
    Actions action = new Actions(Driver.getDriver());
    List<String> values = Arrays.asList("0", "0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5");

  
    
    @Test
    public void title() {
        // System.out.println(hp.title.getText());
        Assert.assertEquals(hp.title.getText(), "Horizontal Slider");
    }

    @Test
    public void arrowKeys() {

        // mouse saga giderken
        for (int i = 0; i < values.size(); i++) {

            Assert.assertEquals(hp.slider_value.getText(), values.get(i));
            hp.slider.sendKeys(Keys.ARROW_RIGHT);
            ReusableMethods.waitFor(1);
        }
        ReusableMethods.waitFor(5);
        // mouse sola giderken
        for (int i = values.size() - 1; i > 0; i--) {
            Assert.assertEquals(hp.slider_value.getText(), values.get(i));
            hp.slider.sendKeys(Keys.ARROW_LEFT);
            ReusableMethods.waitFor(1);
        }

    }

    @Test
    public void mouseMove()  {

        // mouse saga giderken
        // for (int i = 0; i < values.size(); i++) {

       
/*

        JSlider aJSlider = new JSlider();
        System.out.println(aJSlider.getValue());
        int xRotatorOffset = 2;
        int yRotatorOffset = 0;
        WebElement textRotator = hp.slider;
        action.clickAndHold(textRotator)
                .moveByOffset(xRotatorOffset, yRotatorOffset)
                .release(textRotator)
                .build().perform();

        System.out.println(aJSlider.getValue());
        // Assert.assertEquals(hp.slider_value.getText(), values.get(i));
        // action.dragAndDropBy(hp.slider,0,0).perform();
        ReusableMethods.waitFor(1);
        // }
        ReusableMethods.waitFor(5);
        // mouse sola giderken
        /*
         * for (int i = values.size() - 1; i > 0; i--) {
         * action.dragAndDropBy(hp.slider, 1, 0).build().perform();
         * //Assert.assertEquals(hp.slider_value.getText(), values.get(i));
         * ReusableMethods.waitFor(1);
         * }
         */
    }

    

    @Test
    public void checkFileDownload() throws IOException, URISyntaxException {
 
        Dimension sliderSize = hp.slider.getSize();
        int sliderWidth = sliderSize.getWidth();
        int xCoord = hp.slider.getLocation().getX();

       System.out.println(sliderWidth + " : " + xCoord + " ;" + sliderSize);

        
           action.moveToElement(hp.slider)
           .click()
           .dragAndDropBy(hp.slider,xCoord+sliderWidth, 0)
           .build()
           .perform();
        

        int rangeValue = Integer.parseInt(
            hp.slider_value.getText());

            System.out.println(rangeValue);
           // ReusableMethods.waitFor(20);
       // Assert.assertEquals(rangeValue, 5);
    }


    @Test
    public void color() {
    }

    // rgba(16, 16, 16, 1)

    // System.out.println(hp.slider.getCssValue("color"));
    // ReusableMethods.waitFor(3);
    // action.moveToElement(hp.slider).clickAndHold()
    // .moveToElement(hp.slider, 0, 10) .build().perform();

    // ReusableMethods.waitFor(3);

    // System.out.println("s" + hp.slider.getCssValue("color"));

    @AfterMethod
    public void tear() {
        Driver.closeDriver();
    }

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get("http://the-internet.herokuapp.com/horizontal_slider");
        // hp.clik_On_Subpages(23);
        ReusableMethods.waitFor(2);
    }
}
