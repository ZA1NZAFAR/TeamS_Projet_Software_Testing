package fr.efrei.playwright.utils;

import com.microsoft.playwright.Page;

public class HomepageUtils {
    private final Page page;

    public HomepageUtils(Page page) {
        this.page = page;
    }

    public void goToHomepage() {
        page.navigate("https://s.hr.dmerej.info/");
    }

    public void goToAddEmployee() {
        page.navigate("https://s.hr.dmerej.info/add_employee");
    }

    public void goToCreateNewTeam() {
        page.navigate("https://s.hr.dmerej.info/create_team");
    }
}
