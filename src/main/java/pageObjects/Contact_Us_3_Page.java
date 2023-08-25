package pageObjects;

import java.io.IOException;

public class Contact_Us_3_Page extends BasePage{
    public Contact_Us_3_Page() throws IOException {
        super();
    }

    public Contact_Us_3_Page getContactUsPage_3() throws IOException {
        getDriver().get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
        return new Contact_Us_3_Page();
    }
}
