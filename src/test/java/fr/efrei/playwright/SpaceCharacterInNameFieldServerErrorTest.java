package fr.efrei.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import fr.efrei.playwright.utils.HomepageUtils;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SpaceCharacterInNameFieldServerErrorTest extends PlaywrightTeamSApplicationTests {
    @Test
    public void spaceCharacterInNameFieldServerError() {
        try (Playwright playwright = Playwright.create()) {

            new HomepageUtils(page).goToHomepage();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create new team")).click();
            page.getByPlaceholder("Name").click();
            page.getByPlaceholder("Name").fill("     ");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
            assertThat(page.getByRole(AriaRole.HEADING)).containsText("Server Error (500)");

        }
    }

}
