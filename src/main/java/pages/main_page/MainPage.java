package pages.main_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By searchInput = By.xpath("//input[@class='m-big-search-input']");
    private final By searchButton = By.xpath("//button[@class='m-big-search-button green darken-4 white-text waves-effect waves-light btn-large']");

    private final By catalogOfAllAnimeButton = By.xpath("//div[@class = 'm-index-top__line']/child::a[text() = 'Каталог всех аниме']");
    private final By searchByGenreButton = By.xpath("//div[@class = 'm-index-top__line']/child::a[text() = 'Поиск по жанрам']");
    private final By searchByNameButton = By.xpath("//div[@class = 'm-index-top__line']/child::a[text() = 'Поиск по названию']");

    private final By animeImgItems = By.xpath("//div[@class='m-catalog-item__poster']/child::a");
    private final By animeRuNameButtonItems = By.xpath("//div[@class='card m-catalog-item m-catalog-item_small hoverable']//child::h5/a");
    private final By animeEnNameButtonItems = By.xpath("//div[@class='card m-catalog-item m-catalog-item_small hoverable']//child::h4/a");

    private final By signInOrSignUpButton = By.xpath("//a[@class='green darken-4 white-text waves-effect waves-light btn-large']");

    public void EnterTheNameOfTheAnimeInTheSearchInput(){
        driver
                .findElement(searchInput)
                .sendKeys("Врата Штейна");
    }

    public void clickSearchButton(){
        driver
                .findElement(searchButton)
                .click();
    }

    public void clickToCatalogOfAllAnimeButton(){
        driver
                .findElement(catalogOfAllAnimeButton)
                .click();
    }

    public void clickSearchByGenreButton(){
        driver
                .findElement(searchByGenreButton)
                .click();
    }

    public void clickSearchByNameButton(){
        driver
                .findElement(searchByNameButton)
                .click();
    }

    public void clickFirstAnimeImg(){
        driver
                .findElements(animeImgItems)
                .get(0)
                .click();
    }

    public void clickFirstAnimeRuNameButton(){
        driver
                .findElements(animeRuNameButtonItems)
                .get(0)
                .click();
    }

    public void clickFirstAnimeEnNameButton(){
        driver
                .findElements(animeEnNameButtonItems)
                .get(0)
                .click();
    }

    public String getFirstAnimeNameRu(){
        return driver
                .findElements(animeRuNameButtonItems)
                .get(0)
                .getText();
    }

    public String getFirstAnimeNameEn(){
        return driver
                .findElements(animeEnNameButtonItems)
                .get(0)
                .getText();
    }

    public void clickSignInOrSignUpButton(){
        driver
                .findElement(signInOrSignUpButton)
                .click();
    }
}
