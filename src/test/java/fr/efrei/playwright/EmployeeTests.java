package fr.efrei.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import fr.efrei.playwright.utils.AddEmployeePageUtils;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class EmployeeTests extends PlaywrightTeamSApplicationTests {

    @Test
    public void ensureCreationOfNewEmployee() {
        UUID uuid = UUID.randomUUID();

        String name = "TestName " + uuid;
        String email = "a" + uuid + "@abc.com";
        String address = "TestAddress " + uuid;
        String city = "TestCity " + uuid.toString().substring(0, 5);
        String zipcode = Math.floor(Math.random() * 90000) + 10000 + "";
        String hiringDate = "2021-01-02";
        String jobTitle = "TestJobTitle " + uuid;

        AddEmployeePageUtils employeeUtils = new AddEmployeePageUtils(page);
        employeeUtils.navigate()
                .fillData(name, email, address, city, zipcode, hiringDate, jobTitle)
                .submitForm();

        assert(page.url()).equals("https://s.hr.dmerej.info/employees");
        assertThat(page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(name))).isVisible();
        assertThat(page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(email))).isVisible();
    }

    @Test
    public void shouldContainEmployees() {
        page.navigate("https://s.hr.dmerej.info");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("List Employees")).click();
        assertThat(page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("f f f"))).isVisible();
        assertThat(page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("AAAAA"))).isVisible();
    }
}
