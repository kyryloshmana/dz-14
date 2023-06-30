package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.MainPage;
import utils.WebTables;

import java.util.List;

public class WebTablesTest extends BAseTest{
    private final static String firstName = "Kyrylo";
    private final static String lastName = "Shmana";
    private final static String email = "qweqwe@gmail.com";
    private final static String age = "1";
    private final static String salary = "1000";
    private final static String department = "AQA";
    @Test
    public void addPerson(){
        new MainPage(driver)
                .goToElementPAge();

       List<WebElement> enteredData =  new WebTables(driver)
                .openWebTablesPage()
                .openForm()
                .addPerson(firstName,lastName, email, age, salary, department)
                .submit()
                .getEnteredData();

        List<String> linkEnteredData = enteredData.stream().map(WebElement::getText).toList();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(linkEnteredData.get(0),firstName);
        softAssert.assertEquals(linkEnteredData.get(1),lastName);
        softAssert.assertEquals(linkEnteredData.get(2),age);
        softAssert.assertEquals(linkEnteredData.get(3),email);
        softAssert.assertEquals(linkEnteredData.get(4),salary);
        softAssert.assertEquals(linkEnteredData.get(5),department);
        softAssert.assertAll();
       }

       @Test
        public void deletePerson(){
        addPerson();
           List<WebElement> enteredData = new WebTables(driver)
                .deletePerson()
                .getEnteredData();
           List<String> linkEnteredData = enteredData.stream().map(WebElement::getText).toList();
           Assert.assertTrue(linkEnteredData.stream().allMatch(data -> data.trim().isEmpty()));
           System.out.println();
       }

       @Test
    public void editPerson(){
           addPerson();
           List<WebElement> linkEnteredData = new WebTables(driver)
                    .edit()
                    .addPerson("NEW","NEW","m","2","1","NEW")
                    .submit()
                    .getEnteredData();

           SoftAssert softAssert = new SoftAssert();
           softAssert.assertEquals(linkEnteredData.get(0),firstName + "NEW");
           softAssert.assertEquals(linkEnteredData.get(1),lastName + "NEW");
           softAssert.assertEquals(linkEnteredData.get(2), "12");
           softAssert.assertEquals(linkEnteredData.get(3),email + "m");
           softAssert.assertEquals(linkEnteredData.get(4),salary + "1");
           softAssert.assertEquals(linkEnteredData.get(5),department + "NEW");
           System.out.println();
    }
}
