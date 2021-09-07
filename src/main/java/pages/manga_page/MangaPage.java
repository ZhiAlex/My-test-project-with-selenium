package pages.manga_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class MangaPage extends BasePage {

    public MangaPage(WebDriver driver) {
        super(driver);
    }

    private final By ruAnimeName = By.xpath("//h2[@class='line-1']");
    private final By enAnimeName = By.xpath("//h2[@class='line-2']");

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

}
