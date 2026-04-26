package com.example;

import org.junit.Test;
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
}