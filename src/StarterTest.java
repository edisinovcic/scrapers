import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StarterTest {

    public static FirefoxDriver driver;

    public static final String URL= "https://www.tvrtke.com/";
    public static final String extendSearch= "//div[contains(@onclick, 'AnvancedSearchToggle')]/img";
    public static final String selectCityExpand = "//select[contains(@title, 'Grad')]";
    public static final String selectCityZagreb = "//select[contains(@title, 'Grad')]/option[contains(@value, '10000')]";
    public static final String query = "//input[contains(@id, 'Djelatnost')]";
    public static final String queryText = "Web usluge - dizajn, hosting, programiranje";
    public static final String btn = "//input[contains(@id, 'btnSearchAdvanced')]";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","geckodriver");
        driver = new FirefoxDriver();
        openBrowser(URL);
        click(extendSearch);
        click(selectCityExpand);
        click(selectCityZagreb);
        setText(query, queryText);
        click(btn);
        driver.wait(5000);
        driver.quit();
    }

    public static void openBrowser(String URL){
        driver.get(URL);
    }

    public static void click(String path){
        while(!driver.findElement(By.xpath(path)).isDisplayed());
        driver.findElement(By.xpath(path)).click();
    }

    public static void setText(String path, String text){
        while(!driver.findElement(By.xpath(path)).isDisplayed());
        driver.findElement(By.xpath(path)).sendKeys(text);
    }


}
