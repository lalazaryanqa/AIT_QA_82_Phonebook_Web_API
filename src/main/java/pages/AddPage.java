package pages;

import dto.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AddPage extends BasePage {
    public AddPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
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
    @FindBy(xpath = "//*[@placeholder='description']")
    WebElement inputDescription;

    @FindBy(xpath = "//b[text()='Save']")
    WebElement btnSave;

    public void clickBtnSave() {
        pause(3000);
        btnSave.click();
    }


    public void typeAddNewContactForm(Contact contact) {
        inputName.sendKeys(contact.getName());
        inputLastName.sendKeys(contact.getLastName());
        inputPhone.sendKeys(contact.getPhone());
        inputEmail.sendKeys(contact.getEmail());
        inputAddress.sendKeys(contact.getAddress());
        inputDescription.sendKeys(contact.getDescription());
    }
    public void clearAddContactForm() {
        inputName.clear();
        inputLastName.clear();
        inputPhone.clear();
        inputEmail.clear();
        inputAddress.clear();
        inputDescription.clear();

    }


    public boolean isBtnSaveNotClickable(){
        return isElementNotClickable(btnSave);
    }
    public boolean isBtnSaveDisabled(){
        return btnSave.isDisplayed();
    }
    public boolean isBtnSaveClickable(){
        return isElementClickable(btnSave);
    }
}