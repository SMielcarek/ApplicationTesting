package com.apptesting;

import junitparams.*;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.math.BigInteger;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class JUnitParamsFactorialTest {

    private Factorial factorial = new Factorial();

    @Test
    @Parameters
    @TestCaseName("JUnitParams {index}: Assert that {0}! = {1}")
    public void calculateFactorialTestWithJUnitParams(int N, BigInteger expectedResult) {
        BigInteger factorialResult = factorial.calculateFactorial(N);
        assertThat(factorialResult).isEqualTo(expectedResult);
    }

    private List<Object[]> parametersForCalculateFactorialTestWithJUnitParams() {
        return Arrays.asList(new Object[][] {
                {1,BigInteger.ONE},
                {5,BigInteger.valueOf(120)},
                {6,BigInteger.valueOf(720)},
                {10,BigInteger.valueOf(3_628_800)}
            }
        );
    }

}
