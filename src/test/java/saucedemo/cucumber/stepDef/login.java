package saucedemo.cucumber.stepDef;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;



public class login {
    WebDriver driver;
    String baseUrl = "https://saucedemo.com/";
    @Given("Halaman login saucedemo")
    public void halaman_login_saucedemo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // set timeout for web driver on waiting element
        driver.get(baseUrl);

        //assertion
        String LoginLogo = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(LoginLogo, "Swag Labs");

    }

    @When("Input username")
    public void input_Username() {
        //input username
        driver.findElement(By.id("user-name")).sendKeys( "standard_user");
    }

    @And("Input Password")
    public void input_Password() {
        //input pass
        driver.findElement(By.id("password")).sendKeys( "secret_sauce");
    }

    @And("Click login button")
    public void click_LoginButton() {
        //klik login
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
    }

    @Then("User in products page")
    public void userInProductsPage() {
       driver.findElement(By.xpath("//div[@id='inventory_container']")).isDisplayed();

    }

    @And("Input invalid Password")
    public void inputInvalidPassword() {
        //input pass
        driver.findElement(By.id("password")).sendKeys( "secret__sauce");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
    }
}
