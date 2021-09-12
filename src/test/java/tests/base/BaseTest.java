package tests.base;

import common.CommonDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import pages.main_page.MainPage;
import pages.manga_page.MangaPage;

import java.io.File;
import java.util.Date;
import java.util.Objects;

import static common.Config.*;

@ExtendWith(Listener.class)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver = CommonDriver.createDriver();

    protected BasePage basePage = new BasePage(driver);

    protected MainPage mainPage = new MainPage(driver);

    protected MangaPage mangaPage = new MangaPage(driver);

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);


    static {
        LOGGER.info(getCurrentDate() + " TESTING START");

        if (CLEAR_SCREENSHOT_DIR){
            LOGGER.info(getCurrentDate() + " Start clear screenshots dir (build/reports/tests)");
            File screenshots = new File("build/reports/tests");
            if (screenshots.isDirectory()){
                for (File item : Objects.requireNonNull(screenshots.listFiles())){
                    item.delete();
                }
            }
        }
        if (CLEAR_ALLURE_RESULTS_DIR){
            LOGGER.info(getCurrentDate() + " Start clear allure-result dir");
            File allureResults = new File("allure-results");
            if (allureResults.isDirectory()){
                for (File item : Objects.requireNonNull(allureResults.listFiles())){
                    item.delete();
                }
            }
        }
    }

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
        LOGGER.info(getCurrentDate()+ " END OF TESTING");
    }

    private static String getCurrentDate(){
        Date date = new Date();
        return date.toString();
    }

}
