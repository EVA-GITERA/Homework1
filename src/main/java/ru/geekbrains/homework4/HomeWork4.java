package ru.geekbrains.homework4;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {

    public static final int SIZE = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final int DOTS_TO_WIN = 3;

    public static char[][] game;

    public static void initGame () {
        game = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                game [i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printGame () {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void main(String[] args) {
        initGame();
        printGame();
        humanTurn();
        aiTurn();

    }
    public static Scanner sc = new Scanner(System.in);
    public static void humanTurn () {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid (x, y));
        game [y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (game [y][x] == DOT_EMPTY) {
            return true;

        } return false;
    }
    public static Random rand = new Random();
    public static void aiTurn () {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьтер походил в точку " + (x + 1) + " " + (y + 1));
        game[y][x] = DOT_O;
    }
   /* public static boolean checkWin(char symb) {

    } */


}
