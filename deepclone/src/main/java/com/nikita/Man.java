package com.nikita;

import java.time.LocalDate;
import java.util.*;

class Man {
    private String name;
    private int age;
    private boolean active;
    private double balance;
    private LocalDate birthDate;
    private Role role;
    private Man friend;

    private List<String> favoriteBooks;
    private Set<String> skills;
    private Queue<String> notes;

    private Map<String, String> metadata;
    private String[] tags;
    private int[] numbers;


    private List<Man> children;


    public enum Role {
        ADMIN, USER, GUEST
    }

    public Man() {

    }

    public Man(String name, int age, List<String> favoriteBooks) {
        this.name = name;
        this.age = age;
        this.favoriteBooks = favoriteBooks;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<String> getFavoriteBooks() {
        return favoriteBooks;
    }

    public void setFavoriteBooks(List<String> favoriteBooks) {
        this.favoriteBooks = favoriteBooks;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Queue<String> getNotes() {
        return notes;
    }

    public void setNotes(Queue<String> notes) {
        this.notes = notes;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Man getFriend() {
        return friend;
    }

    public void setFriend(Man friend) {
        this.friend = friend;
    }

    public List<Man> getChildren() {
        return children;
    }

    public void setChildren(List<Man> children) {
        this.children = children;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}