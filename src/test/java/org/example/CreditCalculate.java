package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Класс тестов для кредитного калькулятора
 */
public class CreditCalculate {
    CreditCalculator calculator = new CreditCalculator();


    /**
     * Тест подсчёта ежемесячного платежа
     */
    @Test
    public void testMonthPay() {
        final int month = 60;
        final int sum = 1_000_000;
        final double percent = 10;
        final double monthPercent = percent / (100 * 12);
        final double monthPay = calculator.monthPay(month, sum, percent);
        final double testSum = sum * (monthPercent / (1 - Math.pow(1 + monthPercent, -month)));
        assertTrue("Неверное вычисление ежемесячного платежа! тестовый платёж: "
                        + testSum + " не равен вычесленной: " + monthPay,
                testSum == monthPay);
    }


    /**
     * Тест подсчёта переплаты по кредиту
     */
    @Test
    public void testOverpayment() {
        final int month = 48;
        final int sum = 1_000_000;
        final int monthPay = 18000;
        final int overpayment = calculator.overpayment(month, monthPay, sum);
        final int testOverpayment = month * monthPay - sum;
        assertTrue("Неверный расчёт переплаты по кредиту! Тестовое значение: "
                        + testOverpayment + " не равняется вычесленному: " + overpayment,
                testOverpayment == overpayment);
    }


    /**
     * Тест общей суммы к возврату
     */
    @Test
    public void testAllSummCredit() {
        final int sum = 2_000_000;
        final int overpayment = 700_000;
        final int allSum = calculator.allSummCredit(sum, overpayment);
        final int testAllSum = sum + overpayment;
        assertTrue("Неверный расчёт общей суммы к выплате! Тестовое значение: "
                        + testAllSum + " не равняется вычесленному: " + allSum,
                testAllSum == allSum);
    }
}
