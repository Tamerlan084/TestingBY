package profileManager;

import model.mainData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainInformationHelper extends HelperBase{



    public MainInformationHelper(WebDriver driver) {

        super(driver);
    }

    public void mainInformation(mainData mainData) {
        editLastName(mainData.getLastName());
        editFirstName(mainData.getFirstName());
        editNativeName(mainData.getNativeName());
        editMobileNumber(mainData.getNumber());
    }

    private void editMobileNumber(String number) {
        type(number,By.name("mobilePhone"));
    }

    private void editNativeName(String nativeName) {
        type(nativeName,By.name("nativeName"));

    }

    private void editFirstName(String firstName) {
        type(firstName, By.name("firstName"));
    }

    private void editLastName(String lastName) {
        type(lastName, By.name("lastName"));
    }
}
