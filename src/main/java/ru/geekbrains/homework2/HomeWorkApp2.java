package ru.geekbrains.homework2;

public class HomeWorkApp2 {
    public static void main(String[] args) {

        System.out.println(checkSumm(5, 6));
        checkNumber(-1);
        System.out.println(trueFalse(5));
        printString("Hi", 3);
        System.out.println(yearLean (-400));


    }

    /* 1. Написать метод, принимающий на вход два целых числа и проверяющий,
    что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false
     */
    public static boolean checkSumm(int a, int b) {

        return a + b >= 10 && a + b <= 20;
    }

        /* 2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
     положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом
      */
    public static void checkNumber(int a) {

        if (a < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    /*3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    если число отрицательное, и вернуть false если положительное
     */

    public static boolean trueFalse(int a) {

        return a < 0;
    }

    /*4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать
    в консоль указанную строку, указанное количество раз
     */

    public static void printString(String d, int y) {
        for (int i = 0; i < y; i++) {
            System.out.println(d);
        }

    }

    /*5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean
    (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го,
    при этом каждый 400-й – високосный.
     */

    public static boolean yearLean (int a) {
        if (a <= 0) {
            return false;
        } else if (a % 400 == 0) {
            return true;
        } else if (a % 100 == 0) {
            return false;
        } else if (a % 4 == 0) {
            return true;
        } else {
            return false;
        }

    }
}






