package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expectedMane;

    @Parameters(name = "sex={0}, hasMane={1}")
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    public LionParameterizedTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, felineMock);
        assertEquals(expectedMane, lion.doesHaveMane());
    }
}