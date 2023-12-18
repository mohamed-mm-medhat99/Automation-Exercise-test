package Pages;
import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthonticationPages extends PageBase {
    public  WebDriver driver;
    //locators
    By nameFieldBy = By.xpath("//*[@data-qa='signup-name']");
    By emailFieldBy = By.xpath("//*[@data-qa='signup-email']");
    By signupButtonBy = By.xpath("//*[@data-qa='signup-button']");
    By accountInfoTitleBy = By.xpath("//*[text()='Enter Account Information']");
    By passwordFieldBy = By.cssSelector("#password");
    By firstNameFieldBy = By.xpath("//input[@id='first_name']");
    By lastNameFieldBy = By.xpath("//input[@id='last_name']");
    By addressBy = By.xpath("//input[@id='address1']");
    By stateFieldBy = By.xpath("//input[@id='state']");
    By cityFieldBy = By.xpath("//input[@id='city']");
    By zipCodeFieldBy = By.xpath("//input[@id='zipcode']");
    By mobileNumberFieldBy = By.xpath("//input[@id='mobile_number']");
    By createAccountBtn = By.cssSelector("[data-qa='create-account']");
    By accountCreatedTitleBy = By.cssSelector("[data-qa='account-created']");
    By continueButtonBy = By.cssSelector("[data-qa='continue-button']");
    By accountDeletedTitleBy = By.cssSelector("[data-qa='account-deleted']");
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
            fillTextFields(driver , addressBy , address);
            fillTextFields(driver , stateFieldBy , State);
            fillTextFields(driver , cityFieldBy , City);
            fillTextFields(driver , zipCodeFieldBy , ZipCode);
            fillTextFields(driver , mobileNumberFieldBy , MobileNumber);
        }

        public void ClickOnAccountButton() throws InterruptedException {
            Thread.sleep(2000);
            clickOnButton(driver , createAccountBtn);
        }
        public void ClickOnContinueButton()
        {
            clickOnButton(driver , continueButtonBy);
        }

}
