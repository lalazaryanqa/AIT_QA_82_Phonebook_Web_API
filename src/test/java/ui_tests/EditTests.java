package ui_tests;

import dto.Contact;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AddPage;
import pages.ContactsPage;
import pages.EditPage;
import pages.HomePage;
import pages.LoginPage;
import utils.TestNGListener;

import static utils.ContactFactory.positiveContact;
import static utils.PropertiesReader.getProperty;

@Listeners(TestNGListener.class)
public class EditTests extends AppManager {

    ContactsPage contactsPage;
    AddPage addPage;
    EditPage editPage;

    @BeforeMethod
    public void login() {
        User user = User.builder()
                .username(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();

        new HomePage(getDriver()).clickBtnLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationForm(user);
        loginPage.clickBtnLogin();

        contactsPage = new ContactsPage(getDriver());
        contactsPage.clickBtnAdd();
    }

    @Test
    public void editContactPositiveTest() {
        addPage = new AddPage(getDriver());

        Contact contact = positiveContact();
        addPage.typeAddNewContactForm(contact);
        addPage.clickBtnSave();

        contactsPage.scrollToLastContact();
        contactsPage.clickLastContact();
        contactsPage.clickBtnEdit();

        editPage = new EditPage(getDriver());

        Contact editedContact = positiveContact();
        editPage.typeEditContactForm(editedContact);

        Assert.assertEquals(editPage.getNameValue(), editedContact.getName());
        Assert.assertEquals(editPage.getPhoneValue(), editedContact.getPhone());
        Assert.assertEquals(editPage.getEmailValue(), editedContact.getEmail());
    }
}