package fr.efrei.playwright.utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class EmployeeUtils {
    private final Page page;

    public EmployeeUtils(Page page) {
        this.page = page;
    }

    public EmployeeUtils goToAddEmployee() {
        page.navigate("https://s.hr.dmerej.info/add_employee");
        return this;
    }

    public EmployeeUtils fillName(String name) {
        page.locator("#id_name").fill(name);
        return this;
    }

    public EmployeeUtils fillEmail(String email) {
        page.locator("#id_email").fill(email);
        return this;
    }

    public EmployeeUtils fillAddress(String address) {
        page.locator("#id_address_line1").fill(address);
        return this;
    }

    public EmployeeUtils fillCity(String city) {
        page.locator("#id_city").fill(city);
        return this;
    }

    public EmployeeUtils fillZipcode(String zipcode) {
        page.locator("#id_zip_code").fill(zipcode);
        return this;
    }

    public EmployeeUtils fillHiringDate(String hiringDate) {
        page.locator("#id_hiring_date").fill(hiringDate);
        return this;
    }

    public EmployeeUtils fillJobTitle(String jobTitle) {
        page.locator("#id_job_title").fill(jobTitle);
        return this;
    }

    public EmployeeUtils clickAdd() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
        return this;
    }
}
