package fr.efrei.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@SpringBootTest
class PlaywrightTeamSApplicationTests {
    // Shared between all tests in this class
    static Playwright playwright;
    static Browser browser;

    // New instance for each test method
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

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
