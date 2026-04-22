package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Feline mockFeline;

    @InjectMocks
    private Cat cat;

    @Test
    void getSound_shouldReturnMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFood_shouldCallEatMeatAndReturnResult() throws Exception {
        List<String> expectedFood = List.of("Рыба", "Мясо");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
        verify(mockFeline, times(1)).eatMeat();
    }
}
