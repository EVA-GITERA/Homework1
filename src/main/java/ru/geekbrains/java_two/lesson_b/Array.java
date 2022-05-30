/** 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива
 другого размера необходимо бросить исключение MyArraySizeException.
* 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
* 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
 и вывести результат расчета.
* 4. (не обязательно, на смекалку) Заменить обработчик нажатия кнопок мыши в MainCircles на MouseListener и
 изменить класс таким образом, чтобы ДОБАВЛЕНИЕ обработчика было описано в одну строку. **/

package ru.geekbrains.java_two.lesson_b;

public class Array {
    private static class MyArraySizeException extends RuntimeException {
        MyArraySizeException(String s) {
            super(s);
        }
    }
    private static class MyArrayDataException extends RuntimeException {
        int i;
        int j;
        MyArrayDataException(String s, int i, int j) {
            super(s);
            this.i = i;
            this.j = j;
        }
    }

    public static int getArrString(String[][] arrString) {
        if (arrString.length != 4 || arrString[0].length != 4 || arrString[1].length != 4
                || arrString[2].length != 4 || arrString[3].length != 4) {
            throw new MyArraySizeException("массив должен быть 4х4");
        }
        int summ = 0;
        for (int i = 0; i < arrString.length; i++) {
            for (int j = 0; j < arrString[i].length; j++) {
               try {
                   summ += Integer.parseInt(arrString[i][j]);
               } catch (NumberFormatException e) {
                   throw new MyArrayDataException("в ячейке [" + i + "][" + j + "] должно содержаться число", i, j);
               }
            }
        }
        return summ;
    }

    public static void main(String[] args) {
        String[][] array = { {"1", "1", "l", "1"}, { "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"} };
        try {
            System.out.println(getArrString(array));
        } catch (MyArraySizeException e) {
            System.out.println("массив должен быть 4х4");
        } catch (MyArrayDataException e) {
            System.out.println("в ячейке [" + e.i + "][" + e.j + "] должно содержаться число");
        }

    }
}
