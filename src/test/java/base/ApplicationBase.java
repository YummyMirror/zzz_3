package base;

import helper.NavigationHelper;
import helper.SearchHelper;
import org.openqa.selenium.WebDriver;

public class ApplicationBase {
    protected NavigationHelper navigationHelper;
    protected SearchHelper searchHelper;

    protected void initDelegates(WebDriver wd) {
        navigationHelper = new NavigationHelper(wd);
        searchHelper = new SearchHelper(wd);
    }

    //Delegate getters
    public NavigationHelper navigate() {
        return navigationHelper;
    }

    public SearchHelper search() {
        return searchHelper;
    }
}
