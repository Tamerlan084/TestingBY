
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class EditMainInformation {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Documents\\GitHub\\drivers\\Chrome\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.training.by/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login("trainigby@bk.ru", "Astana2019");
  }

  private void login(String email, String password) {
    driver.get(baseUrl);
    driver.findElement(By.className("uui-button")).click();
    driver.findElement(By.id("Name")).click();
    driver.findElement(By.id("Name")).clear();
    driver.findElement(By.id("Name")).sendKeys(email);
    driver.findElement(By.id("Password")).click();
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys(password);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Войти'])[2]/following::button[2]")).click();
  }

  @Test
  public void testEditMainInformation() throws Exception {
    goToProfile();
    editProfile();
    editLastName("Kushukova");
    editFirstName("Madina");
    editNativeName("Economist");
    editMobileNumber("7029736270");
    submitionEditionProfile();
  }

  private void submitionEditionProfile() {
    driver.findElement(By.xpath("//div[@class='userProfile-buttons']/button")).click();
  }

  private void editMobileNumber(String number) {
    driver.findElement(By.name("mobilePhone")).clear();
    driver.findElement(By.name("mobilePhone")).sendKeys(number);
  }

  private void editNativeName(String nativeName) {
    driver.findElement(By.name("nativeName")).clear();
    driver.findElement(By.name("nativeName")).sendKeys(nativeName);
  }

  private void editFirstName(String firstName) {
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys(firstName);
  }

  private void editLastName(String lastName) {
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys(lastName);
  }

  private void editProfile() {
    driver.findElement(By.xpath("//a[contains(text(),'Редактировать')]")).click();
  }

  private void goToProfile() {
    driver.findElement(By.className("profile-name")).click();
    driver.findElement(By.linkText("Профиль")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
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
}
