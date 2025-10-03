package com.nikita;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Man man1 = new Man();
        man1.setName("Никита");
        man1.setAge(34);
        man1.setActive(true);
        man1.setBalance(123.123);
        man1.setBirthDate(LocalDate.of(1991, 7, 11));
        man1.setRole(Man.Role.ADMIN);

        List<String> favoriteBooks = new ArrayList<>();
        favoriteBooks.add("Java SE");
        favoriteBooks.add("Java EE");
        man1.setFavoriteBooks(favoriteBooks);

        Set<String> skills = new HashSet<>();
        skills.add("Java");
        skills.add("Spring");
        man1.setSkills(skills);

        Queue<String> notes = new LinkedList<>();
        notes.add("Note 1");
        notes.add("Note 2");

        man1.setNotes(notes);

        Map<String, String> metadata = new HashMap<>();
        metadata.put("key1", "value1");
        metadata.put("key2", "value2");
        man1.setMetadata(metadata);

        String[] tags = new String[]{"tag1", "tag2"};

        man1.setTags(tags);

        int[] numbers = new int[]{1, 2, 3};
        man1.setNumbers(numbers);

        Man friend = new Man();
        friend.setName("Вася");
        man1.setFriend(friend);

        Man child1 = new Man();
        child1.setName("Андрей");
        Man child2 = new Man();
        child2.setName("Оля");
        List<Man> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        man1.setChildren(children);


        Man man1Copy = DeepClone.deepClone(man1);
        System.out.println("\t\tОригинал:");
        print(man1);

        System.out.println("\t\tКопия:");
        print(man1Copy);


        man1.setName("Никита Updated");
        man1.setAge(35);
        man1.setActive(false);
        man1.setBalance(321.321);
        man1.setBirthDate(LocalDate.of(1991, 8, 12));
        man1.setRole(Man.Role.USER);

        List<String> favoriteBooks2 = new ArrayList<>();
        favoriteBooks.add("Java SE Updated");
        favoriteBooks.add("Java EE Updated");
        man1.setFavoriteBooks(favoriteBooks2);

        Set<String> skills2 = new HashSet<>();
        skills.add("Java Updated");
        skills.add("Spring Updated");
        man1.setSkills(skills2);

        Queue<String> notes2 = new LinkedList<>();
        notes.add("Note 1 Updated");
        notes.add("Note 2 Updated");

        man1.setNotes(notes2);

        Map<String, String> metadata2 = new HashMap<>();
        metadata.put("key1", "value1 Updated");
        metadata.put("key2", "value2 Updated");
        man1.setMetadata(metadata2);

        String[] tags2 = new String[]{"tag1 Updated", "tag2 Updated"};

        man1.setTags(tags2);

        int[] numbers2 = new int[]{4, 5, 6};
        man1.setNumbers(numbers2);

        Man friend2 = new Man();
        friend.setName("Вася Updated");
        man1.setFriend(friend2);

        Man child12 = new Man();
        child1.setName("Андрей Updated");
        Man child22 = new Man();
        child2.setName("Оля Updated");
        List<Man> children2 = new ArrayList<>();
        children.add(child12);
        children.add(child22);
        man1.setChildren(children2);

        System.out.println("\t\tКопия:");
        print(man1Copy);

    }

    private static void print(Man man) {
        System.out.println("Имя: " + man.getName());
        System.out.println("Возраст: " + man.getAge());
        System.out.println("Активен: " + man.isActive());
        System.out.println("Баланс: " + man.getBalance());
        System.out.println("Дата Рождения: " + man.getBirthDate());
        System.out.println("Роль: " + man.getRole());

        System.out.println("Любимые книги: " + (man.getFavoriteBooks() != null ? man.getFavoriteBooks() : "нет"));
        System.out.println("Навыки: " + (man.getSkills() != null ? man.getSkills() : "нет"));
        System.out.println("Заметки: " + (man.getNotes() != null ? man.getNotes() : "нет"));
        System.out.println("Метаданные: " + (man.getMetadata() != null ? man.getMetadata() : "нет"));
        System.out.println("Теги: " + (man.getTags() != null ? Arrays.toString(man.getTags()) : "нет"));
        System.out.println("Числа: " + (man.getNumbers() != null ? Arrays.toString(man.getNumbers()) : "нет"));
        System.out.println("Друг: " + (man.getFriend() != null ? man.getFriend().getName() : "нет"));

        System.out.println("Дети: ");
        if (man.getChildren() != null && !man.getChildren().isEmpty()) {
            for (Man child : man.getChildren()) {
                System.out.print(child.getName() + ", ");
            }
            System.out.println();
        } else {
            System.out.println("нет");
        }

    }
}