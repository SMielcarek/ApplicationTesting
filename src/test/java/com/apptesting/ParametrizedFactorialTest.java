package com.apptesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.math.BigInteger;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

@RunWith(value = Parameterized.class)
public class ParametrizedFactorialTest {

    private Factorial factorial = new Factorial();
    private int N;
    private BigInteger expectedResult;

    public ParametrizedFactorialTest(int N, BigInteger expectedResult) {
        this.N = N;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "{index}: Assert that {0}! = {1}")
    public static List<Object[]> factorialParameters() {
        return Arrays.asList(new Object[][] {
                {1,BigInteger.ONE},
                {5,BigInteger.valueOf(120)},
                {6,BigInteger.valueOf(720)},
                {10,BigInteger.valueOf(3_628_800)}
            }
        );
    }

    @Test
    public void calculateFactorialTestWithParameters() {
        BigInteger factorialResult = factorial.calculateFactorial(N);
        assertThat(factorialResult).isEqualTo(expectedResult);
    }
}
