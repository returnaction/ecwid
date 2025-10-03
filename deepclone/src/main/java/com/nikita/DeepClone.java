package com.nikita;

import java.util.IdentityHashMap;

public class DeepClone {
    /// План
// 1 если null вернуть null
// 2 если уже копировал вернуть из сохраненной мапы
// 3 если примитив или неизменяемое вернуть копию как есть.
// 4 если массив создать новый такого же типа пройтись по элементам скопировать рекурсивно
// 5 если коллекция создать пустую такого же типа пройтись скопировать элементы
// 6 если map создать пустую  и копи ключи и значения
// 7 если обычный объект создать через рефликсию гоняем по всем значениям
// 8 вернуть копию

    public static <T> T deepClone(T original){
        return cloneRecursive(original, new IdentityHashMap<>());
    }

    private static <T> T cloneRecursive(T original, IdentityHashMap<Object, Object> copied) {
        // 1 если null вернуть null
        if(original == null)
            return null;

        // 2 если уже копировал вернуть из сохраненной мапы
        if(copied.containsKey(original))
            return (T) copied.get(original);

        return null;
    }
}
