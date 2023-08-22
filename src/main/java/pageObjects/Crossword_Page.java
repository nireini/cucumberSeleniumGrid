package pageObjects;

import enums.ByTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class Crossword_Page extends BasePage{

    public @FindBy(xpath = "//button[@mode=\"primary\"]") WebElement AGREE_BUTTON_XPATH;
    public @FindBy(css = "div.ark-ad-button-text.ctaButtonText") WebElement PLAY_BUTTON_CSS;
    public @FindBy(xpath = "//h4[text()=\"Daily Bonus\"]/../../..") WebElement Current_Day_With_Daily_Bonus_XPATH;
    public @FindBy(id = GAMEIFRAME_ID) WebElement GAMEIFRAME_Element_ID;

    private static final String GAMEIFRAME_ID = "game-canvas";

    public Crossword_Page() throws IOException {
        super();
    }

    public Crossword_Page getCrosswordPage() throws IOException {
        getDriver().get("https://www.gamelab.com/games/daily-quick-crossword");
        return new Crossword_Page();
    }

    public Crossword_Page clickOnAgreeButton() throws Exception {
        waitAndClickElement(AGREE_BUTTON_XPATH);
        return new Crossword_Page();
    }

    public Crossword_Page clickOnPlayButton() throws Exception {
        waitAndClickElement(PLAY_BUTTON_CSS);
        return new Crossword_Page();
    }

    public Crossword_Page waitForCurrentDayLiElement() throws Exception {
        switchToFrameAndWaitForElement(Current_Day_With_Daily_Bonus_XPATH, ByTypes.id, GAMEIFRAME_ID);

        return new Crossword_Page();
    }
}
