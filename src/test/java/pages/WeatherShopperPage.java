package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WeatherShopperPage {

    public WeatherShopperPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "temperature")
    public WebElement temperature;
    @FindBy(xpath = "(//button)[1]")
    public WebElement buyMoisturizersButton;
    @FindBy(xpath = "(//button)[2]")
    public WebElement buySunScreensButton;

}
