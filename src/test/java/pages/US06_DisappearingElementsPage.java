package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class US06_DisappearingElementsPage {
    
    public US06_DisappearingElementsPage() {
        PageFactory.initElements(utilities.Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[.='Disappearing Elements']")
    public WebElement disappearingElementsLink;


    @FindBy(xpath = "//ul/li/a")
    public List<WebElement> disappearingElementsMenuList;

    
    @FindBy(xpath = "//a[.='Gallery']")
    public WebElement galleryElement;

   


    @FindBy(xpath = "//h1")
    public WebElement homePageTitle;


    @FindBy(xpath = "//h1[.='Not Found']")
    public WebElement notFoundMessage;
}
