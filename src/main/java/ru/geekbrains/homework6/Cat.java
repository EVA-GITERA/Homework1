package ru.geekbrains.homework6;

public class Cat extends Animal {
    private final int distanceRunMax = 200;
    public static int count = 0;

    public Cat(String name) {
        super(name);
        count++;

    }

    @Override
    public void run(int distance) {
        if (distance <= 0) {
            System.out.println("Кот по кличке " + name + " никуда не побежал");
        } else if (distance <= distanceRunMax) {
            System.out.println("Кот по кличке " + name + " пробежал " + distance + " метров");
        } else {
            System.out.println("Кот по кличке " + name + " столько не бегает");
        }
    }
    @Override
    public void swim (int distance) {
        System.out.println("Кот по кличке " + name + " вовсе не дебил, чтобы мочить свои пушистые лапки");
    }
    /* или можно было воспользоваться специальным словом super, например
    super.run() и тогда вызовется метод из суперкласса, но нужно было бы универсальнее прописать текст вывода, например,
    System.out.println(name + " проплыл " + distanceSwim + " метров");
     */
}
