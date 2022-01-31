package tests;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.US06_DisappearingElementsPage;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;
public class US06_DisappearingElementsTest {
    


    HomePage homePage = new HomePage();
   US06_DisappearingElementsPage  disappearingElements = new US06_DisappearingElementsPage();
   Actions actions=new Actions(Driver.getDriver());


   @BeforeTest
   public void setup() {

       Driver.getDriver().get(ConfigurationReader.getProperty("url"));
       ReusableMethods.waitForPageToLoad(10);
       ReusableMethods.waitFor(2);
       disappearingElements.disappearingElementsLink.click();
   }
    //* Disappearing Elements sayfasinda 5 tane menu basligi oldugunu dogrulayiniz
   @Test
   public void TC0601(){
      // int menuListSize=disappearingElements.disappearingElementsMenuList.size();
    
    
            for (int i = 0; i < 5; i++) {
                ReusableMethods.waitFor(2);
           if(disappearingElements.disappearingElementsMenuList.size()==5){
               Assert.assertTrue(disappearingElements.galleryElement.isDisplayed() );
           }else if(disappearingElements.disappearingElementsMenuList.size()==4){
            Assert.assertFalse(ReusableMethods.isExist(disappearingElements.galleryElement));
          // Assert.assertNull(disappearingElements.galleryElement.getText());
           }
           Driver.getDriver().navigate().refresh();
    
       }
       
             
    }


    

//*Home menusune tiklandiginda anasayfaya gidildigini dogrulayiniz
@Test
public void TC0602(){
     disappearingElements.disappearingElementsMenuList.get(0).click();
     System.out.println( disappearingElements.homePageTitle.getText());
     disappearingElements.homePageTitle.isDisplayed();
}

//*About, Contact Us,Portfolio menulere tiklandiginda "Not Found" mesajinin goruntulendigini dogrulayiniz
@Test
public void TC0603(){
  
    for (int i = 1; i < disappearingElements.disappearingElementsMenuList.size(); i++) {
        disappearingElements.disappearingElementsMenuList.get(i).click();
        Assert.assertEquals(disappearingElements.notFoundMessage.getText(),"Not Found");
        Driver.getDriver().navigate().back();
        Driver.getDriver().get("http://the-internet.herokuapp.com/disappearing_elements");
     }
  
  
}

//*Her bir menunun once kirmizi(#DA4B4B) renkte gorundugunu, mouse ile ustune gidildiginde
 //*siyah(#000) renge donustugunu dogrulayiniz
@Test
public void TC0604(){

  // ReusableMethods.waitForVisibility(disappearingElements.disappearingElementsMenuList.get(0), 10);
  for (WebElement w : disappearingElements.disappearingElementsMenuList) {
    
    ReusableMethods.waitFor(1);

     String colorBefore=w.getCssValue("color"); //rgba(34, 34, 34, 1)
     String hexBefore=Color.fromString(colorBefore).asHex(); //#DA4B4B
    
    
     Assert.assertEquals(hexBefore, "#da4b4b");

    actions.moveToElement(w).perform();
    
     String colorAfter=w.getCssValue("color");
     String hexAfter=Color.fromString(colorAfter).asHex();
     Assert.assertEquals(hexAfter, "#000000");
    
  }
   
}


}