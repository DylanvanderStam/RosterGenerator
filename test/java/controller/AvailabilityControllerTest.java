package controller;

import model.Employee;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AvailabilityControllerTest {

    @Test
    void checkAvailability() throws SQLException {
        Employee test = new Employee("Test", "van der Stam", "test@test.nl", "0612345678", "test123");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date1 = LocalDate.parse("25-05-2021", formatter);
        LocalDate date2 = LocalDate.parse("26-05-2021", formatter);
        LocalDate date3 = LocalDate.parse("27-05-2021", formatter);

        assertFalse(AvailabilityController.checkAvailability(date1, 9.0, 18.5, true, test));
        assertFalse(AvailabilityController.checkAvailability(date1, 9.5, 18.0, false, test));
        assertFalse(AvailabilityController.checkAvailability(date2, 9.0, 18.0, true, test));
        assertTrue(AvailabilityController.checkAvailability(date2, 9.5, 18.5, false, test));
        assertFalse(AvailabilityController.checkAvailability(date3, 9.0, 18.5, false, test));
        assertFalse(AvailabilityController.checkAvailability(date3, 9.5, 18.0, true, test));
    }
}