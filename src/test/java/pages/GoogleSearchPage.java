package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchPage {

    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(css = "div.g")
    private List<WebElement> searchResults;

    public GoogleSearchPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        driver.get("https://www.google.com/?hl=es");
    }

    public void searchFor (String searchFor){
        searchBox.sendKeys(searchFor);
        searchBox.submit();
    }

    public boolean validateResultsAreDisplayed (){
        return searchResults.size()>0;
    }



}
