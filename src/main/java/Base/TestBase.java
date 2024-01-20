package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver = null;

    public static void openBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mhefela\\IdeaProjects\\automation_excersice\\src\\Browser\\chromedriver.exe");

        //create an object from chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

        //navigate to URL
        driver.get("https://automationexercise.com");
    }

    public static void closeBrowser()
    {
        driver.quit();
    }
}
//First Laptop----> C:\Users\mhefela\IdeaProjects\automation_excersice\src\Browser\chromedriver.exe
//Second Laptop----> C:\Users\yogy7\Documents\GitHub\Automation-Exercise-test\src\Browser\chromedriver.exe