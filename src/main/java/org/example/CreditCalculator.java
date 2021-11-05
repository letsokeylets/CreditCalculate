package org.example;

/**
 * Кредитный калькултяор
 */
public class CreditCalculator {
    private final int PERSENT_CONST = 1200;

    public double monthPay(int month, int sum, double persent) {
        double monthPersent = persent / PERSENT_CONST;
        double hardСalculations = 1 - (Math.pow(1 + monthPersent, -month));
        double monthPay = sum * (monthPersent / hardСalculations);
        return monthPay;
    }

    public int overpayment(int month, int monthPay, int sumCredit) {
        return (month * monthPay) - sumCredit;
    }

    public int allSummCredit(int sum, int overpayment) {
        return sum + overpayment;
    }
}
