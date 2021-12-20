package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CheckoutPage {

    public CheckoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//p)[1]")
    public WebElement totalPrice;
    @FindBy(xpath = "//span[@style = 'display: block; min-height: 30px;']")
    public WebElement payWithCardButton;
    @FindBy(id = "email")
    public WebElement emailButton;
    @FindBy(id = "card_number")
    public WebElement cardNummerButton;
    @FindBy(xpath = "(//input[@class='control'])[3]")
    public WebElement date;
    @FindBy(id = "cc-csc")
    public WebElement cvc;
    @FindBy(xpath = "//span[@class='iconTick']")
    public WebElement lastPayButton;
    @FindBy(id = "billing-zip")
    public WebElement zipCodeButton;
    @FindBy(xpath = "//p[@class='text-justify']")
    public WebElement successMessage;
}
