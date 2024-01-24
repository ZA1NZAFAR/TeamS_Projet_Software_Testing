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

    @Test
    public void shouldContainEmployees() {
        page.navigate("https://s.hr.dmerej.info");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("List Employees")).click();
        assertThat(page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("f f f"))).isVisible();
        assertThat(page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("AAAAA"))).isVisible();
    }

    @Test
    public void spaceCharacterInNameFieldServerError() {
        try (Playwright playwright = Playwright.create()) {

            page.navigate("https://s.hr.dmerej.info/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create new team")).click();
            page.getByPlaceholder("Name").click();
            page.getByPlaceholder("Name").fill("     ");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
            assertThat(page.getByRole(AriaRole.HEADING)).containsText("Server Error (500)");

        }
    }

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

    @Test
    public void shouldNotAllowDuplicateTeamNames() {
        page.navigate("https://s.hr.dmerej.info/");
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
