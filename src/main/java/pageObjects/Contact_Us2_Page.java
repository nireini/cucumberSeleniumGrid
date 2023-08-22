package pageObjects;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class Contact_Us2_Page extends BasePage{


    public @FindBy(xpath = "//input[@name='first_name']") WebElement textfield_FirstName;
    public @FindBy(xpath = "//input[@name='last_name']") WebElement textfield_LastName;
    public @FindBy(xpath = "//input[@name='email']") WebElement textfield_EmailAddress;
    public @FindBy(xpath = "//textarea[@name='message']") WebElement textfield_Message;
    public @FindBy(xpath = "//input[@value='SUBMIT']") WebElement button_Submit;

    public Contact_Us2_Page() throws IOException {
        super();
    }


    public ContactUs_Page getContactUsPage2() throws IOException {
        getDriver().get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
        return new ContactUs_Page();
    }

    public ContactUs_Page enterFirstName(String firstName) throws Exception {
        sendKeysToWebElement(textfield_FirstName, firstName);
        return new ContactUs_Page();
    }

    public ContactUs_Page enterLasttName(DataTable dataTable, int row, int column) throws Exception {
        List<List<String>> data = dataTable.cells();
        sendKeysToWebElement(textfield_LastName, data.get(row).get(column));
        return new ContactUs_Page();
    }

    public ContactUs_Page enterEmailAddress(String emailAddress) throws Exception {
        sendKeysToWebElement(textfield_EmailAddress, emailAddress);
        return new ContactUs_Page();
    }

    public ContactUs_Page enterComments(DataTable dataTable, int row, int column) throws Exception {
        List<List<String>> data = dataTable.cells();
        sendKeysToWebElement(textfield_Message, data.get(row).get(column));
        return new ContactUs_Page();
    }

    public ContactUs_Page clickOnSubmiButton() throws Exception {
        //Assert.fail();
        waitAndClickElement(button_Submit);
        return new ContactUs_Page();
    }

    public ContactUs_Page confirmContactUsFormSubmissionWasSuccessful() throws Exception {
        WebElement thanksContactUsPage = getDriver().findElement(By.xpath(".//*[@id='contact_reply']/h1"));
        WaitUntilWebElementIsVisible(thanksContactUsPage);
        Assert.assertEquals("thankyouforyourmessage!", thanksContactUsPage.getText().toLowerCase().replaceAll("[ ()0-9]", ""));
        return new ContactUs_Page();
    }
}