package controller;

import company.Company;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class LoginControllerTest {
    Company c = new Company("Test");

    LoginControllerTest() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
    }

    @Test
    void login() {
        login();
    }
}