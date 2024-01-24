package fr.efrei.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import fr.efrei.playwright.utils.AddEmployeePageUtils;
import fr.efrei.playwright.utils.HomepageUtils;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ManagerCanBePromotedToManagerTest extends PlaywrightTeamSApplicationTests {
    @Test
    public void managerCanBePromotedToManager() {
        try (Playwright playwright = Playwright.create()) {
            new HomepageUtils(page).goToHomepage();
            new AddEmployeePageUtils(page).addManager();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("List Employees")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).first().click();
            assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Promote as manager"))).isVisible();
        }
    }
}
