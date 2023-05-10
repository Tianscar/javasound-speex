package org.xiph.speex.test;

import org.junit.jupiter.api.Assertions;

final class Utils {

    static void assertTrue(String message, boolean condition) {
        Assertions.assertTrue(condition, message);
    }

    static void assertEquals(String message, int expected, int actual) {
        Assertions.assertEquals(expected, actual, message);
    }

}
