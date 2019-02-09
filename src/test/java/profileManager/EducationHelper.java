package profileManager;

import model.eduData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EducationHelper extends HelperBase{


    public EducationHelper(WebDriver driver) {
        super(driver);

    }

    public void educationInformation(eduData eduData) {
      editFacultet(eduData.getFacultet());
      editDpt(eduData.getDpt());
    }

    public void submitEducation() {
      click(By.xpath("//div[@education=\"education\"]//button[text()=\"Сохранить\"]"));
    }

    private void editDpt(String dpt) {
        type(dpt, By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Другая'])[2]/following::input[1]"));
    }

    private void editFacultet(String facultet) {
      type(facultet, By.xpath("//div[@education=\"education\"]//input[@name=\"customFaculty\"]"));
    }

    private void editOtherUniversity() {
      type("Nazarbaev University", By.xpath("//input[@name=\"customUniversity\"]"));
    }

    private void checkIfcheckbox() {
      if(!driver.findElement(By.xpath("//div[@education=\"education\"]//label[text()=\"Другое\"]")).isSelected()) {
        driver.findElement(By.xpath("//div[@education=\"education\"]//label[text()=\"Другое\"]")).click();
      }
    }

    public void editEducation() {
      click(By.xpath("//button[text()=\"Редактировать\"]"));
    }
}
