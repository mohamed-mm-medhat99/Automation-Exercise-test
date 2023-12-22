package TestCases;

import Base.TestBase;
import Pages.AuthonticationPages;
import Pages.ContactUsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase {
    AuthonticationPages authPageObj;
    ContactUsPage contactUsPageObj;
    @BeforeMethod
    public void beforeMethod(){
        openBrowser();
        authPageObj = new AuthonticationPages(driver);
    }
    @Test
    public void contactUsFormTest(){
        String expectedGetInTouchTitle = "GET IN TOUCH";
        authPageObj.navigateToPage("Signup / Login");
        boolean flag = authPageObj.pageVisibility("contact_us");
        Assert.assertTrue(flag);
        String actualGetInTouchTitleText = contactUsPageObj.validateContactUsTitle();
        Assert.assertEquals(actualGetInTouchTitleText , expectedGetInTouchTitle);
    }
    @AfterMethod
    public void afterMethod(){
        closeBrowser();
    }
}
