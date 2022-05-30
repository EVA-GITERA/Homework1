/** 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер
 телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 тогда при запросе такой фамилии должны выводиться все телефоны.

 за использование в качестве ключа для Map не фамилии человека будет снижена оценка
 Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще
 дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.).
 Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().
 **/

package ru.geekbrains.java_two.lesson_c;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneCatalog {

    public class UserData {
        String phoneNumber;
//        String email;
        String name;
        public UserData(String phoneNumber, String name) {
            this.phoneNumber = phoneNumber;
            this.name = name;
        }
        public String GetData() {
            return "[" + name + ", " + phoneNumber + "]";
        }
    }

    public HashMap<String, ArrayList<UserData>> phoneBook;

    PhoneCatalog() {
        phoneBook = new HashMap<>();
    }

    public void add(String surname, String phone, String userName) {
        UserData user = new UserData(phone, userName);
        if (phoneBook.get(surname) == null) {
            ArrayList<UserData> data = new ArrayList<>();
            data.add(user);
            phoneBook.put(surname, data);
        } else {
            phoneBook.get(surname).add(user);
        }

    }
    public void get (String surname) {
        if (phoneBook.get(surname) == null) {
            System.out.println("Surname is not found");
        } else {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < phoneBook.get(surname).size(); i++) {
                list.add(phoneBook.get(surname).get(i).GetData());
            }
            System.out.println(surname + list);
        }
    }
}
