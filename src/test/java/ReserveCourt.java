import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;

public class ReserveCourt extends BaseTest {

    @Test
    public void smokeTest() throws AWTException {

        String[] browsers = {"chrome"};

        //Account must have internet device
        String baseURL = "https://www.mylt.life/clubs/co/parker-aurora/";

        for (String browser : browsers) {
            WebDriver driver = PreTest.getBrowserDrivers(browser);
            driver.manage().window().maximize();
            driver.get(baseURL);
            driver.findElement(By.xpath("//li//span[@class ='js-login-label']")).click();
            driver.findElement(By.xpath("//a[@class = 'js-login-link btn btn-primary btn-sm btn-block']")).click();
            driver.findElement(By.xpath("//input[@id = 'account-username']")).sendKeys("kzs145");
            driver.findElement(By.xpath("//input[@id = 'account-password']")).sendKeys("Chemstar_1985");
            driver.findElement(By.xpath("//button[@id = 'login-btn']")).click();
            Common.sleep(3000);
            driver.findElement(By.xpath("//a[text() = 'Schedules']")).click();
            Common.sleep(1000);
            driver.findElement(By.xpath("(//li[contains(@class, 'nav-item  dropdown open')]//li)[5]")).click();
            Common.sleep(3000);
            driver.findElement(By.xpath("//input[@id = 'date-from']")).click();
            driver.findElement(By.xpath("//td[text() = '26']")).click();
            driver.findElement(By.xpath("(//select[@title = 'Facility'])[2]")).sendKeys("Squash");
            Common.sleep(3000);
            WebElement time = driver.findElement(By.xpath("(//time[text() = '4:00'])[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", time);
            Common.sleep(1000);
            driver.findElement(By.xpath("//a[contains(@ng-href, '18:00')]")).click();
            Common.sleep(3000);
            driver.findElement(By.xpath("//span[@class = 'c-indicator']"));
            //driver.findElement(By.xpath("//button[text() = 'Finish']"));





    }

}}

