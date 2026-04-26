package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;
    private final int expected;

    @Parameters(name = "kittensCount={0}, expected={1}")
    public static Object[][] data() {
        return new Object[][] {
                {5, 5},
                {0, 0},
                {10, 10}
        };
    }

    public FelineParameterizedTest(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Test
    public void testGetKittensWithArg() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(kittensCount));
    }
}
