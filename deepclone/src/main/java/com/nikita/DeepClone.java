package com.nikita;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

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

        Class<?> clazz = original.getClass();
        // 3 если примитив или неизменяемое вернуть копию как есть.
        if(isPrimitiveOrImmutable(clazz))
            return original;

        // 4 если массив создать новый такого же типа пройтись по элементам скопировать рекурсивно
        if(clazz.isArray()){
            int length = Array.getLength(original);
            Object newArr = Array.newInstance(clazz.getComponentType(), length);
            copied.put(original, newArr);

            for(int i = 0; i < length; i++){
                Object originalItem = Array.get(original, i);
                Object cloned = cloneRecursive(originalItem, copied);
                Array.set(newArr, i, cloned);
            }

            return (T) newArr;
        }

        // 5 если коллекция создать пустую такого же типа пройтись скопировать элементы
        if(original instanceof Collection<?> collection){
           Collection<Object> newCollection = createEmptyCollection(collection);
           copied.put(original, newCollection);

           for(Object item : collection){
               Object cloned = cloneRecursive(item, copied);
               newCollection.add(cloned);
           }

           return(T) newCollection;
        }

        return null;
    }

    private static Collection<Object> createEmptyCollection(Collection<?> collection) {
        if (collection instanceof List<?>) return new ArrayList<>();
        if (collection instanceof Set<?>) return new HashSet<>();
        if (collection instanceof Deque<?>) return new LinkedList<>();
        if (collection instanceof Queue<?>) return new LinkedList<>();
        return new ArrayList<>();
    }

    private static boolean isPrimitiveOrImmutable(Class<?> clazz) {
        return clazz.isPrimitive()
                || clazz.equals(String.class)
                || clazz.equals(Boolean.class)
                || clazz.equals(Character.class)
                || clazz.equals(LocalDate.class)
                || Number.class.isAssignableFrom(clazz)
                || clazz.isEnum();
    }
}
