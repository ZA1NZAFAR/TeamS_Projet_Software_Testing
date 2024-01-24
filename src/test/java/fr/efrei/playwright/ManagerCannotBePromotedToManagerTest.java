package fr.efrei.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ManagerCannotBePromotedToManagerTest extends PlaywrightTeamSApplicationTests {
    @Test
    public void managerCannotBePromotedToManager() {
        try (Playwright playwright = Playwright.create()) {

            page.navigate("https://s.hr.dmerej.info/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("List Employees")).click();
            assertThat(page.getByRole(AriaRole.TABLE)).containsText("yes");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).first().click();
            assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Promote as manager"))).isHidden();

        }
    }
}
