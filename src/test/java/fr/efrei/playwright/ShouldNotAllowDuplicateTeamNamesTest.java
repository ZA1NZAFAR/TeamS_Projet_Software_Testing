package fr.efrei.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import fr.efrei.playwright.utils.AddTeamPageUtils;
import fr.efrei.playwright.utils.HomepageUtils;
import fr.efrei.playwright.utils.TeamsPageUtils;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ShouldNotAllowDuplicateTeamNamesTest extends PlaywrightTeamSApplicationTests{
    @Test
    public void shouldNotAllowDuplicateTeamNames() {
        UUID uuid = UUID.randomUUID();
        String teamName = "Team" + uuid;
        AddTeamPageUtils addTeamPage = new AddTeamPageUtils(page);
        addTeamPage.navigate().fillName(teamName).submitForm();

        assert(page.url().equals("https://s.hr.dmerej.info/teams"));

        AddTeamPageUtils addTeamPage2 = new AddTeamPageUtils(page);
        addTeamPage2.navigate().fillName(teamName).submitForm();

        assert(page.url().equals("https://s.hr.dmerej.info/add_team"));
        assertThat(page.locator("form")).containsText("a team with the same name already exists");
    }
}
