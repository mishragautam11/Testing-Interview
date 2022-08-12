import Pageobjects.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test_Case_04 {
    WebDriver driver;
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
        driver.get("https://demo.realworld.io/#/");


        Login login = new Login(driver);

        login.signinbtnclick();
        login.performsignin("gautam@gmail.com","test@1234");
        boolean myprofile = driver.findElement(By.xpath("//a[normalize-space()='gautam']")).isDisplayed();

        if (myprofile == true) {
            driver.findElement(By.xpath("//ul[@show-authed='true']//a[@class='nav-link active'][normalize-space()='Home']")).click();
        }

        driver.findElement(By.xpath("//a[normalize-space()='Global Feed']")).click();

        boolean favicon = driver.findElement(By.xpath("//span[normalize-space()='0']")).isSelected();
        boolean favicon1 = driver.findElement(By.xpath("//span[normalize-space()='1']")).isSelected();

        if (favicon==true){

            driver.findElement(By.xpath("//span[normalize-space()='0']")).click();
        } else if (favicon1==true){
            driver.findElement(By.xpath("//span[normalize-space()='1']")).click();
        }

            

        driver.findElement(By.xpath("//article-preview[1]//div[1]//a[1]//span[1]")).click();

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Write a comment...']")));

        driver.findElement(By.xpath("//textarea[@placeholder='Write a comment...']")).sendKeys("Test comment for automation");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");


        driver.findElement(By.xpath("//button[normalize-space()='Post Comment']")).click();
        Thread.sleep(2000);


        js.executeScript("window.scrollBy(0,250)", "");
       driver.findElement(By.xpath("//i[@ng-click='$ctrl.deleteCb()']")).isDisplayed();


       driver.findElement(By.xpath("//i[@ng-click='$ctrl.deleteCb()']")).click();


       driver.findElement(By.xpath("//a[@ui-sref='app.settings']")).click();

        js.executeScript("window.scrollBy(0,250)", "");

       driver.findElement(By.xpath("//button[normalize-space()='Or click here to logout.']")).click();

       driver.quit();
    }

}