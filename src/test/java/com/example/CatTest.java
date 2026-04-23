package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Predator mockPredator;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(mockPredator);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Мышь", "Птица");
        when(mockPredator.eatMeat()).thenReturn(expectedFood);
        Cat cat = new Cat(mockPredator);
        assertEquals(expectedFood, cat.getFood());
    }
}