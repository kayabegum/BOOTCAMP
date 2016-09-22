package common;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Level;

/**
 * Created by KayaBegum on 9/25/2016.
 */
public class Base {

    public WebDriver driver = null;

    //    public static Logger logger = LogManager.getLogger(Base.class);
    @Parameters({"useCloudEnv", "userName", "accessKey", "os", "browserName", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("rahmanww") String userName, @Optional("")
            String accessKey, @Optional("Windows 8") String os, @Optional("firefox") String browserName, @Optional("34")
                              String browserVersion, @Optional("http://www.cnn.com") String url) throws IOException {
        BasicConfigurator.configure();
        if (useCloudEnv == true) {
            //run in cloud
            getCloudDriver(userName, accessKey, os, browserName, browserVersion);
//            logger.setLevel(Level.INFO);
//            logger.info("Test is running on Saucelabs");
        } else {
            //run in local
            getLocalDriver(browserName);
//            logger.info("Test is running on Local");
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();

    }

    public WebDriver getLocalDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "Generic/browser-driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        return driver;

    }

    public WebDriver getCloudDriver(String userName, String accessKey, String os, String browserName,
                                    String browserVersion) throws IOException {
        {

            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("platform", os);
            cap.setBrowserName(browserName);
            cap.setCapability("version", browserVersion);
            driver = new RemoteWebDriver(new URL("http://" + userName + ":" + accessKey +
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
            return driver;
        }
    }


//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }

    //Click By Locator type
    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    public void clickById(String locator) {
        driver.findElement(By.id(locator)).click();
    }

    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void clickByLink(String locator) {
        driver.findElement(By.linkText(locator)).click();
    }

    public void clickByClass(String locator) {
        driver.findElement(By.className(locator)).click();
    }

    public void clickByName(String locator) {
        driver.findElement(By.name(locator)).click();
    }

    public void clickByTagName(String locator) {
        driver.findElement(By.tagName(locator)).click();
    }


    //Type By Locator
    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void typeByCssNEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void takeEnterKeys(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    public void clearInputField(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public List<WebElement> getListOfWebElementsById(String locator) {
        List<WebElement> list = driver.findElements(By.id(locator));
        return list;
    }

    public List<String> getTextFromWebElements(String locator) {
        List<WebElement> element = driver.findElements(By.cssSelector(locator));
        List<String> text = new ArrayList<String>();
        for (WebElement web : element) {
            text.add(web.getText());
        }
        return text;
    }

    public List<WebElement> getListOfWebElementsByCss(String locator) {
        List<WebElement> list = driver.findElements(By.cssSelector(locator));
        return list;
    }

    public List<WebElement> getListOfWebElementsByXpath(String locator) {
        List<WebElement> list = driver.findElements(By.xpath(locator));
        return list;
    }

    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public String getTextByCss(String locator) {
        String st = driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }

    public String getTextByXpath(String locator) {
        String st = driver.findElement(By.xpath(locator)).getText();
        return st;
    }

    public String getTextById(String locator) {
        return driver.findElement(By.id(locator)).getText();
    }

    public String getTextByName(String locator) {
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }

    public List<String> getListOfString(List<WebElement> list) {
        List<String> items = new ArrayList<String>();
        for (WebElement element : list) {
            items.add(element.getText());
        }
        return items;
    }

    public void selectOptionByVisibleText(String locator, String value) {
        Select select = new Select(driver.findElement(By.id(locator)));
        select.selectByVisibleText(value);
    }

    public void selectByValue(String locator, String value) {
        Select select = new Select(driver.findElement(By.id(locator)));
        select.selectByValue(value);
    }

    public void selectByIndex(String locator, int value) {
        Select select = new Select(driver.findElement(By.id(locator)));
        select.selectByIndex(value);
    }


    public void sleepFor(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    public void mouseHoverByCSS(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

        }

    }

    public void mouseHoverByXpath(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

        }

    }

    public void mouseHoverById(String locator) {
        try {
            WebElement element = driver.findElement(By.id(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.id(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

        }
    }

    //handling Alert
    public void okAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //iFrame Handle
    public void iframeHandle(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void goBackToHomeWindow() {
        driver.switchTo().defaultContent();
    }

    //get Links
    public void getLinks(String locator) {
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }

    //Taking Screen shots
    public void takeScreenShot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("screenShots.png"));
    }

    //Synchronization
    public void waitUntilClickAble(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilSelectable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    public void upLoadFile(String locator, String path) {
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
        /* path example to upload a file/image
           path= "C:\\Users\\rrt\\Pictures\\ds1.png";
         */
    }

    public void clearInput(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public void keysInput(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }


    //SCROLLING

    public void scrollPageDown400() {
        ((JavascriptExecutor) driver).executeScript("scroll(0, 400)");
    }

    public void scrollToElementById(String locator) {
        WebElement element = driver.findElement(By.id(locator));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void byLinks(String locator) {
        driver.findElement(By.linkText(locator)).click();
    }

    public void clicknhold(String locator) {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector(locator));
        action.clickAndHold(element).perform();
    }

    public void clickLinksThatAllHaveSimilarCss(String locator) throws InterruptedException {
        String[] links;
        int linksCount;
        List<String> ListUrl = new ArrayList<String>();
        List<WebElement> linkSize = driver.findElements(By.cssSelector(locator));
        linksCount = linkSize.size();
        links = new String[linksCount];
        for (int i = 0; i < linksCount; i++) {
            links[i] = linkSize.get(i).getAttribute("href");
            ListUrl.add(links[i]);
        }
        for (int i = 0; i < linksCount; i++) {
            driver.navigate().to(links[i]);
            sleepFor(1);
            driver.navigate().back();
        }
        System.out.println("Total no. of links available: " + linksCount);
        System.out.println("Links navigated to: " + ListUrl);
    }

    public void typeById(String locator, String value) {
        driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
    }

    public void handlePopup() {
        String parentHandle = driver.getWindowHandle();
        driver.switchTo().window(parentHandle);
    }

//    Alert alert = driver.switchTo().alert(); String Error_Message = alert.getText();
////Returns error message. System.out.println(Error_Message); alert l.accept(); //close ok button
//


    public void Varify(String locator, String expected) {
        String text = driver.findElement(By.cssSelector(locator)).getText();
        Assert.assertEquals(text, expected);
        if (text.equalsIgnoreCase(expected)) {
            System.out.println("test passed");
        } else {
            System.out.println("failed");
        }
    }

    public void Link(String expected) {
        String link = driver.getCurrentUrl();
        Assert.assertEquals(link, expected);
        if (link == expected) {
            System.out.println("test passed");
        } else {
            System.out.println("failed");
        }
    }

    //Taking Screen shots //still working on this method
//    public File sendScreenShot() throws IOException {
////        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
////        FileUtils.copyFile(file, new File("screenShots.png"));
//        Pn screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//        return screenshot;

//    }

    public void sendImage(String locator, String path){
        WebElement UploadImg = driver.findElement(By.xpath(locator));
        UploadImg.click();
        WebElement frame =driver.switchTo().activeElement();
        frame.sendKeys(path);
    }



}






