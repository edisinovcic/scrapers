import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.openqa.selenium.By.xpath;

public class StarterTest {

    public static FirefoxDriver driver;

    public static final String URL= "https://www.tvrtke.com/";
    public static final String preStartClick= "//img[contains(@id, 'imgHeader')]";
    public static final String extendSearch= "//div[contains(@onclick, 'AnvancedSearchToggle')]";
    public static final String selectCityExpand = "//select[contains(@title, 'Grad')]";
    public static final String selectCityZagreb = "//select[contains(@title, 'Grad')]/option[contains(@value, '10000')]";
    public static final String query = "//input[contains(@id, 'Djelatnost')]";
    public static final String queryText = "Web usluge - dizajn, hosting, programiranje";
    public static final String querySelect = "//li/div[contains(text(), 'Web')]";
    public static final String btn = "//input[contains(@id, 'btnSearchAdvanced')]";
    public static final String loadMore = "//input[contains(@id, 'btnLoadMoreResults')]";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","geckodriver");
        driver = new FirefoxDriver();
        openBrowser(URL);
        click(preStartClick);
        click(extendSearch);
        click(selectCityExpand);
        click(selectCityZagreb);
        setText(query, queryText);
        /*
        WebElement element = driver.findElement(By.xpath(querySelect));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        */
        //click(querySelect); //invalid selector
        click(btn);
        while(click(loadMore));
        driver.wait(5000);
        driver.quit();
    }

    public static boolean openBrowser(String URL){
        driver.get(URL);
        return true;
    }

    public static boolean click(String path){
        WebElement element = driver.findElement(xpath(path));
        while(!element.isDisplayed() || !element.isEnabled());
        driver.findElement(xpath(path)).click();
        return true;
    }

    public static boolean setText(String path, String text){
        WebElement element = driver.findElement(xpath(path));
        while(!element.isDisplayed() || !element.isEnabled());
        driver.findElement(xpath(path)).sendKeys(text);
        return true;
    }


}
