package com.apptesting;

public class Main {

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int n = 100;
        System.out.println("Calculate factorial "+n+"! : "+factorial.calculateFactorial(n));
    }

}
