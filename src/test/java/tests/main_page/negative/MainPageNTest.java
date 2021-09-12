package tests.main_page.negative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.base.BaseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static constants.Constant.TimeoutVariables.IMPLICIT_WAIT;
import static constants.Constant.Urls.BASE_URL;

public class MainPageNTest extends BaseTest {

    @Test()
    public void sendEmptySearchInput(){
        basePage.goToUrl(BASE_URL);
        mainPage.clickSearchButton();
        basePage.waitElementIsVisible(driver.findElement(By.xpath("//h1[text()='Поиск аниме по названию']")));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        List<WebElement> items =  driver.findElements(By.xpath("//div[@class='items']"));
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        Assertions.assertTrue(items.isEmpty());
    }
}