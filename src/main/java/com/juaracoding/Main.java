package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Main {

    static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com/my-account/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        System.out.println("Test Login");

        driver.findElement(By.className("home")).click();
        System.out.println("Tampilan Home");
//      js.executeScript("window.scrollBy(0,1000)");
        driver.get("https://shop.demoqa.com/product/pink-drop-shoulder-oversized-t-shirt/");
//      driver.findElement(By.cssSelector("a[href='https://shop.demoqa.com/product/pink-drop-shoulder-oversized-t-shirt/']")).click();
        System.out.println("Tampilan item to cart");
        Select colorSelect = new Select(driver.findElement(By.id("pa_color")));
        colorSelect.selectByValue("pink");
        Select sizeSelect = new Select(driver.findElement(By.id("pa_size")));
        sizeSelect.selectByValue("36");

        Actions actions = new Actions(driver);
        WebElement addCart = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
        actions.moveToElement(addCart).click().perform();
        System.out.println("tambahkan item ke cart");
        WebElement addCartAgain = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
        actions.moveToElement(addCartAgain).click().perform();
        System.out.println("tambahkan lagi item ke cart");
//      driver.findElement(By.cssSelector("button[type='submit']")).click();
//      driver.findElement(By.id("nav-menu-item-cart")).click();
        System.out.println("Tampilan Cart");
        driver.get("https://shop.demoqa.com/cart/");
        js.executeScript("window.scrollBy(0,500)");

        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }
}