package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.GoogleSearchPage;

public class GoogleSearchSteps {

    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        googleSearchPage = new GoogleSearchPage(driver);
    }

    @Given("the user is on the Google search page")
    public void the_user_is_on_the_google_search_page() {
        googleSearchPage.goTo();
    }
    @When("the user searches for {string}")
    public void the_user_searches_for(String searchTerm) {
        googleSearchPage.searchFor(searchTerm);

        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    @Then("the search results are displayed")
    public void the_search_results_are_displayed() {
        Assert.assertTrue(googleSearchPage.validateResultsAreDisplayed(), "No se enccontraron resultados de la busqueda");
    }

    @After
    public void TearDown(){
        driver.quit();
    }


}
