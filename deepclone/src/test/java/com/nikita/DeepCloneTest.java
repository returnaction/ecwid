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
}