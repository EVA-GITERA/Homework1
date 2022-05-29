package ru.geekbrains.HomeWork3;

import java.util.Arrays;

public class HomeWork3 {
    public static void main(String[] args) {
        intMas();
        intMas2();
        intMas3();
        intMas4();
        System.out.println(Arrays.toString(intMas5(5,7)));
        intMas6();



    }

    /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0
     */

    public static void intMas () {
        int[] arr = { 0, 0, 1, 1, 0, 0 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    /* 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8... 100
     */

    public static void intMas2 () {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            }
        System.out.println(Arrays.toString(arr));
    }

    /* 3. Задать массив [1,5,3,2,11,4,5,2,4,8,9,1] пройти по нему циклом и числа меньше 6 умножить на 2
    */

    public static void intMas3 () {
        int[] arr = { 1,5,3,2,11,4,5,2,4,8,9,1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /* 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
    цикла (-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
    Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0],
    [1][1], [2][2], ... [n][n]
     */

    public static void intMas4 () {
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            for ( int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
                if (i + j == arr.length - 1) {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j< arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* 5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
    типа int длиной len, каждая ячейка которого равна intialValue
     */

    public static int[] intMas5 (int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    /* 6. *Задать одномерный массив и найтив нем минимальный и максимальный элементы
     */

    public static void intMas6 () {
        int[] arr = {1,5,10,12,6,21};
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("Минимальное число: " + min );
        System.out.println("Максимальное число: " + max );
    }

    /* 7. **Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны.
     */



}
