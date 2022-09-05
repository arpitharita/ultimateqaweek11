package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilitis.Utility;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.Function;

public class LoginTest extends Utility {

    String BaseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openbrowser(BaseUrl);
    }

    @Test
    public void VuserShouldNavigateToLoginPageSuccessfully() {

        //* click on the ‘Sign In’ link
        clickOnElement(By.linkText("Sign In"));

        //* Verify the text ‘Welcome Back!’
        String actualTest = getTextFromElement(By.xpath("//h1[@class='page__heading']"));
        String expectedTest = "Welcome Back!";
        Assert.assertEquals(expectedTest,actualTest);

    }
    @Test
    public void verifyTheErrorMessage(){

        //* click on the ‘Sign In’ link
        clickOnElement(By.linkText("Sign In"));

        //* Enter invalid username
        sendKeysToElement(By.xpath("//input[@id='user[email]']"),"abcd@gmail.com");

        //* Enter invalid password
        sendKeysToElement(By.xpath("//input[@id='user[password]']"),"1234hsp");

        //* Click on Login button
        clickOnElement(By.xpath("//input[@value='Sign in']"));

        //* Verify the error message ‘Invalid email or password.’
        String actualTest = getTextFromElement(By.xpath("//li[@class='form-error__list-item']"));
        String expectedTest = "Invalid email or password.";
        Assert.assertEquals(expectedTest,actualTest);

    }
}