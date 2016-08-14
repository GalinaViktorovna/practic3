package com.practice3.task3;

import java.util.Stack;

public class ReversePolandNotation {
    public static final String[] MATHEMATICAL_OPERATOR = {"+", "-", "*", "/"};

    public static int toCalculate(String exercise) {
        String[] arrayWithExercise = exercise.split(" ");
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arrayWithExercise.length; i++) {
            if (arrayWithExercise[i].matches("-?[\\d]+")) {
                stack.push(Integer.parseInt(arrayWithExercise[i]));
            } else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result = 0;
                String operator = arrayWithExercise[i];
                if (operator.equals(MATHEMATICAL_OPERATOR[0])) result = op1 + op2;
                else if (operator.equals(MATHEMATICAL_OPERATOR[1])) result = op1 - op2;
                else if (operator.equals(MATHEMATICAL_OPERATOR[2])) result = op1 * op2;
                else if (operator.equals(MATHEMATICAL_OPERATOR[3])) result = op1 / op2;
                stack.push(result);
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        String testExercise = "2 5 6 2 + - *";
        System.out.println(ReversePolandNotation.toCalculate(testExercise));
    }
}
