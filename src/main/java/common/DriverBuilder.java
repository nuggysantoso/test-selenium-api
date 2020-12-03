package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverBuilder {
    private static WebDriver webDriver = null;
    private static String platform;

    public void setPlatform(String platform){
        this.platform = platform;
    }

    public static String getPlatform(){
        return platform;
    }

    public static void setDriver() {
        if (getPlatform().equalsIgnoreCase("Web")){
            setWebDriver();
        }
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

    public static void setWebDriver(){
        switch (System.getProperty("os.name").toLowerCase()) {
            case "mac" : System.setProperty(Constants.DEFAULT_CHROME_PROPERTY, Constants.DEFAULT_PATH_CHROME_DRIVER_MAC);
            break;
            case "windows" : System.setProperty(Constants.DEFAULT_CHROME_PROPERTY, Constants.DEFAULT_PATH_CHROME_DRIVER_WINDOWS);
            break;
        }
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }
}
