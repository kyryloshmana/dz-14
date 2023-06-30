package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ButtonsPage;
import utils.MainPage;

public class ButtonsPageTest extends BAseTest {

    @Test
    public void checkTEstOnClickTestButton(){
        new MainPage(driver)
                .goToElementPAge();
        String getText =  new ButtonsPage(driver)
                .openButtonSection()
                .openClickMeSection()
                .getTextOnButtonPage();

        Assert.assertEquals(getText, "You have done a dynamic click");
        }
}
