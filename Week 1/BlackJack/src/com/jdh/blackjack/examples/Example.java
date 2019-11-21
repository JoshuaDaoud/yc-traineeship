package com.jdh.blackjack.examples;

import java.util.ArrayList;

public class Example {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        Berekening x = (i, j) -> i.add(j);
        Berekening y = (i, j) -> i.add(j);
        Berekening z = (i, j) -> i.add(j);

        new Uitkomst().uitkomst(x, list, 5);
        new Uitkomst().uitkomst(x, list, 8);
        new Uitkomst().uitkomst(x, list, 13);

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

class Uitkomst {

    public void uitkomst(Berekening berekening, ArrayList<Integer> a, int b) {
        berekening.calculate(a, b);
    }
}

@FunctionalInterface
interface Berekening {

    void calculate(ArrayList<Integer> total, int age);

}