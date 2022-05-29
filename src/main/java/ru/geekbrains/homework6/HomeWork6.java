package ru.geekbrains.homework6;

/** 1. Создать классы Собака и Кот с наследованием от класса Животное.
 2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
 Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание:
 кот не умеет плавать, собака 10 м.).
 4. * Добавить подсчет созданных котов, собак и животных.
 **/

public class HomeWork6 {
    public static void main(String[] args) {
        Cat catFirst = new Cat("Сидр");
        Cat catSecond = new Cat("Василий");
        Cat catThird = new Cat("Чешир");
        Dog dogFirst = new Dog("Палкан");
        Dog dogSecond = new Dog("Сэм");
        Dog dogThird = new Dog("Арчи");
        Animal animalFirst = new Animal("Батат");
        Animal animalSecond = new Animal("Пятнышко");

        catFirst.run(25);
        catSecond.run(500);
        catThird.swim(50);
        catThird.run(0);
        dogFirst.run(200);
        dogSecond.run(0);
        dogThird.run(1000);
        dogFirst.swim(-5);
        dogSecond.swim(8);
        dogThird.swim(50);
        animalFirst.run(1000);
        animalSecond.swim(500);
        System.out.println("Котов: " + Cat.count);
        System.out.println("Собак: " + Dog.count);
        System.out.println("Остальных животных: " + (Animal.count - Cat.count - Dog.count));
        System.out.println("Всего животных: " + Animal.count);
    }
}
