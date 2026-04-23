package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline mockFeline;

    @Parameterized.Parameters(name = "sex={0}, hasMane={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testConstructorInvalidSex() {
        Exception exception = assertThrows(Exception.class,
                () -> new Lion("Оно", mockFeline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void testGetKittens() throws Exception {
        when(mockFeline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion male = new Lion("Самец", mockFeline);
        assertTrue(male.doesHaveMane());

        Lion female = new Lion("Самка", mockFeline);
        assertFalse(female.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Антилопа", "Зебра");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(expectedFood, lion.getFood());
    }
}