import Pageobjects.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Case_03 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
        driver.get("https://demo.realworld.io/#/");

        Login login = new Login(driver);

        login.signinbtnclick();
        login.performsignin("gautam@gmail.com", "test@1234");

            driver.findElement(By.xpath("//a[normalize-space()='gautam']")).isDisplayed();

            driver.findElement(By.xpath("//a[@ui-sref='app.settings']")).click();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,250)", "");

            driver.findElement(By.xpath("//button[normalize-space()='Or click here to logout.']")).click();

            driver.quit();

        }

    }