package helper;

import base.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchHelper extends HelperBase {
    //Constructor
    public SearchHelper(WebDriver wd) {
        super(wd);
    }

    public void searchBy(String value) {
        input(By.xpath("//input[@id = 'lst-ib']"), value);
    }

    public void clickSearchButton() {
        click(By.xpath("//input[@name = 'btnK']"));
    }
}
