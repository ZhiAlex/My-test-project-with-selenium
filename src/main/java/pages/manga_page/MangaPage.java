package pages.manga_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.List;

public class MangaPage extends BasePage {

    public MangaPage(WebDriver driver) {
        super(driver);
    }

    private final By ruAnimeName = By.xpath("//h2[@class='line-1']");
    private final By enAnimeName = By.xpath("//h2[@class='line-2']");
    private final By tags = By.xpath("//div[@class='m-genres-list']/child::a");
    private final By startWatchingButton = By.xpath("//div[@class='col s12 m8 l9 col-even']/a");
    private final By viewOrderBlock = By.xpath("//div[@class='card m-connections-list']");
    private final By allReleasedEpisodesButtons = By.xpath("//div[@class='card-content m-episode-list']/div/div/a");

    public String getRuAnimeName(){
        return driver
                .findElement(ruAnimeName)
                .getText();
    }

    public String getEnAnimeName(){
        return driver
                .findElement(enAnimeName)
                .getText();
    }

    public List<WebElement> getAnimeTags(){
        return driver.findElements(tags);
    }

    public void clickStartWatchingButton(){
        driver.findElement(startWatchingButton).click();
    }

    public WebElement getViewOrderBlock(){
        return driver.findElement(viewOrderBlock);
    }

    public List<WebElement> getAllReleasedEpisodes(){
        return driver.findElements(allReleasedEpisodesButtons);
    }

}
