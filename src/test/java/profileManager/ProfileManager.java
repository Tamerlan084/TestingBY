package profileManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ProfileManager {
    public SkillsHelper skillsHelper;
    private SessionHelper sessionHlp;
    public ProfileHelper profileHelper;
    public  EducationHelper eduHlp;
    public  MainInformationHelper mainInfHlp;
    public boolean acceptNextAlert = true;
    public WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

   

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Documents\\GitHub\\drivers\\Chrom\\chromedriver.exe");
        driver = new ChromeDriver();
        skillsHelper = new SkillsHelper(driver);
        sessionHlp = new SessionHelper(driver);
        profileHelper = new ProfileHelper(driver);
        mainInfHlp = new MainInformationHelper(driver);
        eduHlp = new  EducationHelper(driver);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        sessionHlp.login("trainigby@bk.ru", "Astana2019");
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
    public ProfileHelper getProfileHelper() {
        return profileHelper;
    }

    public EducationHelper getEduHlp() {
        return eduHlp;
    }

    public MainInformationHelper getMainInformationHelper() {
        return mainInfHlp;
    }

    public SkillsHelper getSkillsHelper() {
        return skillsHelper;
    }

}
