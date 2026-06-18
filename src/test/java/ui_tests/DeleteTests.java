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
import pages.HomePage;
import pages.LoginPage;
import utils.TestNGListener;


import static utils.ContactFactory.positiveContact;
import static utils.PropertiesReader.getProperty;

@Listeners(TestNGListener.class)
public class DeleteTests extends AppManager {

    ContactsPage contactsPage;
    AddPage addPage;
    int countOfContacts;

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
    public void deleteContactPositiveTest() {
        addPage = new AddPage(getDriver());

        Contact contact = positiveContact();

        addPage.typeAddNewContactForm(contact);
        addPage.clickBtnSave();
        countOfContacts = contactsPage.countOfContacts();

        contactsPage.scrollToLastContact();
        contactsPage.clickLastContact();

        contactsPage.pause(3000);

        contactsPage.clickBtnRemove();

        contactsPage.pause(3000);
        int countOfContactsAfterRemove = contactsPage
                .countOfContacts();
        Assert.assertEquals(countOfContactsAfterRemove,
                countOfContacts - 1);
    }
}