package org.example;

/**
 * Main class
 */
public class Main
{
    public static void main( String[] args )
    {
        CreditCalculator calculator = new CreditCalculator();
        double monthPay = calculator.monthPay(60, 1_000_000, 10);
        System.out.println("Ежемесячный платёж составит: " + monthPay + " рублей");
    }
}
