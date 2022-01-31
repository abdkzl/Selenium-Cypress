package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US18_HoversPage {
    public US18_HoversPage() {
        PageFactory.initElements(utilities.Driver.getDriver(), this);
    }

    @FindBy(xpath = "//img[@src='/img/avatar-blank.jpg']")
    public List<WebElement> profilFotos;
    
    @FindBy(xpath = "//div[@class='figcaption']")
    public List<WebElement> profilText;

    @FindBy(xpath = "//*[.='View profile']")
    public List<WebElement> viewProfil;















    
}
