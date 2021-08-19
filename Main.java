package ru.netology;

public class Main {
    public static void main(String[] args) {
        final CarShop carShop = new CarShop();
        new Thread(carShop::sellCar, "Покупатель 1").start();
        new Thread(carShop::sellCar, "Покупатель 2").start();
        new Thread(carShop::sellCar, "Покупатель 3").start();
        new Thread(carShop::sellCar, "Покупатель 4").start();
        new Thread(carShop::receiveCar, "Производитель").start();
    }
}