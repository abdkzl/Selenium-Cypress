package pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US08_DragAndDropPage {

    public US08_DragAndDropPage() {
        PageFactory.initElements(utilities.Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Drag and Drop']")
    public WebElement dragAndDropButton;


    // @FindBy(xpath = "//h3")
    // public WebElement title;
    
    @FindBy(xpath = "//div[@id='column-a']")
    public WebElement columnA;

    @FindBy(xpath = "//div[@id='column-b']")
    public WebElement columnB;

    



}
