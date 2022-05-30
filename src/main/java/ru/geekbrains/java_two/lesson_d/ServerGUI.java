package ru.geekbrains.java_two.lesson_d;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler { // внешний вид сервера
    // класс Thread отвечает за потоки
    private static final int POS_X = 100; // начальная точка окна по оси Х
    private static final int POS_Y = 100; // начальная точка окна по оси У
    private static final int WIDTH = 200; // ширина окна
    private static final int HEIGHT = 100; // высота окна

    private final ChatServer server = new ChatServer(); // создание чат сервера
    private final JButton btnStart = new JButton("Start"); // создание кнопки с надписью старт
    private final JButton btnStop = new JButton("Stop"); // создание кнопки с надписью стоп

    private ServerGUI() { // создаем конструктов окна ServerGUI
        Thread.setDefaultUncaughtExceptionHandler(this); // устанавливаем обработчик по умолчанию для непойманных исключений
        // и предаем туда себя
        setDefaultCloseOperation(EXIT_ON_CLOSE); // закрытие окна при нажатии на крестик
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT); // установка границ окна
        setResizable(false); // запрет на изменение размеров окна
        setTitle("Chat server"); // заголовок окна
        setAlwaysOnTop(true); // всегда поверх всех окон
        setLayout(new GridLayout(1, 2)); // задаем компоновщик элементов GridLayout, который расставляет
        //элементы по сетке, указываем 1 ряд, 2 колонки
        btnStart.addActionListener(this); // повесили листнер на кнопку старт
        btnStop.addActionListener(this); // повесили листнер на кнопку стоп
        add(btnStart); // добавление элемента btnStart в GridLayout
        add(btnStop); // добавление элемента btnStop в GridLayout
        setVisible(true); // делаем окно видимым
    }

    public static void main(String[] args) {
        System.out.println("main started");
        SwingUtilities.invokeLater(new Runnable() { // есть класс SwingUtilities, внутри него метод invokeLater,
            // он принимает на вход новый Runnable, мы создаем новый объект, который реализует интерфейс Runnable
            @Override
            public void run() {
                new ServerGUI();
            } // переопределяем метод run от интерфейса Runnable, в котором создаем новый ServerGUI
        });
        System.out.println("main ended");
    }

    @Override
    public void actionPerformed(ActionEvent e) { // метод интерфейса ActionListener
        Object src = e.getSource(); // у каждого события записана ссылка на тот компонент, который это событие совершил
        if (src == btnStart) { // если событие совершила кнопка старт
            server.start(80);
//        } else if (src == btnStop) { // если событие совершила конопка стоп
//            server.stop();
        } else {
            throw new RuntimeException("Action for component unimplemented"); // прописыввем исключение на случай,
            // если добавим еще кнопку и забудем ее обработать, чтобы выдалось исключение, которое нам подскажет
            // где и что нужно сделать
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) { // метод интерфейса UncaughtExceptionHandler, которому на вход
        // подается где что-то пошло не так и сама проблема
        e.printStackTrace();
        String msg = "Exception in thread " + t.getName() +
                " " + e.getClass().getCanonicalName() +
                ": " + e.getMessage() +
                "\n\t" + e.getStackTrace()[0];
        JOptionPane.showMessageDialog(null, msg,
                "Exception", JOptionPane.ERROR_MESSAGE); // показать окно с соббщением, null означает, что окно
        // появится в середине экрана, предаем само сообщение, наименование окна, устанавливаем ти сообщения
    }
}
