package fr.efrei.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

//TODO: refactor this test to create/use utils classes
public class ShouldContainEmployeesTest extends PlaywrightTeamSApplicationTests {

    @Test
    public void shouldContainEmployees() {
        page.navigate("https://s.hr.dmerej.info");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("List Employees")).click();
        assertThat(page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("f f f"))).isVisible();
        assertThat(page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("AAAAA"))).isVisible();
    }
}
