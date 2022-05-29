package ru.geekbrains.homework5;



public class Employee {
    private final String fullName;
    private final String position;
    private final String email;
    private final String phone;
    private final int salary;
    private final int age;

    public Employee (String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void infoEmployee() {
        System.out.printf("ФИО: %s, должность: %s, email: %s, тел: %s, Зарплата: %s, возраст: %s\n", fullName, position, email, phone, salary, age);
    }

    public int getAge() {
        return age;
    }

}



