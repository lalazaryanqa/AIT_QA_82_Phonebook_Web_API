package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.PropertiesReader;

import static utils.PropertiesReader.*;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        setDriver(driver);
        //driver.get("https://telranedu.web.app/home");
        //driver.get(getProperty("base.properties", "baseUrl"));
        driver.get(PropertiesReader.getProperty("base.properties", "baseUrl"));
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy(xpath = "//a[text()='LOGIN']")
    WebElement btnLogin;
    @FindBy(xpath = "//input[@name='email']")
    WebElement inputEmail;

    public void clickBtnLogin(){
        btnLogin.click();
    }

    public void method(){
        WebElement login = driver.findElement(By
                .xpath("//a[text()='LOGIN']"));
        //login.click();
        WebElement inputEmail = driver.findElement(By
                .xpath("//input[@name='email']"));
        login.click();
        inputEmail.sendKeys("rtyfug@hju.cr");
    }

    public void ajaxMethod(){
        btnLogin.click();
        inputEmail.sendKeys("etryfg@adse.vbn");
    }
}