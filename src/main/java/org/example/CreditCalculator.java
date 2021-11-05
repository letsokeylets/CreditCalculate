package org.example;

/**
 * Кредитный калькултяор
 */
public class CreditCalculator {
    //Необходима для подсчёта месячного процента
    private final int PERSENT_CONST = 1200;


    /**
     * Метод для подсчёта ежемесячного платежа
     * month - кол-во месяцев кредитования
     * sum - Сумма кредита
     * persent - процентная ставка кредита
     */
    public double monthPay(int month, int sum, double persent) {
        final double monthPersent = persent / PERSENT_CONST;
        final double hardСalculations = 1 - (Math.pow(1 + monthPersent, -month));
        return sum * (monthPersent / hardСalculations);
    }

    /**
     * Метод для подсчёта переплаты пок редиту
     * month - кол-во месяцев кредитования
     * sumCredit - Сумма кредита
     * monthPay - Ежемесячный платёж
     */
    public int overpayment(int month, int monthPay, int sumCredit) {
        return (month * monthPay) - sumCredit;
    }

    /**
     * Метод для подсчёта общей суммы выплаты
     * sum - Сумма кредита
     * overpayment - Сумма переплаты
     */
    public int allSummCredit(int sum, int overpayment) {
        return sum + overpayment;
    }
}
