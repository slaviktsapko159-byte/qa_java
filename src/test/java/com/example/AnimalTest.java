package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final String animalKind;
    private final List<String> expectedFood;
    private final boolean exceptionExpected;

    public AnimalTest(String animalKind, List<String> expectedFood, boolean exceptionExpected) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
        this.exceptionExpected = exceptionExpected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения"), false},
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), false},
                {"Неизвестное", null, true},
                {null, null, true}
        });
    }

    @Test
    public void testGetFood() throws Exception {
        Animal animal = new Animal();
        if (exceptionExpected) {
            assertThrows(Exception.class, () -> animal.getFood(animalKind));
        } else {
            assertEquals(expectedFood, animal.getFood(animalKind));
        }
    }

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", family);
    }
}
