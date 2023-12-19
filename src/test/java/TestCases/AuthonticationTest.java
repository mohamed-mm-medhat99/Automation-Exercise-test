package TestCases;

import Base.TestBase;
import Pages.AuthonticationPages;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthonticationTest extends TestBase {
    AuthonticationPages authPageObj;
    @BeforeMethod
    public void beforeMethod(){
        openBrowser();
        authPageObj = new AuthonticationPages(driver);
    }

    public int generateRandomNumber(int min, int max)
    {
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }
    //testcase1
    @Test
    public void registerUser() throws InterruptedException {
        String name = "mohamed"+generateRandomNumber(1,999)+"";
        String LastName = "Medhat"+generateRandomNumber(1,999)+"";
        String address = "Street"+generateRandomNumber(1,999)+" , Street"+generateRandomNumber(1,999)+"";
        String State = "Cairo";
        String City = "NasrCity";
        String ZipCode = "159657";
        String mobileNumber = "12658965415";
        String email = "mohamed"+generateRandomNumber(1,999)+"@gmail.com";
        System.out.println("Use Me to Login :"+email+"");
        String ExpectedTitle = "ENTER ACCOUNT INFORMATION";
        String expectedloginMessage = "ACCOUNT CREATED!";
        String expectedDeletedMessage = "ACCOUNT DELETED!";
        //step4 navigate to signup page
        authPageObj.navigateToPage("Signup / Login");
        //step5 validate that the target page is visible
        boolean flag = authPageObj.pageVisibility("login");
        Assert.assertTrue(flag);
        authPageObj.enterValidData(email,name);
        String infoTitleText = authPageObj.validateInfoTitle();
        Assert.assertEquals(infoTitleText ,ExpectedTitle);
        //step9 fill sign-up data
        authPageObj.selectGender("1");
        authPageObj.fillPassword("P@SsW0rd");
        authPageObj.selectDateOfBirth("days" , "1");
        authPageObj.selectDateOfBirth("months" , "October");
        authPageObj.selectDateOfBirth("years" , "1999");
        authPageObj.clickOnCheckBox("optin");
        authPageObj.fillSignUpData(name ,LastName ,address , State ,City , ZipCode , mobileNumber);
        authPageObj.ClickOnAccountButton();
        String signUpText = authPageObj.validateSignUpTitle();
        Assert.assertEquals(signUpText ,expectedloginMessage);
        authPageObj.ClickOnContinueButton();
        authPageObj.navigateToPage("Delete Account");
        String deleteAccountText = authPageObj.validateDeleteAccountTitle();
        Assert.assertEquals(deleteAccountText ,expectedDeletedMessage);
        authPageObj.ClickOnContinueButton();
    }
    //testcase2
    @Test
    public void validLogin() throws InterruptedException {
        String expectedLoginMessage = "Login to your account";
        String actualLoggedUserNameText = "mohamed917";
        authPageObj.navigateToPage("Signup / Login");
        String loginText = authPageObj.validateLoginTitle();
        Assert.assertEquals(loginText ,expectedLoginMessage);
        authPageObj.fillLoginData("mohamed256@gmail.com" , "P@SsW0rd");
        authPageObj.ClickOnLoginButton();
        String expectedLoggedUserNameText = authPageObj.getLoggedUserText();
        Assert.assertEquals(actualLoggedUserNameText ,expectedLoggedUserNameText);
    }
    //testcase3
    @Test
    public void invalidLogin() throws InterruptedException {
        String expectedLoginMessage = "Login to your account";
        String expectedLoginErrorMessage = "Your email or password is incorrect!";
        authPageObj.navigateToPage("Signup / Login");
        String loginText = authPageObj.validateLoginTitle();
        Assert.assertEquals(loginText ,expectedLoginMessage);
        authPageObj.fillLoginData("mohamed257@gmail.com" , "P@SsW0rd");
        authPageObj.ClickOnLoginButton();
        String expectedLoginErrorText = authPageObj.getLoginErrorText();
        Assert.assertEquals(expectedLoginErrorMessage ,expectedLoginErrorText);
    }
    //testcase4
    @Test
    public void logout() throws InterruptedException {
        String expectedLoginMessage = "Login to your account";
        String actualLoggedUserNameText = "mohamed917";
        String expectedLoginErrorMessage = "Your email or password is incorrect!";
        authPageObj.navigateToPage("Signup / Login");
        String loginText = authPageObj.validateLoginTitle();
        Assert.assertEquals(loginText ,expectedLoginMessage);
        authPageObj.fillLoginData("mohamed256@gmail.com" , "P@SsW0rd");
        authPageObj.ClickOnLoginButton();
        String expectedLoggedUserNameText = authPageObj.getLoggedUserText();
        Assert.assertEquals(actualLoggedUserNameText ,expectedLoggedUserNameText);
        authPageObj.ClickOnLogoutButton();
        boolean flag = authPageObj.pageVisibility("login");
        Assert.assertTrue(flag);
    }
    //testcase5
    @Test
    public void registerWithExistingEmail() throws InterruptedException {
        String email = "mohamed256@gmail.com";
        String name = "Mohamed Medhat";
        authPageObj.navigateToPage("Signup / Login");
        authPageObj.enterValidData(email,name);

    }


    @AfterMethod
    public void afterMethod()
    {
        closeBrowser();
    }
}
