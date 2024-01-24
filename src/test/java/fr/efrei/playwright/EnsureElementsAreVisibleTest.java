package fr.efrei.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class EnsureElementsAreVisibleTest extends PlaywrightTeamSApplicationTests{
    @Test
    public void ensureElementsAreVisible() {
        // Indicates URL of the website being tested
        page.navigate("https://s.hr.dmerej.info");

        // Test steps
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("List Employees"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new employee"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("List teams"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create new team"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reset database"))).isVisible();
    }
}
