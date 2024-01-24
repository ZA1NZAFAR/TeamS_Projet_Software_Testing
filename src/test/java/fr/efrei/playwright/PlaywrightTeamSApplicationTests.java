package fr.efrei.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@SpringBootTest
class PlaywrightTeamSApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void ensureElementsAreVisible() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType chromium = playwright.chromium();
            Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = browser.newPage();
            page.navigate("https://s.hr.dmerej.info");

            assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("List Employees"))).isVisible();
            assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new employee"))).isVisible();
            assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("List teams"))).isVisible();
            assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create new team"))).isVisible();
            assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reset database"))).isVisible();
            browser.close();
        }
    }
}
