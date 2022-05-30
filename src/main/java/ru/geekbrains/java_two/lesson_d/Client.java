package ru.geekbrains.java_two.lesson_d;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler { // приложение чата
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea(); // поле с сообщениями

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3)); // верхняя панель
    private final JTextField tfIPAddress = new JTextField("127.0.0.1"); // IP адрес
    private final JTextField tfPort = new JTextField("80"); // с каким портом соединяться
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top"); // галочка, которая будет говорить,
    // находится это окно поверх всех окон или нет
    private final JTextField tfLogin = new JTextField("EVA"); // поле с логином
    private final JPasswordField tfPassword = new JPasswordField("123456"); // поле с паролем
    private final JButton btnLogin = new JButton("Login"); // кнопка соединения с сервером

    private final JPanel panelBottom = new JPanel(new BorderLayout()); // нижняя панель
    private final JButton btnDisconnect = new JButton("Disconnect"); // кнопка разъединения
    private final JTextField tfMessage = new JTextField(); // поле ввода текста
    private final JButton btnSend = new JButton("Send"); // кнопка отправки сообщения
    private final JList<String> userList = new JList<>(); // создаем список пользователей


    private Client() { // конструктор клиента
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //расположение в середине экрана
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");
        log.setEditable(false); // устанавливаем запрет на ввод текста в поле сообщений
        JScrollPane spLog = new JScrollPane(log); // компонент, позволяющий скролить текстовое поле
        JScrollPane spUsers = new JScrollPane(userList); // компонент, позволяющий скролить список пользователей
        String[] users = {"user1", "user2",
                "user3", "user4", "user5", "user6",
                "user7", "user8", "user9",
                "user10_with_a_exceptionally_long_nickname", };
        userList.setListData(users); // у компонента JList нет метода добавления строки (add (String)), поэтому используем метод
        // setListData, который позволяет дабавить массив из строк
        spUsers.setPreferredSize(new Dimension(100, 0)); // устанавливаем предпочтительный размер занимаемого
        // списком юзеров пространства, чтобы очень длинные имена, как например user10 не расширяли окно списка юзеров
        cbAlwaysOnTop.addActionListener(this); // установили листнер на галку
        btnSend.addActionListener(this); // дз 1 - устанавливаем listener на btnSend
        tfMessage.addActionListener(this); // дз 1 - устанавливаем listener на текстовое поле tfMessage

        panelTop.add(tfIPAddress); // добавляем конопки на верхнюю панель
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST); // добавляем кнопки на нижнюю панель
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(panelBottom, BorderLayout.SOUTH); // добавляем верхнюю панель
        add(panelTop, BorderLayout.NORTH); // добавляем нижнюю панель
        add(spLog, BorderLayout.CENTER); // добавляем скролящееся поле log
        add(spUsers, BorderLayout.EAST); // добавляем скролящийся список пользователей

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Client();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cbAlwaysOnTop) { // прописываем условие для галки AlwaysOnTop
            setAlwaysOnTop(cbAlwaysOnTop.isSelected()); // isSelected - специальный метод по нажатию галки
        } else if (src == btnSend || src == tfMessage) { // дз 1 - добавляем условие для кнопки btnSend и поля tfMessage
            if (!tfMessage.getText().equals("")) { // дз 1 - если содержимое поля tfMessage != 0
            log.append(tfLogin.getText()  + ": " + tfMessage.getText() + "\n");// дз 1 - помести текст из поля tfMessage в поле log
            tfMessage.setText(null); // дз 1 - обнули поле tfMessage
        }} else {
            throw new RuntimeException("Action for component unimplemented");
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg = "Exception in thread " + t.getName() +
                " " + e.getClass().getCanonicalName() +
                ": " + e.getMessage() +
                "\n\t" + e.getStackTrace()[0];
        JOptionPane.showMessageDialog(null, msg,
                "Exception", JOptionPane.ERROR_MESSAGE);
    }
}
