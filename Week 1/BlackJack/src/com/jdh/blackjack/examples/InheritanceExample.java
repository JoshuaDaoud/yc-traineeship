package com.jdh.blackjack.examples;

public class InheritanceExample {

    public static void main(String[] args) {
        Apparaat app = new Laptop();
        app.on();

        Laptop lap = new Laptop();
        Apparaat app2 = new Apparaat();
        app2 = (Laptop) lap;
        app2.off();

        if (app2 instanceof Laptop) {

        }
    }

}

class Apparaat {

    public void on() {
        System.out.println("Apparaat gaat aan");
    }

    public void off() {
        System.out.println("Apparaat gaat uit");
    }

}

class Laptop extends Apparaat {

    @Override
    public void on() {
        System.out.println("Laptop gaat aan");
    }

    @Override
    public void off() {
        super.off();
    }
}