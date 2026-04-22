package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline mockFeline;

    @ParameterizedTest
    @CsvSource({"Самец, true", "Самка, false"})
    void doesHaveMane_shouldReturnCorrectValue(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    void constructor_withInvalidSex_throwsException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Нечто", mockFeline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void getKittens_shouldCallFelineGetKittens() throws Exception {
        when(mockFeline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(3, lion.getKittens());
        verify(mockFeline, times(1)).getKittens();
    }

    @Test
    void getFood_shouldCallFelineGetFood() throws Exception {
        List<String> expectedFood = List.of("Зебра", "Антилопа");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", mockFeline);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
        verify(mockFeline, times(1)).getFood("Хищник");
    }
}
