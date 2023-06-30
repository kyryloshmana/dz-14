package utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPageObject {
        public final By elementPage = By.xpath("//div[@class=\"avatar mx-auto white\"][1]");

    public MainPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/");
    }
    @Step
    public void goToElementPAge(){
        getElement(elementPage).click();
    }


}
