package com.practice3.task6;


import java.util.ArrayList;
import java.util.Collections;

public class FoodForGnome {
    private class GnomeFoodComparable implements Comparable{
        int growth;
        int number;

        public GnomeFoodComparable(int growth, int number) {
            this.growth = growth;
            this.number = number;
        }

        public int getGrowth() {
            return growth;
        }

        @Override
        public String toString() {
            return "GnomeFood{" +
                    "growth=" + growth +
                    ", number=" + number +
                    '}';
        }

        public int getNumber() {
            return number;
        }

        public int compareTo(Object o) {
            GnomeFoodComparable tmp = (GnomeFoodComparable) o;
            return this.growth - tmp.getGrowth();
        }
    }
    public int[] find(int[] gnames, int[] portions) {

        ArrayList<GnomeFoodComparable> listGnomes = new ArrayList<>();
        ArrayList<GnomeFoodComparable> listPortions = new ArrayList<>();

        for (int i = 0; i < gnames.length; i++) {
            listGnomes.add(new GnomeFoodComparable(gnames[i], i));
            listPortions.add(new GnomeFoodComparable(portions[i], i));
        }

        Collections.sort(listGnomes);
        Collections.sort(listPortions);

        int[] arrayGnomes = new int[listGnomes.size()];

        for (int i = 0; i < listGnomes.size(); i++) {
            arrayGnomes[listGnomes.get(i).getNumber()] = listPortions.get(i).getNumber();
        }

        return arrayGnomes;
    }

    public static void main(String[] args) {
        FoodForGnome gnomeFood = new FoodForGnome();
        int []mass1 = {5, 7, 6, 9, 4};
        int []mass2 = {8, 5, 6, 2, 3};
        int[]result =gnomeFood.find(mass1,mass2);
        for (int number:result
                ) {
            System.out.print(number + " ");
        }
        System.out.println();

    }
}
