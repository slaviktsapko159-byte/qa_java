package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    private final Feline feline = new Feline();

    @Test
    void eatMeat_shouldReturnMeatList() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    void getFamily_shouldReturnCats() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittens_withoutArgs_shouldReturnOne() {
        assertEquals(1, feline.getKittens());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void getKittens_withArg_shouldReturnArg(int kittensCount) {
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
