package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    private final Feline feline = new Feline();

    @Test
    public void testEatMeat() throws Exception {
        List<String> meat = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), meat);
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithoutArg() {
        assertEquals(1, feline.getKittens());
    }

    // Параметризованный тест для проверки getKittens(int) с разными значениями
    @RunWith(Parameterized.class)
    public static class FelineKittensParamTest {

        private final int input;
        private final int expected;

        public FelineKittensParamTest(int input, int expected) {
            this.input = input;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {5, 5},
                    {0, 0},
                    {10, 10}
            });
        }

        @Test
        public void testGetKittensWithArg() {
            Feline feline = new Feline();
            assertEquals(expected, feline.getKittens(input));
        }
    }
}