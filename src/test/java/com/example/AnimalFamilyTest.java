package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AnimalFamilyTest {

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", family);
    }
}
