package fr.efrei.playwright;

import fr.efrei.playwright.utils.EmployeeUtils;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class NegativePostalCodeTest extends PlaywrightTeamSApplicationTests {

    @Test
    public void ensureElementsAreVisible() {

        EmployeeUtils employeeUtils = new EmployeeUtils(page);

        employeeUtils.goToAddEmployee()
                .fillName("TestName")
                .fillEmail("test@test.com")
                .fillAddress("TestAddress")
                .fillCity("TestCity")
                .fillZipcode("-738495789347589738947598734578934758")
                .fillHiringDate("2021-01-02")
                .fillJobTitle("TestJobTitle")
                .clickAdd();

        //check if error 500 is displayed
        assertThat("Error 500 is displayed", !page.isVisible("text=Server Error (500)"));

    }
}
