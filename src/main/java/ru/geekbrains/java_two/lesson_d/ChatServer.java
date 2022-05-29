package ru.geekbrains.java_two.lesson_d;

public class ChatServer { // создали сам сервер
    public void start(int port) { // запуск сервера, стартовать он будет по какому-то порту
        System.out.println("Server started at port " + port);
    }

    public void stop() {
        System.out.println("Server stopped");
    } // остановка сервера
}
