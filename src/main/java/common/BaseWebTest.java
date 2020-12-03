package common;

import org.junit.After;
import org.junit.Before;
import platform.web.pages.EbayPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseWebTest extends DriverBuilder {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    @After()
    public void tearDown(){
        getWebDriver().quit();
    }

    @Before()
    public void setUp() {
        super.setPlatform("Web");
        super.setDriver();
        System.out.println("=========================================================");
        System.out.println("Date         : "+ dateFormat.format(date));
        System.out.println("Driver Name  : "+ Constants.DEFAULT_WEBDRIVER_NAME);
        System.out.println("=========================================================");
    }
}
