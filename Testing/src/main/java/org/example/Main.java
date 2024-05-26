package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driver;


    public static void main(String[] args) {
        System.out.println("Hello world!");
        setup();

    }
    public static void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mobilelive.ca/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[aria-label='Accept']")).click();
        WebElement careerHoverOver=driver.findElement(By.xpath("//a[@href='/careers'][normalize-space()='Careers']"));

        // Create Actions object
        Actions actions = new Actions(driver);

        // Move to the element
        actions.moveToElement(careerHoverOver).perform();

        // Further actions (if needed), for example, clicking on a sub-element
        WebElement subElement = driver.findElement(By.xpath("//a[normalize-space()='Open Positions']")); // Replace "xpath_of_the_sub_element" with the actual XPath
        subElement.click();
        driver.findElement(By.id("form-field-job-title")).sendKeys("Data");
        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("form-field-job-location")); // Replace "dropdown" with the ID of the dropdown element

        // Create Select object
        Select dropdown = new Select(dropdownElement);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Select by visible text
        dropdown.selectByVisibleText("Toronto");

        driver.findElement(By.id("searchJobBtn")).click();


        driver.findElement(By.xpath("//h2[normalize-space()='Data Scientist']")).click();
        System.out.println("DT");

       WebElement applyButton=driver.findElement(By.xpath("//div[@id='job16273566']//a[@class='button-underline-primary'][normalize-space()='Apply to this position']"));
        System.out.println("Apply Button");
        applyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement prefixElement = driver.findElement(By.id("prefix")); // Replace "dropdown" with the ID of the dropdown element

        // Create Select object
        Select prefixElementDropDown = new Select(prefixElement);
        // Select by visible text
        prefixElementDropDown.selectByVisibleText("Mr.");

        driver.findElement(By.id("firstName")).sendKeys("Muhammad");
        driver.findElement(By.id("lastName")).sendKeys("Khan");
        driver.findElement(By.id("middleName")).sendKeys("Zohaib");

        WebElement countryElement = driver.findElement(By.id("country")); // Replace "dropdown" with the ID of the dropdown element

        // Create Select object
        Select countryElementDropDown = new Select(countryElement);
        // Select by visible text
        countryElementDropDown.selectByVisibleText("Canada");

        driver.findElement(By.id("address")).sendKeys("1134");
        driver.findElement(By.id("addressCont")).sendKeys("Lahore");
        driver.findElement(By.id("city")).sendKeys("Lahore");
        driver.findElement(By.id("province")).sendKeys("Punjab");
        driver.findElement(By.id("postalCode")).sendKeys("54000");

        WebElement contactElement = driver.findElement(By.id("primaryContactMethod")); // Replace "dropdown" with the ID of the dropdown element

        // Create Select object
        Select contactElementDropDown = new Select(contactElement);
        // Select by visible text
        contactElementDropDown.selectByVisibleText("Email");

        driver.findElement(By.id("email")).sendKeys("khan@gmail.com");
        driver.findElement(By.id("primaryPhone")).sendKeys("12677");
        driver.findElement(By.id("secondaryPhone")).sendKeys("8776");

        WebElement referenceElement = driver.findElement(By.id("referance")); // Replace "dropdown" with the ID of the dropdown element

        // Create Select object
        Select referenceElementDropDown = new Select(referenceElement);
        // Select by visible text
        referenceElementDropDown.selectByVisibleText("LinkedIn");




        // Upload file
       /* WebElement fileInputElement = driver.findElement(By.xpath("//label[@for='resume']"));
        System.out.println("Upload Resume");
        String filePath =  "C:\\Users\\HP\\Desktop\\TestUpload\\ZK.txt"; // Replace "path/to/your/file.txt" with the actual file path
        fileInputElement.sendKeys(filePath);*/

        driver.findElement(By.id("applyJobBtn")).click();






    }
}