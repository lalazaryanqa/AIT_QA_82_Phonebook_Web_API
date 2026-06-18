package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class BasePage {

    Logger logger = LoggerFactory.getLogger(BasePage.class);
    static WebDriver driver;

    public void setDriver(WebDriver wd) {
        driver = wd;
    }

    public boolean isTextInElementPresent(WebElement element, String text) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions
                            .textToBePresentInElement(element, text));
        } catch (RuntimeException e) {
            logger.error("create exception", e);
//            e.printStackTrace();
//            System.out.println("created exception");
        }
        return false;
    }

    public void pause(int time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickWait(WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (RuntimeException e) {
            logger.error("create exception", e);
        }
    }

    public boolean isURLContainsText(String text) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions
                            .urlContains(text));
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("created exception");
        }
        return false;
    }

    public boolean isElementNotClickable(WebElement element) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.not(ExpectedConditions
                            .elementToBeClickable(element)));
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("created exception");
        }
        return false;
    }

    public boolean isElementClickable(WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions
                            .elementToBeClickable(element));
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("created exception");
        }
        return false;
    }


    public String closeAlert() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        return text;
    }
}