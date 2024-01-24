package fr.efrei.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import fr.efrei.playwright.utils.HomepageUtils;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ShouldNotAllowDuplicateTeamNamesTest extends PlaywrightTeamSApplicationTests{
    @Test
    public void shouldNotAllowDuplicateTeamNames() {
        new HomepageUtils(page).goToHomepage();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create new team")).click();
        page.getByPlaceholder("Name").click();
        page.getByPlaceholder("Name").click();
        page.getByPlaceholder("Name").fill("TeamS");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create new team")).click();
        page.getByPlaceholder("Name").click();
        page.getByPlaceholder("Name").fill("TeamS");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
        page.getByText("a team with the same name").click();
        assertThat(page.locator("form")).containsText("a team with the same name already exists");
    }
}
