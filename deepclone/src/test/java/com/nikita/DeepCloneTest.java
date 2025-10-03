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
    void testString_shouldReturnSameString(){
        String original = "Привет Ecwid";
        String clone = DeepClone.deepClone(original);
        assertSame(original, clone);
    }

    @Test
    void testPrimitive_shouldReturnSameReference(){
        Integer original = 34;
        Integer clone = DeepClone.deepClone(original);
        assertSame(original, clone, "Для примитива должна возвращаться та же ссылка");

    }
}