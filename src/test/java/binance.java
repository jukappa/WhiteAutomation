import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class binance extends BaseTest {


    @Test
    public void checkBinanceRegistration() throws AWTException {
        ExtentManager.createTest("binance", "registration");
        String URL = "https://www.binance.com/register.html";

        WebDriver driver = PreTest.getBrowserDrivers("Chrome");
        driver.manage().window().maximize();
        driver.get(URL);

        String hiddenXpath = "//span[text() = 'Register']";

        int secondsToVerify = 1;

        int x = 0;
        while (x < 1) {
            Common.sleep(1000);
            int i = 0;
            boolean flag = false;
            try {
                while (i < secondsToVerify * 4) {
                    boolean element = driver.findElement(By.xpath(hiddenXpath)).isDisplayed();
                    if (element) {
                        Common.sleep(250);
                        flag = TRUE;
                        i++;
                    } else {
                        Common.sleep(250);
                        i++;
                    }

                }
            } catch (Exception e) {
                flag = FALSE;

            }
            if (!flag) {
                driver.navigate().refresh();
            } else {
                x = 1;
            }
        }
        String email = "c-julian.lobert@charter.com";
        String pass = "Testing01";
        driver.navigate().to("https://www.facebook.com");
        FindElement.waitForElementXpath(driver, "//input[@type = 'email']", "email field").click();
        FindElement.waitForElementXpath(driver, "//input[@type = 'email']", "email field").sendKeys(email);
        FindElement.waitForElementXpath(driver, "//input[@type = 'password']", "email field").click();
        FindElement.waitForElementXpath(driver, "//input[@type = 'password']", "password field").sendKeys(pass);
        FindElement.waitForElementXpath(driver, "//input[@value = 'Log In']", "login field").click();
        Common.sleep(1000);
        Robot rob = new Robot();
        rob.keyPress((KeyEvent.VK_ESCAPE));
        rob.keyRelease((KeyEvent.VK_ESCAPE));
        FindElement.waitForElementXpath(driver, "//a[contains(@href, 'facebook.com/messages')]//div[contains(text(), 'Jake Crowley')]", "login field").click();
        Common.sleep(1000);
        WebElement element = FindElement.waitForElementXpath(driver, "(//div[@role = 'presentation'])[4]", "login field");
        element.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys("Binance registration is open ya queer.  https://www.binance.com/register.html");
        actions.build().perform();
/*        FindElement.waitForElementXpath(driver,"(//div[@role = 'presentation'])[4]","login field").sendKeys("Yo dawg, Binance registration is available");
        FindElement.waitForElementXpath(driver,"//a[contains(@href, 'facebook.com/messages')]//div[contains(text(), 'Julian Lobert')]","login field").click();*/
        rob.keyPress((KeyEvent.VK_ENTER));
        rob.keyRelease((KeyEvent.VK_ENTER));
        //FindElement.waitForElementXpath(driver,"//a[contains(@href, 'facebook.com/messages')]//div[contains(text(), 'Julian Lobert')]","login field").sendKeys(Keys.RETURN);

    }

    @Test
    public void getCryptoProfits() throws AWTException {
        ExtentManager.createTest("binance", "registration");
        String baseURL = "https://coinmarketcap.com/currencies/";
        String[] coin = {"ripple", "cardano", "stellar", "verge", "binance-coin", "ark"};
        ArrayList<Integer> arraylist = new ArrayList<Integer>();

        WebDriver driver = PreTest.getBrowserDrivers("Chrome");
        driver.manage().window().maximize();

        BigDecimal rippleBuyPrice = BigDecimal.valueOf(.58);
        BigDecimal cardanoBuyPrice = BigDecimal.valueOf(.83);
        BigDecimal stellarBuyPrice = BigDecimal.valueOf(.65);
        BigDecimal vergeBuyPrice = BigDecimal.valueOf(.19);
        BigDecimal binanceBuyPrice = BigDecimal.valueOf(25);
        BigDecimal arkBuyPrice = BigDecimal.valueOf(8.85);

        BigDecimal rippleAmount = BigDecimal.valueOf(1727);
        BigDecimal cardanoAmount = BigDecimal.valueOf(120);
        BigDecimal stellarAmount = BigDecimal.valueOf(154);
        BigDecimal vergeAmount = BigDecimal.valueOf(535);
        BigDecimal binanceAmount = BigDecimal.valueOf(4);
        BigDecimal arkAmount = BigDecimal.valueOf(11.3);

        BigDecimal totalrippleCost = rippleAmount.multiply(rippleBuyPrice);
        BigDecimal totalCardanoCost = cardanoAmount.multiply(cardanoBuyPrice);
        BigDecimal totalStellarCost = stellarAmount.multiply(stellarBuyPrice);
        BigDecimal totalVergeCost = vergeAmount.multiply(vergeBuyPrice);
        BigDecimal totalBinanceCost = binanceAmount.multiply(binanceBuyPrice);
        BigDecimal totalArkCost = arkAmount.multiply(arkBuyPrice);

        driver.get(baseURL + "/ripple");
        String currentRipplePrice = FindElement.waitForElementXpath(driver, "//span[@id = 'quote_price']/span[1]", "ripple current price").getText();
        String rawRippleValue = currentRipplePrice.replace("$", "");
        BigDecimal bigRippleValue = new BigDecimal(rawRippleValue);
        BigDecimal currentRippleTotal = rippleAmount.multiply(bigRippleValue);
        BigDecimal rippleProfit = currentRippleTotal.subtract(totalrippleCost);

        driver.get(baseURL + "/cardano");
        String currentCardanoPrice = FindElement.waitForElementXpath(driver, "//span[@id = 'quote_price']/span[1]", "ripple current price").getText();
        String rawCardanoValue = currentCardanoPrice.replace("$", "");
        BigDecimal bigCardanoValue = new BigDecimal(rawCardanoValue);
        BigDecimal currentCardanoTotal = cardanoAmount.multiply(bigCardanoValue);
        BigDecimal cardanoProfit = currentCardanoTotal.subtract(totalCardanoCost);

        driver.get(baseURL + "/Stellar");
        String currentStellarPrice = FindElement.waitForElementXpath(driver, "//span[@id = 'quote_price']/span[1]", "ripple current price").getText();
        String rawStellarValue = currentStellarPrice.replace("$", "");
        BigDecimal bigStellarValue = new BigDecimal(rawStellarValue);
        BigDecimal currentStellarTotal = stellarAmount.multiply(bigStellarValue);
        BigDecimal stellarProfit = currentStellarTotal.subtract(totalStellarCost);

        driver.get(baseURL + "/Verge");
        String currentVergePrice = FindElement.waitForElementXpath(driver, "//span[@id = 'quote_price']/span[1]", "ripple current price").getText();
        String rawVergeValue = currentVergePrice.replace("$", "");
        BigDecimal bigVergeValue = new BigDecimal(rawVergeValue);
        BigDecimal currentVergeTotal = vergeAmount.multiply(bigVergeValue);
        BigDecimal vergeProfit = currentVergeTotal.subtract(totalVergeCost);

        driver.get(baseURL + "/binance-coin");
        String currentBinancePrice = FindElement.waitForElementXpath(driver, "//span[@id = 'quote_price']/span[1]", "ripple current price").getText();
        String rawBinanceValue = currentBinancePrice.replace("$", "");
        BigDecimal bigBinanceValue = new BigDecimal(rawBinanceValue);
        BigDecimal currentBinanceTotal = binanceAmount.multiply(bigBinanceValue);
        BigDecimal binanceProfit = currentBinanceTotal.subtract(totalBinanceCost);

        driver.get(baseURL + "/Ark");
        String currentArkPrice = FindElement.waitForElementXpath(driver, "//span[@id = 'quote_price']/span[1]", "ripple current price").getText();
        String rawArkValue = currentArkPrice.replace("$", "");
        BigDecimal bigArkValue = new BigDecimal(rawArkValue);
        BigDecimal currentArkTotal = arkAmount.multiply(bigArkValue);
        BigDecimal arkProfit = currentArkTotal.subtract(totalArkCost);

        BigDecimal totalProfit = rippleProfit.add(cardanoProfit).add(stellarProfit).add(vergeProfit).add(binanceProfit).add(arkProfit);


        String email = "c-julian.lobert@charter.com";
        String pass = "Testing01";
        driver.navigate().to("https://www.facebook.com");
        FindElement.waitForElementXpath(driver, "//input[@type = 'email']", "email field").click();
        FindElement.waitForElementXpath(driver, "//input[@type = 'email']", "email field").sendKeys(email);
        FindElement.waitForElementXpath(driver, "//input[@type = 'password']", "email field").click();
        FindElement.waitForElementXpath(driver, "//input[@type = 'password']", "password field").sendKeys(pass);
        FindElement.waitForElementXpath(driver, "//input[@value = 'Log In']", "login field").click();
        Common.sleep(1000);
        Robot rob = new Robot();
        rob.keyPress((KeyEvent.VK_ESCAPE));
        rob.keyRelease((KeyEvent.VK_ESCAPE));
        FindElement.waitForElementXpath(driver, "//a[contains(@href, 'facebook.com/messages')]//div[contains(text(), 'Julian Lobert')]", "login field").click();
        Common.sleep(1000);
        WebElement element = FindElement.waitForElementXpath(driver, "(//div[@role = 'presentation'])[4]", "login field");
        element.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys("Ripple Current profit = "+rippleProfit+"\n");
        actions.build().perform();
        Common.sleep(1000);
        actions.sendKeys("Cardano Current profit = "+cardanoProfit+"\n");
        actions.build().perform();
        actions.sendKeys("Stellar Current profit = "+stellarProfit+"\n");
        actions.build().perform();
        actions.sendKeys("Verge Current profit = "+vergeProfit+"\n");
        actions.build().perform();
        actions.sendKeys("Binance coin Current profit = "+binanceProfit+"\n");
        actions.build().perform();
        actions.sendKeys("Ark Current profit = "+arkProfit+"\n");
        actions.build().perform();
        actions.sendKeys("Total Current profit = "+totalProfit+"\n");
        actions.build().perform();
/*        FindElement.waitForElementXpath(driver,"(//div[@role = 'presentation'])[4]","login field").sendKeys("Yo dawg, Binance registration is available");
        FindElement.waitForElementXpath(driver,"//a[contains(@href, 'facebook.com/messages')]//div[contains(text(), 'Julian Lobert')]","login field").click();*/
        rob.keyPress((KeyEvent.VK_ENTER));
        rob.keyRelease((KeyEvent.VK_ENTER));
        //FindElement.waitForElementXpath(driver,"//a[contains(@href, 'facebook.com/messages')]//div[contains(text(), 'Julian Lobert')]","login field").sendKeys(Keys.RETURN);

    }
}
