package com.nikita;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeepCloneTest {

    @Test
    void testNull_shouldReturnNull() {
        Man original = null;
        Man clone = DeepClone.deepClone(original);
        assertNull(clone, "Копия null должен быть тоже null");
    }

    @Test
    void testString_shouldReturnSameString() {
        String original = "Привет Ecwid";
        String clone = DeepClone.deepClone(original);
        assertSame(original, clone);
    }

    @Test
    void testPrimitive_shouldReturnSameReference() {
        Integer original = 34;
        Integer clone = DeepClone.deepClone(original);
        assertSame(original, clone, "Для примитива должна возвращаться та же ссылка");

    }

    @Test
    void testStringArray_shodReturnDeepClone() {
        String[] original = {"1", "2", "3"};
        String[] clone = DeepClone.deepClone(original);
        assertNotSame(original, clone, "Должен быть новый массив");
        assertArrayEquals(original, clone, "Должны совпадать");
        assertSame(original[0], clone[0], "Неизменяемые могут быть с той же ссылкой");

    }

    @Test
    void testObjectArray_shouldDeepClone(){
        Man man1 = new Man();
        man1.setName("Никита");

        Man man2 = new Man();
        man2.setName("Вася");
        Man[] original = {man1, man2};

        Man[] clone = DeepClone.deepClone(original);
        assertNotSame(original, clone);
    }
}