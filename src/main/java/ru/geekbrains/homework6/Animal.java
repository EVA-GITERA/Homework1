package ru.geekbrains.homework6;

public class Animal {
    public String name;
    public static int count = 0;


    public Animal(String name) {
       this.name = name;
       count++;
    }

    public void run(int distance) {
        System.out.println("Животное " + name + " пробежал " + distance + " метров");
    }

    public void swim(int distance) {
        System.out.println("Животное " + name + " проплыл " + distance + " метров");
    }
}
