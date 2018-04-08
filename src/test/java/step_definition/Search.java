package step_definition;

import base.CucumberBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.SearchData;
import static org.testng.Assert.*;

public class Search {
    private CucumberBase base;
    private String searchQuery;

    //PicoContainer DI
    public Search(CucumberBase base) {
        this.base = base;
    }

    @Given("^I open google search$")
    public void openGoogle() {
        base.app.navigate().open("https://www.google.by/");
    }

    @When("^I enter search query:$")
    public void inputSearchQuery(DataTable table) {
        searchQuery = table.asList(SearchData.class).get(0).getQuery();
        base.app.search().searchBy(searchQuery);
    }

    @And("^I click the search button$")
    public void clickSearchButton() {
        base.app.search().clickSearchButton();
    }

    @Then("^I check that search is performed$")
    public void verifySearchResult() {
        assertTrue(base.app.search().getUrl().contains(searchQuery));
    }
}
