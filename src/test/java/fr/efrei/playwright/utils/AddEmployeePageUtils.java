package fr.efrei.playwright.utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AddEmployeePageUtils {
    private final Page page;

    public AddEmployeePageUtils(Page page) {
        this.page = page;
    }

    public AddEmployeePageUtils navigate() {
        page.navigate("https://s.hr.dmerej.info/add_employee");
        return this;
    }

    public AddEmployeePageUtils fillName(String name) {
        page.locator("#id_name").fill(name);
        return this;
    }

    public AddEmployeePageUtils fillEmail(String email) {
        page.locator("#id_email").fill(email);
        return this;
    }

    public AddEmployeePageUtils fillAddress(String address) {
        page.locator("#id_address_line1").fill(address);
        return this;
    }

    public AddEmployeePageUtils fillCity(String city) {
        page.locator("#id_city").fill(city);
        return this;
    }

    public AddEmployeePageUtils fillZipcode(String zipcode) {
        page.locator("#id_zip_code").fill(zipcode);
        return this;
    }

    public AddEmployeePageUtils fillHiringDate(String hiringDate) {
        page.locator("#id_hiring_date").fill(hiringDate);
        return this;
    }

    public AddEmployeePageUtils fillJobTitle(String jobTitle) {
        page.locator("#id_job_title").fill(jobTitle);
        return this;
    }

    public AddEmployeePageUtils submitForm() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
        return this;
    }

    public AddEmployeePageUtils fillData(String name, String email, String address, String city, String zipcode, String hiringDate, String jobTitle) {
        fillName(name);
        fillEmail(email);
        fillAddress(address);
        fillCity(city);
        fillZipcode(zipcode);
        fillHiringDate(hiringDate);
        fillJobTitle(jobTitle);
        return this;
    }
}
