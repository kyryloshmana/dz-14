package utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonsPage extends AbstractPageObject {
    private final By buttonsButton = By.xpath("//li[@id='item-4']/span[text()='Buttons']//parent::li");
    private final By buttonsClickMe = By.xpath("//button[text()='Click Me']");
    private final By text = By.xpath("//p[@id=\"dynamicClickMessage\"]");
    public ButtonsPage(WebDriver driver) {
        super(driver);
      //  driver.get("https://demoqa.com/elements");
    }


    @Step
    public ButtonsPage openButtonSection(){
        //scrollPage(50);
        getElement(buttonsButton).click();
        //clickOnElementWithJS(buttonsButton);

        return this;
    }
    @Step
   public ButtonsPage openClickMeSection(){
        getElement(buttonsClickMe).click();
        return this;
    }

    @Step
    public String getTextOnButtonPage(){
        return getElement(text).getText();
        }
}
