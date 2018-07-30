package com.apptesting;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class FactorialTest {

    private Factorial factorial = new Factorial();

    @Test
    public void calculateFactorialTestUsingAssertEquals() {
        BigInteger factorialResult = factorial.calculateFactorial(8);
        BigInteger expectedResult = BigInteger.valueOf(40_320);
        assertEquals(expectedResult,factorialResult);
    }

    @Test
    public void calculateFactorialTestUsingHamcrest() {
        BigInteger factorialResult = factorial.calculateFactorial(6);
        BigInteger expectedResult = BigInteger.valueOf(720);
        assertThat("Factorial wrong result",factorialResult,equalTo(expectedResult));
    }

    @Test
    public void calculateFactorialTestUsingAssertJ() {
        BigInteger factorialResult = factorial.calculateFactorial(15);
        BigInteger expected = BigInteger.valueOf(1_307_674_368_000L);
        assertThat(factorialResult).isNotNull().isNotNegative().isEqualTo(expected);
    }

    @Test
    public void calculateFactorialWithSoftAssertions() {
        BigInteger result = factorial.calculateFactorial(15);
        BigInteger expected = BigInteger.valueOf(1_307_674_368_000L);
        BigInteger greaterResult = BigInteger.valueOf(1_500_000_000_000L);
        BigInteger lowerResult = BigInteger.valueOf(500_000_000_000L);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result).as("Greater value").isGreaterThan(greaterResult);
        softly.assertThat(result).as("Lower value").isLessThan(lowerResult);
        softly.assertThat(result).as("Factorial result").isEqualTo(expected);
        softly.assertAll();
    }
}