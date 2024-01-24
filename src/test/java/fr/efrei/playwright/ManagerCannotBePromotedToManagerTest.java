package fr.efrei.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import fr.efrei.playwright.utils.HomepageUtils;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

//TODO: refactor this test to create/use utils classes
public class ManagerCannotBePromotedToManagerTest extends PlaywrightTeamSApplicationTests {
    @Test
    public void managerCannotBePromotedToManager() {
        try (Playwright playwright = Playwright.create()) {

            new HomepageUtils(page).goToHomepage();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("List Employees")).click();
            assertThat(page.getByRole(AriaRole.TABLE)).containsText("yes");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).first().click();
            assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Promote as manager"))).isHidden();

        }
    }
}
