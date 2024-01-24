package fr.efrei.playwright.utils;

import com.microsoft.playwright.Page;

public class TeamsPageUtils extends BasePageUtils {
    public TeamsPageUtils(Page page) {
        super(page);
    }

    public TeamsPageUtils navigate() {
        page.navigate("https://s.hr.dmerej.info/teams");
        return this;
    }


}
