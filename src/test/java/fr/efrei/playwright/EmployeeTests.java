package fr.efrei.playwright;

import fr.efrei.playwright.utils.AddEmployeePageUtils;
import org.junit.jupiter.api.Test;

import java.util.UUID;

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

        AddEmployeePageUtils addEmployeePageUtils = new AddEmployeePageUtils(page);
        addEmployeePageUtils.goToAddEmployee()
                .fillName(name)
                .fillEmail(email)
                .fillAddress(address)
                .fillCity(city)
                .fillZipcode(zipcode)
                .fillHiringDate(hiringDate)
                .fillJobTitle(jobTitle)
                .clickAdd();

    }
}
