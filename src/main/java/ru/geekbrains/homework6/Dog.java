package ru.geekbrains.homework6;

public class Dog extends Animal {

    private final int distanceRunMax = 500;
    private final int distanceSwimMax = 10;
    public static int count = 0;

    public Dog (String name) {
       super(name);
       count++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 0) {
            System.out.println("Пёс по кличке " + name + " решил сегодня отказаться от пробежки");
        } else if (distance <= distanceRunMax) {
            System.out.println("Пёс по кличке " + name + " пробежал " + distance + " метров");
        } else {
            System.out.println("Пёс по кличке " + name + " вам не марафонец");
        }
    }
    @Override
    public void swim (int distance) {
        if (distance <= 0) {
            System.out.println("Псу по кличке " + name + " сегодня плавать недосуг");
        } else if (distance <= distanceSwimMax) {
            System.out.println("Пёс по кличке " + name + " совершил заплыв на " + distance + " метров");
        } else {
            System.out.println("Пёс по кличке " + name + " чуть не утонул, но вовремя решил вернуться на берег");
        }
    }
}
