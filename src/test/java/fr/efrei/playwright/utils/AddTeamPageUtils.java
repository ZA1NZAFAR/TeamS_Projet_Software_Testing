package fr.efrei.playwright.utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AddTeamPageUtils extends BasePageUtils {
    public AddTeamPageUtils(Page page) {
        super(page);
    }

    public AddTeamPageUtils navigate() {
        page.navigate("https://s.hr.dmerej.info/add_team");
        return this;
    }

    public AddTeamPageUtils fillName(String name) {
        page.locator("#id_name").fill(name);
        return this;
    }

    public void submitForm() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
    }
}
