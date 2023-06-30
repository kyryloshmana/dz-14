package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class AbstractPageObject {
    protected WebDriver driver;
    private final static int DURATION_TO_WAIT_DEFAULT = 4;
    public AbstractPageObject(WebDriver driver) {
    this.driver=driver;
    }

    public WebElement getElement(By by){
        return new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement getElement(By by, int wait){
        return new WebDriverWait(driver, Duration.ofSeconds(wait))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> getElements(By by){
        return new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public List<WebElement> getElements(By by, int wait){
        return new WebDriverWait(driver, Duration.ofSeconds(wait))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void clickOnElementWithJS(By by){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", getElement(by));
    }

    public void scrollPageByJS(int distance){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0, '%s');",  distance);
    }

    public void scrollPage(int distance){
        Actions action = new Actions(driver);
        action.moveByOffset(0, distance).perform();
    }

}
