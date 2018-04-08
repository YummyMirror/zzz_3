package application;

import base.ApplicationBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class Application extends ApplicationBase {
    private WebDriver wd;
    private WebDriverWait wait;
    private enum Browser {
        CHROME,
        FIREFOX,
        IE
    }

    public void init() throws MalformedURLException {
        wd = createDriver(Browser.CHROME);
        wait = new WebDriverWait(wd, 10);
        wd.manage().window().maximize();

        //Delegates
        initDelegates(wd);
    }

    public void stop() {
        if (wd != null)
            wd.quit();
    }

    private WebDriver createDriver(Browser browser) throws MalformedURLException {
        WebDriver wd = null;
        switch (browser) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                wd = new RemoteWebDriver(new URL("http://192.168.197.128:4444/wd/hub"), options);
                break;
            case FIREFOX:
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
                wd = new RemoteWebDriver(new URL("http://192.168.197.128:4444/wd/hub"), ffOptions);
                break;
            case IE:
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.ignoreZoomSettings();
                ieOptions.introduceFlakinessByIgnoringSecurityDomains();
                wd = new RemoteWebDriver(new URL("http://192.168.197.128:4444/wd/hub"), ieOptions);
                break;
        }
        return wd;
    }
}
