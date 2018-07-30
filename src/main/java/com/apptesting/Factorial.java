package com.apptesting;
import java.math.BigInteger;

class Factorial {
    BigInteger calculateFactorial(int N) {
        BigInteger factorialResult = BigInteger.ONE;
        if (N > 1) {
            for (int i=2; i<=N; i++) {
                factorialResult = factorialResult.multiply(BigInteger.valueOf(i));
            }
        }
        return factorialResult;
    }
}
