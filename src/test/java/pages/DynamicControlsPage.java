package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class DynamicControlsPage {
    public DynamicControlsPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(css = "#checkbox>input")
    public WebElement checkbox;

    @FindBy(id = "message")
    public WebElement generalMessage;

    //It's enabled!
    //It's back!
    //It's gone!

    @FindBy(id = "loading")
    public WebElement loadingMessage;

    //Wait for it... 

    @FindBy(css = "#checkbox-example>button")
    public WebElement remove_add_button;

    @FindBy(css = "#input-example>button")
    public WebElement enable_disable_button;

    @FindBy(css = "#input-example>input")
    public WebElement input_enable_button;

    

    
}
