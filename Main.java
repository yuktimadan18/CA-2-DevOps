package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/ADMIN/Desktop/SEM 6/DevOps/CA-2/index.html");

        // Test 1: Valid data
        driver.findElement(By.id("name")).sendKeys("Yukti");
        driver.findElement(By.id("email")).sendKeys("yukti@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("9876543210");
        driver.findElement(By.id("department")).sendKeys("Computer Science");
        driver.findElement(By.xpath("//input[@value='Male']")).click();
        driver.findElement(By.id("feedback")).sendKeys(
                "This system is very good and I really liked using it overall experience"
        );
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        // Test 2: Invalid email
        driver.navigate().refresh();
        driver.findElement(By.id("name")).sendKeys("Test");
        driver.findElement(By.id("email")).sendKeys("invalidemail");
        driver.findElement(By.id("mobile")).sendKeys("9876543210");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        // Test 3: Empty fields
        driver.navigate().refresh();
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        driver.quit();
    }
}