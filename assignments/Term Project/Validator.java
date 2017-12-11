/*
Filename:   Validator.java
Author:     Connor Ness
Date:       December 10, 2017

Validator centralizes the validation of user input into a single class. It
 also centralizes all of user input into a single class, so there's only one
 instance of the Scanner class.

It implements the Acceptable interface, but this is only by requirement of
 the assignment. In fact, the Acceptable interface is only such by technicality.
 The two methods are literally just negations of what previously were single-
 line comparisons or calls to native methods.
 */

import java.util.Scanner;
public class Validator implements Acceptable {

    private static Scanner input = new Scanner(System.in);

    @Override
    public boolean isNonEmptyString(String s) {
        return !s.isEmpty();
    }

    @Override
    public boolean isPositiveInput(double d) {
        return d >= 0;
    }

    //    getStringInput gets input from the console. It makes sure that the
    //            input is not empty, then returns the string.
    public String getStringInput() {
        String text = input.nextLine();
        if(!isNonEmptyString(text)) {
            System.out.println("Please enter non-empty input: ");
            text = getStringInput();
        }
        return text;
    }

    //    getIntInput uses the nextLine and parses into an int, and makes sure
    //            the input is positive.
    public int getIntInput(String msg) {
        int number;
        System.out.println(msg);
        try {
            number = Integer.parseInt(input.nextLine());
        }
        catch (NumberFormatException e) {
            return getIntInput(msg);
        }
        if(!isPositiveInput(number)) {
            System.out.println("Please enter an integer greater than 0!");
            return getIntInput(msg);
        }
        return number;
    }

    //    getDoubleInput does the same as getIntInput, but for doubles
    public double getDoubleInput(String msg) {
        double number;
        System.out.println(msg);
        try {
            number = Double.parseDouble(input.nextLine());
        } catch (NumberFormatException e) {
            return getDoubleInput(msg);
        }
        if(!isPositiveInput(number)) {
            System.out.println("Please enter a number greater than 0!");
            return getDoubleInput(msg);
        }
        return number;
    }
}
