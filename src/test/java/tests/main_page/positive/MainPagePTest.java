package tests.main_page.positive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.base.BaseTest;

import static constants.Constant.Urls.BASE_URL;

public class MainPagePTest extends BaseTest {

    @Test
    public void searchByNameTest(){
        basePage.goToUrl(BASE_URL);
        mainPage.EnterTheNameOfTheAnimeInTheSearchInput();
        mainPage.clickSearchButton();
        basePage.waitElementIsVisible(driver.findElement(By.xpath("//h1[text() = 'Поиск аниме по названию']")));
        String animeName = driver.findElement(By.xpath("//div[@class='items'][1]//div[@class='col s12'][1]//h2//a")).getText();
        Assertions.assertEquals("Врата Штейна", animeName);
    }

    @Test
    public void checkIsRedirectToCatalog(){
        basePage.goToUrl(BASE_URL);
        mainPage.clickToCatalogOfAllAnimeButton();
        basePage.waitElementIsVisible(driver.findElement(By.xpath("//h1[@class='m-page-title']"))).isDisplayed();
    }

    @Test
    public void checkRedirectToGenres(){
        basePage.goToUrl(BASE_URL);
        mainPage.clickSearchByGenreButton();
        basePage.waitElementIsVisible(driver.findElement(By.xpath("//h1[@class='m-page-title']"))).isDisplayed();
    }

    @Test
    public void checkRedirectToSearchPage(){
        basePage.goToUrl(BASE_URL);
        mainPage.clickSearchByNameButton();
        basePage.waitElementIsVisible(driver.findElement(By.xpath("//h1[text() ='Поиск аниме по названию']"))).isDisplayed();
    }

    @Test
    public void checkRedirectToAnimeWhenClickToAnimeImg(){
        basePage.goToUrl(BASE_URL);
        String ruAnimeName = mainPage.getFirstAnimeNameRu();
        String enAnimeName = mainPage.getFirstAnimeNameEn();
        mainPage.clickFirstAnimeImg();
        basePage.waitElementIsVisible(driver.findElement(By.xpath("//h2[@class='line-1']"))).isDisplayed();
        Assertions.assertEquals(ruAnimeName, mangaPage.getRuAnimeName());
        Assertions.assertEquals(enAnimeName, mangaPage.getEnAnimeName());
    }

    @Test
    public void checkRedirectToAnimeWhenClickToAnimeRuName(){
        basePage.goToUrl(BASE_URL);
        String ruAnimeName = mainPage.getFirstAnimeNameRu();
        String enAnimeName = mainPage.getFirstAnimeNameEn();
        mainPage.clickFirstAnimeRuNameButton();
        basePage.waitElementIsVisible(driver.findElement(By.xpath("//h2[@class='line-1']"))).isDisplayed();
        Assertions.assertEquals(ruAnimeName, mangaPage.getRuAnimeName());
        Assertions.assertEquals(enAnimeName, mangaPage.getEnAnimeName());
    }

    @Test
    public void checkRedirectToAnimeWhenClickToAnimeEnName(){
        basePage.goToUrl(BASE_URL);
        String ruAnimeName = mainPage.getFirstAnimeNameRu();
        String enAnimeName = mainPage.getFirstAnimeNameEn();
        mainPage.clickFirstAnimeEnNameButton();
        basePage.waitElementIsVisible(driver.findElement(By.xpath("//h2[@class='line-1']"))).isDisplayed();
        Assertions.assertEquals(ruAnimeName, mangaPage.getRuAnimeName());
        Assertions.assertEquals(enAnimeName, mangaPage.getEnAnimeName());
    }

    @Test
    public void checkRedirectToSignInAndSignUpPage(){
        basePage.goToUrl(BASE_URL);
        mainPage.clickSignInOrSignUpButton();
        basePage.waitElementIsVisible(driver.findElement(By.xpath("//div[@class='card'][1]//h2")));
    }

}
