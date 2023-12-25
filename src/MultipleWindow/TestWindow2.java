package MultipleWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestWindow2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium webdriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Assuming you have a WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        String originalWindow = driver.getWindowHandle();
        //Cheack others window are not opened already
        assert driver.getWindowHandles().size() == 1;
        driver.findElement(By.id("windowButton")).click();
        Thread.sleep(2000);
//        wait.until(numberOfWindowsToBe(2));
        //loop until find the new window
        for(String windowHandle:driver.getWindowHandles()){
            if(!originalWindow.contentEquals(windowHandle)){
                driver.switchTo().window(windowHandle);
                if(driver.getTitle().contains("demoqa.com/sample")){
                    System.out.println(driver.getTitle());
                }
                break;
            }
        }
        //Wait for the new tab to finish loading content


    }
}
