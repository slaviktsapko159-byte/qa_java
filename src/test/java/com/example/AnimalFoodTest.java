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
public class AnimalFoodTest {

    private final String animalKind;
    private final List<String> expectedFood;
    private final boolean exceptionExpected;

    public AnimalFoodTest(String animalKind, List<String> expectedFood, boolean exceptionExpected) {
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
}
