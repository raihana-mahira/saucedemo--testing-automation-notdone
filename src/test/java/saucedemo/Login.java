package saucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    @Test
    public void success_login_case(){
        WebDriver driver;
        String baseUrl = "https://saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        //apply chrome driver setup
        //membuka halaman login
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String LoginLogo = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(LoginLogo, "Swag Labs");
        //input username
        driver.findElement(By.id("user-name")).sendKeys( "standard_user");

        //input pass
        driver.findElement(By.id("password")).sendKeys( "secret_sauce");
        //klik login
        driver.findElement(By.name("submit")).click();

        //Assert product di dashboard

        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

        driver.close();
    }

}
