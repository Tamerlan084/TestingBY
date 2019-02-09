
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import trainig.profileInformation.eduData;
import trainig.profileInformation.mainData;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class EditMainInformation {

  protected WebDriver driver;
  protected boolean acceptNextAlert = true;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testEditMainInformation() throws Exception {
    goToProfile();
    editProfile();
    mainInformation(new mainData("Shambulova", "Aya", "Itishniik", "1024568936"));
    editEducation();
    //checkIfcheckbox();
   // editOtherUniversity();
    educationInformation(new eduData("ik", "computers"));
    submitEducation();
    submitionEditionProfile();

  }

  private void educationInformation(eduData eduData) {
    editFacultet(eduData.getFacultet());
    editDpt(eduData.getDpt());
  }

  private void mainInformation(mainData mainData) {
    editLastName(mainData.getLastName());
    editFirstName(mainData.getFirstName());
    editNativeName(mainData.getNativeName());
    editMobileNumber(mainData.getNumber());
  }

  private void submitEducation() {
    driver.findElement(By.xpath("//div[@education=\"education\"]//button[text()=\"Сохранить\"]")).click();
  }

  private void editDpt(String dpt) {
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Другая'])[2]/following::input[1]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Другая'])[2]/following::input[1]")).sendKeys(dpt);
  }

  private void editFacultet(String facultet) {
    driver.findElement(By.xpath("//div[@education=\"education\"]//input[@name=\"customFaculty\"]")).clear();
    driver.findElement(By.xpath("//div[@education=\"education\"]//input[@name=\"customFaculty\"]")).sendKeys(facultet);
  }

  private void editOtherUniversity() {
    driver.findElement(By.xpath("//input[@name=\"customUniversity\"]")).clear();
    driver.findElement(By.xpath("//input[@name=\"customUniversity\"]")).sendKeys("Nazarbaev University");
  }

  private void checkIfcheckbox() {
    if(!driver.findElement(By.xpath("//div[@education=\"education\"]//label[text()=\"Другое\"]")).isSelected()) {
      driver.findElement(By.xpath("//div[@education=\"education\"]//label[text()=\"Другое\"]")).click();
    }
  }

  private void editEducation() {
    driver.findElement(By.xpath("//button[text()=\"Редактировать\"]")).click();
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

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Documents\\GitHub\\drivers\\Chrom\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.training.by/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login("trainigby@bk.ru", "Astana2019");
  }

  private void login(String email, String password) {
    driver.get(baseUrl);
    driver.manage().window().maximize();
    driver.findElement(By.className("uui-button")).click();
    driver.findElement(By.id("Name")).click();
    driver.findElement(By.id("Name")).clear();
    driver.findElement(By.id("Name")).sendKeys(email);
    driver.findElement(By.id("Password")).click();
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys(password);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Войти'])[2]/following::button[2]")).click();
  }

  protected void submitionEditionProfile() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,-1000)");
    driver.findElement(By.xpath("//div[@class='userProfile-buttons']/button")).click();
  }

  protected void editProfile() {
    driver.findElement(By.xpath("//a[contains(text(),'Редактировать')]")).click();
  }

  protected void goToProfile() {
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
}
