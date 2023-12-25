package MultipleWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium webdriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        WebElement clickElement = driver.findElement(By.xpath("//button[@id='windowButton']"));
        for(int i = 0; i < 3; i++){
            clickElement.click();
            Thread.sleep(3000);

        }

    }
}
