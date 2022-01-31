package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class dropdown {
    HomePage hp = new HomePage();
    @Test
    public void droganddrop(){
   // hp.clik_On_Subpages(10);
    hp.dropdowElement.click();
    System.out.println(hp.dropdown_options.size());
    Assert.assertEquals(hp.dropdown_options.size(), 3);


    Assert.assertNotEquals(hp.selected_option.getText(), "Option 1");
    hp.dropdown_options.get(1).click();
    Assert.assertEquals(hp.selected_option.getText(), "Option 1");
    
    hp.dropdown_options.get(2).click();
    Assert.assertEquals(hp.selected_option.getText(), "Option 2");



}
}
