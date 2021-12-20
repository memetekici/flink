package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MoisturizersAndSunscreensPage {

     public MoisturizersAndSunscreensPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
     @FindBy(xpath = "(//p)[1]")
     public WebElement product1Name;
     @FindBy(xpath = "(//p)[2]")
     public WebElement product1Price;
     @FindBy(xpath = "(//button)[2]")
     public WebElement product1AddButton;
     @FindBy(xpath = "(//p)[3]")
     public WebElement product2Name;
     @FindBy(xpath = "(//p)[4]")
     public WebElement product2Price;
     @FindBy(xpath = "(//button)[3]")
     public WebElement product2AddButton;
     @FindBy(xpath = "(//p)[5]")
     public WebElement product3Name;
     @FindBy(xpath = "(//p)[6]")
     public WebElement product3Price;
     @FindBy(xpath = "(//button)[4]")
     public WebElement product3AddButton;
     @FindBy(xpath = "(//p)[7]")
     public WebElement product4Name;
     @FindBy(xpath = "(//p)[8]")
     public WebElement product4Price;
     @FindBy(xpath = "(//button)[5]")
     public WebElement product4AddButton;
     @FindBy(xpath = "(//p)[9]")
     public WebElement product5Name;
     @FindBy(xpath = "(//p)[10]")
     public WebElement product5Price;
     @FindBy(xpath = "(//button)[6]")
     public WebElement product5AddButton;
     @FindBy(xpath = "(//p)[11]")
     public WebElement product6Name;
     @FindBy(xpath = "(//p)[12]")
     public WebElement product6Price;
     @FindBy(xpath = "(//button)[7]")
     public WebElement product6AddButton;
     @FindBy(xpath = "//button")
     public WebElement cartButton;


}
