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
    public void aaa(){
setSlider(hp.slider, hp.slider_value, -60);

    }



public void aa(){
    int point = -60;
            
   // for (int i = 0; i < values.size(); i++) {
        
        action.dragAndDropBy(hp.slider,-60,0).perform();
        Assert.assertEquals(hp.slider_value.getText(), values.get(0));
        point = point+10;
        
        ReusableMethods.waitFor(2);
        action.dragAndDropBy(hp.slider,-45,0).perform();
        System.out.println(hp.slider_value.getText());
        Assert.assertEquals(hp.slider_value.getText(), values.get(1));
        
        ReusableMethods.waitFor(2);
        point = point+10;
        
        action.dragAndDropBy(hp.slider,-30,0).perform();
        System.out.println("sda" + hp.slider_value.getText());
        Assert.assertEquals(hp.slider_value.getText(), values.get(2));
        
        ReusableMethods.waitFor(2);
        point = point+10;
        
        action.dragAndDropBy(hp.slider,-20,0).perform();
        System.out.println("sdasa" + hp.slider_value.getText());
        Assert.assertEquals(hp.slider_value.getText(), values.get(3));
        
        ReusableMethods.waitFor(2);
        action.dragAndDropBy(hp.slider,-10,0).perform();
        System.out.println("sdasasdf" + hp.slider_value.getText());
        Assert.assertEquals(hp.slider_value.getText(), values.get(4));
        
        
        ReusableMethods.waitFor(2);
        action.dragAndDropBy(hp.slider,0,0).perform();
        System.out.println("sdasasdfdf" + hp.slider_value.getText());
        Assert.assertEquals(hp.slider_value.getText(), values.get(5));
        
        
        ReusableMethods.waitFor(2);
        action.dragAndDropBy(hp.slider,10,0).perform();
        System.out.println("sdasasdfdfdfg" + hp.slider_value.getText());
        Assert.assertEquals(hp.slider_value.getText(), values.get(6));
        
        
        ReusableMethods.waitFor(2);
        action.dragAndDropBy(hp.slider,20,0).perform();
        System.out.println("sdasasdfdfdfgdfgh" + hp.slider_value.getText());
        Assert.assertEquals(hp.slider_value.getText(), values.get(7));
        
        
        ReusableMethods.waitFor(2);
        action.dragAndDropBy(hp.slider,40,0).perform();
        System.out.println("sdasasdfdfdfgdfghdf" + hp.slider_value.getText());
        Assert.assertEquals(hp.slider_value.getText(), values.get(8));
        
        
        
        
        System.out.println("sdasasdfdfdfgdfghdf" + hp.slider_value.getText());

        ReusableMethods.waitFor(2);
    //}
}

public static void setSlider(WebElement slider, WebElement output, int target) {
    Actions actions = new Actions(Driver.getDriver());
    ReusableMethods.waitFor(1);

    actions.clickAndHold(slider).perform();

    while (true) {
        int value = Integer.parseInt(output.getAttribute("value"));  //25

        if (value == target) break;

        if (value > target) {
            actions.sendKeys(Keys.ARROW_LEFT).perform();
            //System.out.println("value_left = " + value);
        } else {
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
            // System.out.println("value_right = " + value);
        }}
    }

   // ReusableMethods.setSlider(sliderPage.sliderButton,sliderPage.sliderValue,10);
    @Test
    public void mouseMove()  {
        
        // mouse saga giderken
        // for (int i = 0; i < values.size(); i++) {
           
       ReusableMethods.waitFor(20);
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
