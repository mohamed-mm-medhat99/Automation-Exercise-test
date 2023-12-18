package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
public class PageBase {



    public void pageNavigator(WebDriver driver ,String pageLocator)
    {
        By allPagesLocator = By.xpath("//a[text()=' "+pageLocator+"']");
        driver.findElement(allPagesLocator).click();

    }

    public boolean verifyPageVisibility(WebDriver driver ,String pageName)
    {
        String currentUrl = driver.getCurrentUrl();
        System.out.print("current page from URL is: " + currentUrl + " ");
        return currentUrl.contains(pageName);
    }

    public void fillTextFields(WebDriver driver, By locator , String data)
    {
        driver.findElement(locator).sendKeys(data);
    }

    public void clickOnButton(WebDriver driver, By locator)
    {
        driver.findElement(locator).click();
    }

    public void selectFromList(WebElement menuLocator, String valueToSelect)
    {
        Select menu = new Select(menuLocator);
        menu.selectByVisibleText(valueToSelect);
    }

    public String validateTitles(WebDriver driver , By textLocator)
    {
        return driver.findElement(textLocator).getText();
    }
}
