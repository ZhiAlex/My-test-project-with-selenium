package tests.manga_page.positive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.base.BaseTest;

import static constants.Constant.Urls.BASE_URL;

public class MangaPagePTest extends BaseTest {
    @Test
    public void checkRedirectToAnimeTags(){
        basePage.goToUrl(BASE_URL);
        mainPage.clickFirstAnimeImg();
        for (int i = 0; i <= mangaPage.getAnimeTags().size()-1; i++){
            var animeTags = mangaPage.getAnimeTags();
            String tagName = animeTags.get(i).getText().toLowerCase();
            animeTags.get(i).click();
            String tagNameAfterRedirect = driver.findElement(By.xpath(String.format("//span[@class='ccs-chip-name']['%s']", i))).getText().toLowerCase();
            driver.navigate().back();
            Assertions.assertEquals(tagName, tagNameAfterRedirect);
        }
    }

    @Test
    public void checkRedirectToPageWithPlayer(){
        basePage.goToUrl(BASE_URL);
        mainPage.clickFirstAnimeImg();
        mangaPage.clickStartWatchingButton();
        basePage.waitElementIsVisible(driver.findElement(By.xpath("//div[@class='video-container']")));
    }

    @Test
    public void viewOrderBlockIsVisible(){
        basePage.goToUrl(BASE_URL);
        mainPage.clickFirstAnimeImg();
        basePage.waitElementIsVisible(mangaPage.getViewOrderBlock());
    }

    @Test
    public void checkRedirectToTheFirstEpisode(){
        basePage.goToUrl(BASE_URL);
        mainPage.clickFirstAnimeImg();
        String episodeNumber =  mangaPage.getAllReleasedEpisodes().get(0).getText().split("\n")[1].toLowerCase();
        mangaPage.getAllReleasedEpisodes().get(0).click();
        basePage.waitElementIsVisible(driver.findElement(By.xpath("//div[@class='m-translation-view-title']")));
        Assertions.assertEquals(episodeNumber, driver.findElement(By.xpath("//div[@class='m-translation-view-title']/h2")).getText());

    }
}