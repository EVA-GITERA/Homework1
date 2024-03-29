/** Необходимо написать два метода, которые делают следующее:

 1) Создают одномерный длинный массив, например:

 static final int size = 10000000;
 static final int h = size / 2;
 float[] arr = new float[size];

 2) Заполняют этот массив единицами;
 3) Засекают время выполнения: long a = System.currentTimeMillis();
 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 5) Проверяется время окончания метода System.currentTimeMillis();
 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 Отличие первого метода от второго:
 Первый просто бежит по массиву и вычисляет значения.
 Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
 Пример деления одного массива на два:

 System.arraycopy(arr, 0, a1, 0, h);
 System.arraycopy(arr, h, a2, 0, h);
 Пример обратной склейки:

 System.arraycopy(a1, 0, arr, 0, h);
 System.arraycopy(a2, 0, arr, h, h);
 Примечание:
 System.arraycopy() – копирует данные из одного массива в другой:
 System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
 По замерам времени:
 Для первого метода надо считать время только на цикл расчета:

 for (int i = 0; i < size; i++) {
 arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 }

 Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.**/

package ru.geekbrains.java_two.lesson_e;

import java.util.Arrays;

public class ArrCounter {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] arr2 = new float[size];
    static float[] a1 = new float[h];
    static float[] a2 = new float[h];

    public static void fillArr(float[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 1;
        }
    }

    public static void intArr(float[] array) {
        fillArr(array);
        //  System.out.println(Arrays.toString(arr));
        long a = System.currentTimeMillis(); // 3. засекаем текущее время
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)); // 4.
        }
       // System.out.println(Arrays.toString(arr));
        System.out.println(System.currentTimeMillis() - a); //6. выводим в консоль разницу текущим временем и временем long a
    }


    public static void intArr2(float[] array) {
        fillArr(array);
        long a = System.currentTimeMillis();
        System.arraycopy(array, 0, a1, 0, h);
        System.arraycopy(array, h, a2, 0, h);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + (h + i) / 5) * Math.cos(0.2f + (h + i) / 5) * Math.cos(0.4f + (h + i) / 2)); // 4.
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, array, 0, h);
        System.arraycopy(a2, 0, array, h, h);
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void main(String[] args) {
        intArr(arr);
        intArr2(arr2);
        System.out.println(Arrays.equals(arr,arr2));
    }
}
