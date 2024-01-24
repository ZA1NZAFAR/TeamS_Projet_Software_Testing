package fr.efrei.playwright.pom;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

public class ListEmployeesPage {
    private final Page page;

    public ListEmployeesPage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate("https://s.hr.dmerej.info/employees");
    }

    public List<String> employees() {
        List<String> textsFromColumns = new ArrayList<>();
        int rowCount = page.locator(".table-tbody").locator("tr").count();

        for (int i = 0; i < rowCount; i++) {
            String name = page.locator(".table-tbody").locator("tr").nth(i).locator("td").nth(0).innerText();
            String email = page.locator(".table-tbody").locator("tr").nth(i).locator("td").nth(1).innerText();
            String manager = page.locator(".table-tbody").locator("tr").nth(i).locator("td").nth(2).innerText();
            textsFromColumns.add(name + email + manager);
        }

        return textsFromColumns;
    }
}
