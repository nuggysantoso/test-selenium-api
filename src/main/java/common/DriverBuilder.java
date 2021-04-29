package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverBuilder {
    protected ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static String platform;

    public void setPlatform(String platform){
        this.platform = platform;
    }

    public static String getPlatform(){
        return platform;
    }

    public void setDriver() {
        if (getPlatform().equalsIgnoreCase("Web")){
            setWebDriver();
        }
    }

    public WebDriver getWebDriver(){
        return webDriver.get();
    }

    public void setWebDriver(){
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        webDriver.set(new ChromeDriver(options));
        webDriver.get().manage().window().maximize();
        webDriver.get().manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }
}
