package ru.job4j.oop;

public class Battery {
    int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load=0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(10);
        Battery another = new Battery(10);
        System.out.println("first : " + first.load + ". another : " + another.load);
        first.exchange(another);
        System.out.println("first : " + first.load + ". another : " + another.load);
    }
}
