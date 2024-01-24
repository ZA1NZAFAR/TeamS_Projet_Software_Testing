package fr.efrei.playwright.utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class EmployeeUtils {
    Page page;

    public EmployeeUtils(Page page) {
        this.page = page;
    }

    public void createNewEmployee(String name, String email, String address, String city, String zipcode, String hiringDate, String jobTitle) {
        page.navigate("https://s.hr.dmerej.info/add_employee");

        page.getByPlaceholder("Name").fill(name);
        page.getByPlaceholder("Email").fill(email);
        page.locator("#id_address_line1").fill(address);
        page.getByPlaceholder("City").fill(city);
        page.getByPlaceholder("Zip code").fill(zipcode);
        page.getByPlaceholder("Hiring date").fill(hiringDate);
        page.getByPlaceholder("Job title").fill(jobTitle);

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
    }

}
