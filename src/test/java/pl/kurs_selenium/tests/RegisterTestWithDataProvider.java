package pl.kurs_selenium.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.kurs_selenium.pages.HomePage;
import pl.kurs_selenium.utils.ExcelReader;

import java.io.IOException;

public class RegisterTestWithDataProvider extends BaseTest {
    @DataProvider(name = "excelFile")
    public Object[][] userData() throws IOException {
        return ExcelReader.userData("userData.xlsx");
    }
    @Test(dataProvider = "excelFile")
    public void signUpWithDP(String firstName, String lastName, String phone, String email, String password, String confirmPass) {
        new HomePage(driver).signUp()
                .registerUser(firstName,lastName,phone,email,password,confirmPass);

    }
}
