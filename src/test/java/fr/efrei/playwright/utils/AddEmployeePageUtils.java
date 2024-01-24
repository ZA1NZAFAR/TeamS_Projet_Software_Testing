package fr.efrei.playwright.utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AddEmployeePageUtils {
    private final Page page;

    public AddEmployeePageUtils(Page page) {
        this.page = page;
    }

    AddEmployeePageUtils addEmployeePageUtils = new AddEmployeePageUtils(page);


    public AddEmployeePageUtils goToAddEmployee() {
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

    public AddEmployeePageUtils clickAdd() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
        return this;
    }

    public AddEmployeePageUtils addManager() {
        page.navigate("https://s.hr.dmerej.info/semployee");
        addEmployeePageUtils.goToAddEmployee()
                .fillName("TestName")
                .fillEmail("test@test.com")
                .fillAddress("TestAddress")
                .fillCity("TestCity")
                .fillZipcode("10000")
                .fillHiringDate("2021-01-02")
                .fillJobTitle("TestJobTitle")
                .clickAdd();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).first().click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Promote as manager")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed")).click();

        return this;
    }
}
