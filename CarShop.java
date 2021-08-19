package ru.netology;
import java.util.*;

public class CarShop {
    private List<Car> carList = new ArrayList<>();
    final long CARACCEPTTIME = 2000;
    final long WAITINGCARTIME = 1000;

    public List<Car> getCarList() {
        return carList;
    }

    public void receiveCar() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s собирает новый автомобиль\n", Thread.currentThread().getName());
                Thread.sleep(CARACCEPTTIME);
                System.out.println("Машина поступила в салон");
                synchronized (this) {
                    getCarList().add(new Car());
                    notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sellCar() {
        try {
            System.out.printf("%s зашёл в автосалон\n", Thread.currentThread().getName());
            synchronized (this) {
                while (carList.size() == 0) {
                    System.out.println("Машин нет");
                    wait();
                }
            }
            Thread.sleep(WAITINGCARTIME);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            getCarList().remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}