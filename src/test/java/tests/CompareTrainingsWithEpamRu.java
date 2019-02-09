package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CompareTrainingsWithEpamRu extends BaseClass {

    @Test
    public void testCompare(){
        //profMen.getMainPgHlp().selectCity(By.xpath("//form[@action=\"/Home/UpdateTrainingFilter\"]//div[@class=\"js-locationFilter line-select-group\"]/div)"));
        profMen.getProfileHelper().goToProfile(By.linkText("Заявки"));
        profMen.getMainPgHlp().click(By.xpath("//div[@class=\"content\"]//a[@href=\"/Training\"]"));


    }

}
