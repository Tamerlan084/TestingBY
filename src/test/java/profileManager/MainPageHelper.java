package profileManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageHelper extends HelperBase{

    public MainPageHelper(WebDriver driver) {
        super(driver);
    }

    public void selectCity(By locator) {
        click(locator);
    }
}
