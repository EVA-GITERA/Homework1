package ru.geekbrains.homework5;

/** 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 2. Конструктор класса должен заполнять эти поля при создании объекта.
 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 4. Создать массив из 5 сотрудников.
 Пример:
 Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 persArray[1] = new Person(...);
 ...
 persArray[4] = new Person(...);

 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 **/

public class HomeWork5 {
    public static void main(String[] args) {
        Employee[] emplArray = new Employee[5];
        emplArray[0] = new Employee("Иванов Иван Иванович", "директор", "Ivanov_II@mail.ru", "8 (985) 257 57 57", 100_000, 55);
        emplArray[1] = new Employee("Рудакова Любовь Ивановна", "бухгалтер", "Rudakova_LI@mail.ru", "8 (985) 257 57 58", 60_000, 41);
        emplArray[2] = new Employee("Закишев Сергей Юрьевич", "программист", "Zakishev_SYu@mail.ru", "8 (985) 257 57 59", 100_000, 35);
        emplArray[3] = new Employee("Кудрявцева Светлана Геннадьевна", "менеджер", "Kudryavceva_SG@mail.ru", "8 (985) 257 57 60", 70_000, 37);
        emplArray[4] = new Employee("Жданова Вера Дмитриевна", "товаровед", "Gdanova_VD@mail.ru", "8 (985) 257 57 61", 50_000, 60);


        for (int i = 0; i < emplArray.length; i++) {
            if (emplArray[i].getAge() > 40) {
                emplArray[i].infoEmployee();
            }
        }
    }
}
