/** 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список
уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
 **/

package ru.geekbrains.java_two.lesson_c;

import ru.geekbrains.java_two.lesson_b.Array;

import java.util.*;

public class Fruits {
    static String[] arrFruit = {"Apple", "Orange", "Apple", "Banana", "Melon", "Banana", "Pear","Orange", "Apple",
            "Pineapple", "Melon"};

    public static HashMap<String, Integer> countUniqueFruits (Set<String> e) {
        int counter = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<String> list = new ArrayList<>(e);
        for (int i = 0; i < e.size(); i++) {
            for (int j = 0; j < arrFruit.length; j++) {
                if (list.get(i) == arrFruit[j]) {
                    counter++;
                }
            }
            hm.put(list.get(i), counter);
            counter = 0;
        }
       return hm;// либо, если тип void -> System.out.println(hm);
    }

    public static void main(String[] args) {
//        Set<String> uniqueFruits = new HashSet<>(Arrays.asList(arrFruit));
//        System.out.println(uniqueFruits);
//        System.out.println(countUniqueFruits(uniqueFruits));
        PhoneCatalog book = new PhoneCatalog();
        book.add("Ivanov", "324576", "Ivan");
        book.add("Ivanov", "335643", "Timofey");
        System.out.println("Start");
        book.get("Ivanov");
    }
}
