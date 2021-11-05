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
        int month = 60;
        int sum = 1_000_000;
        double percent = 10;
        double monthPercent = percent / (100 * 12);
        double monthPay = calculator.monthPay(month, sum, percent);
        double testSum = sum * (monthPercent / (1 - Math.pow(1 + monthPercent, -month)));
        assertTrue("Неверное вычисление ежемесячного платежа! тестовый платёж: "
                        + testSum + " не равен вычесленной: " + monthPay,
                testSum == monthPay);
    }


    /**
     * Тест подсчёта переплаты по кредиту
     */
    @Test
    public void testOverpayment() {
        int month = 48;
        int sum = 1_000_000;
        int monthPay = 18000;
        int overpayment = calculator.overpayment(month, monthPay, sum);
        assertTrue("Неверный расчёт переплаты по кредиту!", month * monthPay - sum == overpayment);
    }


    /**
     * Тест общей суммы к возврату
     */
    @Test
    public void testAllSummCredit() {
        int sum = 2_000_000;
        int overpayment = 700_000;
        int allSum = calculator.allSummCredit(sum, overpayment);
        assertTrue("Неверный расчёт общей суммы к выплате!", sum + overpayment == allSum);
    }
}
