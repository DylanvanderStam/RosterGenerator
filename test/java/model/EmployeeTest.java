package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    Employee test = new Employee("Dylan", "van der Stam", "d.stam8@live.nl", "0683599294", "test");

    @Test
    void addAvailability() {
        test.addAvailability(new Availability("01-01-2020", 9.0, 15.5));
        assertEquals("01-01-2020", test.getAvailability().get(0).getDate());
        assertEquals(9.0, test.getAvailability().get(0).getBeginTime());
        assertEquals(15.5, test.getAvailability().get(0).getEndTime());
    }
}