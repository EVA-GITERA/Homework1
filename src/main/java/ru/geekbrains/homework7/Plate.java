package ru.geekbrains.homework7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        if(n <= food) {
            food -= n;
        }
    }

    public void increaseFood(int a) {
        food += a;
        System.out.println("Количество еды в тарелке :" + food);
    }

    public int getFood() {
        return food;
    }
}
