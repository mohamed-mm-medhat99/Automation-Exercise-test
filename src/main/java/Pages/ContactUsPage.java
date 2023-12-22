package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends PageBase {
    public WebDriver driver;
    //Locators
    //Titles
    By getInTouchTitleBy = By.cssSelector("div .contact-form>h2");

    //Methods
    public String validateContactUsTitle(){
        return validateTitles(driver , getInTouchTitleBy);
    }

}
