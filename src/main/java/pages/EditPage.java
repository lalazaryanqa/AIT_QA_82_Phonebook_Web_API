package pages;

import dto.Contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class EditPage extends BasePage {

    public EditPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//*[@placeholder='Name']")
    WebElement inputName;

    @FindBy(xpath = "//*[@placeholder='Last Name']")
    WebElement inputLastName;

    @FindBy(xpath = "//*[@placeholder='Phone']")
    WebElement inputPhone;

    @FindBy(xpath = "//*[@placeholder='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//*[@placeholder='Address']")
    WebElement inputAddress;



    public void typeEditContactForm(Contact contact) {
        inputName.clear();
        inputName.sendKeys(contact.getName());

        inputLastName.clear();
        inputLastName.sendKeys(contact.getLastName());

        inputPhone.clear();
        inputPhone.sendKeys(contact.getPhone());

        inputEmail.clear();
        inputEmail.sendKeys(contact.getEmail());

        inputAddress.clear();
        inputAddress.sendKeys(contact.getAddress());


    }

    public String getNameValue() {
        return inputName.getAttribute("value");
    }

    public String getPhoneValue() {
        return inputPhone.getAttribute("value");
    }

    public String getEmailValue() {
        return inputEmail.getAttribute("value");
    }
}