package fr.efrei.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class EmployeeGetsPromotedToManagerTest extends PlaywrightTeamSApplicationTests{
    @Test
    public void employeeGetsPromotedToManager() {
        try (Playwright playwright = Playwright.create()) {
            page.navigate("https://s.hr.dmerej.info/employees");
            assertThat(page.getByRole(AriaRole.TABLE)).containsText("no");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).nth(1).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Promote as manager")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed")).click();
            assertThat(page.getByRole(AriaRole.TABLE)).containsText("yes");
        }
    }
}
