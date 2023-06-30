package utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTables extends AbstractPageObject{
    private final By webTablesButton = By.xpath("//li[@id='item-3']/span[text()='Web Tables']//parent::li");
    private final By addButton = By.xpath("//button[@id='addNewRecordButton']");
    private final By firstNameField = By.xpath("//input[@id='firstName']");
    private final By lastNameField = By.xpath("//input[@id='lastName']");
    private final By emailField = By.xpath("//input[@id='userEmail']");
    private final By ageField = By.xpath("//input[@id='age']");
    private final By salaryField = By.xpath("//input[@id='salary']");
    private final By departmentField = By.xpath("//input[@id='department']");
    private final By submitButton = By.xpath("//button[@id='submit']");
    private final By enteredData = By.xpath("//div[@class='rt-tr-group'][4]//div//div[position() <= 6]");
    private final By deleteButton = By.xpath("//span[@id='delete-record-4']");
    private final By editButton = By.xpath("//span[@id='edit-record-4']");
    public WebTables(WebDriver driver) {
        super(driver);
    }

    @Step
    public List<WebElement> getEnteredData(){
        return getElements(enteredData);
    }

    @Step
    public WebTables openWebTablesPage(){
        getElement(webTablesButton).click();
        return this;
    }

    @Step
    public WebTables openForm(){
        getElement(addButton).click();
        return this;
    }

    @Step
    public WebTables addPerson(String firstName, String lastName, String email, String age, String salary, String department){
        getElement(firstNameField).sendKeys(firstName);
        getElement(lastNameField).sendKeys(lastName);
        getElement(emailField).sendKeys(email);
        getElement(ageField).sendKeys(age);
        getElement(salaryField).sendKeys(salary);
        getElement(departmentField).sendKeys(department);
        return this;
    }

    @Step
    public WebTables submit(){
        getElement(submitButton).click();
        return this;
    }

    @Step
    public WebTables deletePerson(){
        getElement(deleteButton).click();
        return this;
    }

    @Step
    public WebTables edit(){
        getElement(editButton).click();
        return this;
    }

    @Step
    public WebTables clearForm(){
        getElement(firstNameField).clear();
        getElement(lastNameField).clear();
        getElement(emailField).clear();
        getElement(ageField).clear();
        getElement(salaryField).clear();
        getElement(departmentField).clear();
        return this;
    }

}
