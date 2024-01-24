package fr.efrei.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.UUID;

public class EmployeeTests {

    void createNewEmployee() {
        public void ensureCreationOfNewEmployee() {
            UUID uuid = UUID.randomUUID();
            page.navigate("https://s.hr.dmerej.info/add_employee");

            String name = "TestName " + uuid;
            String email = "a" + uuid + "@abc.com";
            String address = "TestAddress " + uuid;
            String city = "TestCity " + uuid.toString().substring(0, 5);
            String zipcode = Math.floor(Math.random() * 90000) + 10000 + "";
            String hiringDate = "2021-01-02";
            String jobTitle = "TestJobTitle " + uuid;
            // Test steps
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
}
