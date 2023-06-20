import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "./chromedriver");

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        // Create a new ChromeDriver instance
        driver = new ChromeDriver(ops);
        File file = new File("/workspace/gitpoduser67-JS-CL-BUTTONCLICK/ButtonClicker.html");
        // Open the HTML file
        driver.get(file.getAbsolutePath());
    }
    @Test
    public void testButton1() {
        // check the initial state of the text:
        WebElement displayElement = driver.findElement(By.id("text1"));
        assertEquals("click the button ...", displayElement.getText());

        // Find button 1 and click it
        WebElement button1 = driver.findElement(By.id("button1"));
        button1.click();

        assertEquals("button 1 clicked", displayElement.getText());
    }

    @Test
    public void testButton2() {
        // check the initial state of the text:
        WebElement displayElement = driver.findElement(By.id("text2"));
        assertEquals("now click this button ...", displayElement.getText());

        // Find button 2 and click it
        WebElement button2 = driver.findElement(By.id("button2"));
        button2.click();

        assertEquals("button 2 clicked", displayElement.getText());
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
