package ru.geekbrains.homework7;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness = false;

    public Cat (String x, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            fullness = true;
            System.out.println("Кот " + name + " поел");
        } else {
            System.out.println("Кот " + name + " остался голодным");
        }
    }
}
