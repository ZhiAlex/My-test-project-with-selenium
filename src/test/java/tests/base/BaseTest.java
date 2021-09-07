package tests.base;

import common.CommonDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.main_page.MainPage;
import pages.manga_page.MangaPage;

import static common.Config.CLEAR_COOKIES;
import static common.Config.HOLD_BROWSER_OPEN;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver = CommonDriver.createDriver();

    protected BasePage basePage = new BasePage(driver);

    protected MainPage mainPage = new MainPage(driver);

    protected MangaPage mangaPage = new MangaPage(driver);

    @AfterEach
    void clearCookiesAndLocalStorage(){
        if (CLEAR_COOKIES){
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            jsExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterAll
    void close(){
        if (!HOLD_BROWSER_OPEN){
            driver.close();
        }
    }

}
