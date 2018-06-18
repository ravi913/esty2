import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertNotSame;

public class MyStepdefs extends BasePage {
    @cucumber.api.java.Before
    public void intialsteps(){
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }
    @cucumber.api.java.After
    public void closingsteps()
    {
        driver.quit();
    }
    private WebElement element;
    private By frameLocator = By.className("search-nav expanded-search apply-nav-height");
    private By tagText = By.id("gnav-search");

    @Given("^open url \"([^\"]*)\"$")
    public void openUrl(String arg0) throws Throwable {


        driver.get(arg0);
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div[2]/button")).click();


    }

    @And("^enter \"([^\"]*)\" in search bar$")
    public void enterInSearchBar(String arg0) throws Throwable {
       driver.findElement(By.id("search-query")).clear();
        driver.findElement(By.id("search-query")).sendKeys(arg0);


       // driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
        Thread.sleep(3000);

        List<WebElement> list=driver.findElements(By.xpath("//div[@id='search-suggestions']//ul//li/descendant::div[span[@class='normal']]"));

        System.out.println("total number of list"+list.size());
        for(int i=0;i<list.size();i++)
        {
        System.out.println(list.get(i).getText());

        if (list.get(i).getText().contains("sport shoes"))
        {
            list.get(i).click();
            break;
        }

        }
        String s= driver.findElement(By.xpath("//*[@id='content']/descendant::div//span[@class=' text-smaller']")).getText();
        System.out.println(s);
        assertNotSame("(0 Results)", s);
        }

    @When("^search is sorted by price Highest$")
    public void searchIsSortedByPriceHighest() throws Throwable {


         driver.findElement(By.xpath("//div[@class='text-smaller']")).click();
         driver.findElement(By.xpath("//a[@rel='nofollow'][contains(text(),'Highest Price')]")).click();
        }

    @Then("^print the prices of top (\\d+) items$")
    public void printThePricesOfTopItems(int arg0) throws Throwable {
        List<WebElement> list=driver.findElements(By.xpath("//*[@id='content']/descendant::div//p[@class='n-listing-card__price text-gray mt-xs-0 strong\n" + "                        ']//span[@class='currency-value']"));
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        System.out.println("total number of price list"  +list.size());
        for(int i=8;i<18;i++){
            System.out.println(list.get(i).getText());
        }

    }
}





