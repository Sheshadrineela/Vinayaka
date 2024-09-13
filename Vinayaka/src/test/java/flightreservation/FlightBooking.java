package flightreservation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FlightBooking {
    private WebDriver driver;
    private String url="https://demo.guru99.com/test/newtours/";
    public String actTitle;
    public String expTitle="Login: Mercury Tours";
    public String uName="userName";
    public String pwd="password";
    public String btn="submit";
    public String uNameVal="mercury";
    public String pwdVal="mercury";
    public String expHometitle="Welcome: Mercury Tours";

    @BeforeMethod
    public void browserSetup() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);
    }

    @Test
    public void login() {

        //driver.findElement(By.name("userName")).sendKeys("mercury");
        //driver.findElement(By.name("password")).sendKeys("mercury");
        //driver.findElement(By.name("submit")).click();
        driver.findElement(By.name(uName)).sendKeys(uNameVal);
        driver.findElement(By.name(pwd)).sendKeys(pwdVal);
        driver.findElement(By.name(btn)).click();
        actTitle=driver.getTitle();
        Assert.assertEquals(actTitle,expTitle);

    }

    @AfterMethod
    public void signoff()
    {
        driver.findElement(By.partialLinkText("SIGN-OFF")).click();
        Assert.assertEquals(driver.getTitle(),expHometitle);
    }
}
