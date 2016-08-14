package com.practice3.task2;

public class LongestPeriodOfStability {

    public static int toFindStability(int[] grossDomesticProduct) {
        int maxCounter = 0;
        int counter = 1;
        for (int i = 0; i < grossDomesticProduct.length - 1 - 1; i++) {
            while (Math.abs(grossDomesticProduct[i + 1]) - Math.abs(grossDomesticProduct[i]) <= Math.abs(1)) {
                counter++;
                i++;
            }
            if (counter > maxCounter) {
                maxCounter = counter;
                counter = 1;
            }
        }
        return maxCounter;
    }

    public static void main(String[] args) {
        int[] data = {2, 3, 4, 54, 34, 23, 43, 44};
        int[] data2 = {32, -2, 100, 101, 102, 104, 1, 2, 3, 45, 56, 43};
        System.out.println(LongestPeriodOfStability.toFindStability(data));
        System.out.println(LongestPeriodOfStability.toFindStability(data2));
    }
}
