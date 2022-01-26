package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class DragandDropPage {
    public DragandDropPage() {
        PageFactory.initElements(utilities.Driver.getDriver(), this);
    }

    @FindBy(css = "#column-a >header")
    public WebElement title_A;
    
    @FindBy(css = "#column-b >header")
    public WebElement title_B;

    @FindBy(css = "#column-b")
    public WebElement option_B;
    
    @FindBy(css = "#column-a")
    public WebElement option_A;
}
