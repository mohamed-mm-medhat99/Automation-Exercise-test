package Pages;
import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthonticationPages extends PageBase {
    public  WebDriver driver;
    //locators
    //Buttons
    By signupButtonBy = By.xpath("//*[@data-qa='signup-button']");
    By createAccountButtonBy = By.cssSelector("[data-qa='create-account']");
    By continueButtonBy = By.cssSelector("[data-qa='continue-button']");
    By loginButtonBy = By.cssSelector("[data-qa='login-button']");
    By logoutButton = By.cssSelector("[href='/logout']");
    //TextFields
    By nameFieldBy = By.xpath("//*[@data-qa='signup-name']");
    By emailFieldBy = By.xpath("//*[@data-qa='signup-email']");
    By passwordFieldBy = By.cssSelector("#password");
    By firstNameFieldBy = By.xpath("//input[@id='first_name']");
    By lastNameFieldBy = By.xpath("//input[@id='last_name']");
    By addressFieldBy = By.xpath("//input[@id='address1']");
    By stateFieldBy = By.xpath("//input[@id='state']");
    By cityFieldBy = By.xpath("//input[@id='city']");
    By zipCodeFieldBy = By.xpath("//input[@id='zipcode']");
    By mobileNumberFieldBy = By.xpath("//input[@id='mobile_number']");
    By emailLoginFieldBy = By.cssSelector("[data-qa='login-email']");
    By passwordLoginFieldBy = By.cssSelector("[data-qa='login-password']");
    //CheckBoxes

    //Titles
    By accountInfoTitleBy = By.xpath("//*[text()='Enter Account Information']");
    By accountCreatedTitleBy = By.cssSelector("[data-qa='account-created']");
    By accountDeletedTitleBy = By.cssSelector("[data-qa='account-deleted']");
    By loginMessageTitleBy = By.cssSelector("div .login-form>h2");
    By loginUserNameTitleBy = By.xpath("//a[text()=' Logged in as ']/b");
    By invalidLoginErrorMsgTitleBy = By.cssSelector("[action='/login']>p");

    //Methods
        public AuthonticationPages(WebDriver driver)
        {
            this.driver = driver;
        }

        public void navigateToPage(String pageLocator)
        {
            pageNavigator(driver , pageLocator);
        }

        public Boolean pageVisibility(String pageName)
        {
            return verifyPageVisibility(driver ,pageName);
        }

        public void enterValidData(String email, String Name) throws InterruptedException {
            fillTextFields(driver ,nameFieldBy , Name);
            fillTextFields(driver ,emailFieldBy , email);
            clickOnButton(driver ,signupButtonBy);
            Thread.sleep(3000);
        }
        public String validateInfoTitle(){
            return validateTitles(driver , accountInfoTitleBy);
        }

        public String validateSignUpTitle(){
            return validateTitles(driver , accountCreatedTitleBy);
        }

        public String validateLoginTitle(){
            return validateTitles(driver , loginMessageTitleBy);
        }
        public String validateDeleteAccountTitle(){
            return validateTitles(driver , accountDeletedTitleBy);
        }

        public void selectGender(String genderIndex)
        {
            By genderCheckBoxBy = By.id("uniform-id_gender"+genderIndex+"");
            //start clicking on selected gender.
            driver.findElement(genderCheckBoxBy).click();
        }

        public void fillPassword(String text)
        {
            fillTextFields(driver ,passwordFieldBy ,text);
        }

        //days
        //months
        //years
        public void selectDateOfBirth(String menuCategory ,String value)
        {
            //By menuLocator = By.xpath("//*[@id='uniform-"+menuCategory+"']");
            WebElement menuLocator = driver.findElement(By.xpath("//*[@data-qa='"+menuCategory+"']"));
            selectFromList(menuLocator, value);
        }
        //optin
        //newsletter
        public void clickOnCheckBox(String Option)
        {
            By checkBoxesLocatorsBy = By.xpath("//input[@id='"+Option+"']");
            clickOnButton(driver ,checkBoxesLocatorsBy);
        }

        public void fillSignUpData(String Fname , String Lname , String address ,String State , String City , String ZipCode, String MobileNumber)
        {
            fillTextFields(driver , firstNameFieldBy , Fname);
            fillTextFields(driver , lastNameFieldBy , Lname);
            fillTextFields(driver , addressFieldBy , address);
            fillTextFields(driver , stateFieldBy , State);
            fillTextFields(driver , cityFieldBy , City);
            fillTextFields(driver , zipCodeFieldBy , ZipCode);
            fillTextFields(driver , mobileNumberFieldBy , MobileNumber);
        }

        public void ClickOnAccountButton() throws InterruptedException {
            Thread.sleep(2000);
            clickOnButton(driver , createAccountButtonBy);
        }
        public void ClickOnContinueButton()
        {
            clickOnButton(driver , continueButtonBy);
        }
        public void fillLoginData(String email , String Password){
            fillTextFields(driver , emailLoginFieldBy , email);
            fillTextFields(driver , passwordLoginFieldBy ,Password);
        }

        public void ClickOnLoginButton() throws InterruptedException {
            Thread.sleep(2000);
            clickOnButton(driver , loginButtonBy);
        }

        public String getLoggedUserText()
        {
            return getAnyText(driver , loginUserNameTitleBy);
        }

        public String getLoginErrorText()
        {
            return getAnyText(driver ,invalidLoginErrorMsgTitleBy);
        }

        public void ClickOnLogoutButton() throws InterruptedException {
            Thread.sleep(2000);
            clickOnButton(driver , logoutButton);
        }



}
