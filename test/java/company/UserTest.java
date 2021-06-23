package company;

import org.junit.jupiter.api.Test;
import user.Employee;
import user.User;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User test = new Employee("Dylan", "van der Stam", "d.stam8@live.nl", "0683599294", "test");

    @Test
    void getFirstName() {
        assertEquals("Dylan", test.getFirstName());
    }

    @Test
    void getEmail() {
        assertEquals("d.stam8@live.nl", test.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals("test", test.getPassword());
    }
}