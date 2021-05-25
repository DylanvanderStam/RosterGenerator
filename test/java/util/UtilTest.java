package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void checkTime() {

    }

    @Test
    void darkMode() {
        Integer seconds1 = 43200;
        Integer seconds2 = 43201;
        Integer seconds3 = 86399;
        Integer seconds4 = 86400;
        Integer seconds5 = 43199;
        Integer seconds6 = 86401;

        assertFalse(Util.darkMode(seconds1));
        assertFalse(Util.darkMode(seconds2));
        assertFalse(Util.darkMode(seconds3));
        assertFalse(Util.darkMode(seconds4));
        assertTrue(Util.darkMode(seconds5));
        assertTrue(Util.darkMode(seconds6));
    }
}