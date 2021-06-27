package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertFalse(util.Util.checkTime(seconds1));
        assertFalse(util.Util.checkTime(seconds2));
        assertFalse(util.Util.checkTime(seconds3));
        assertFalse(util.Util.checkTime(seconds4));
        assertTrue(util.Util.checkTime(seconds5));
        assertTrue(util.Util.checkTime(seconds6));
    }
}