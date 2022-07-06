package ru.ac.uniyar.mf.makhno;
import java.util.Scanner;

class fraction{
    int _numerator;
    int _denominator;

    static int find_CSD(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    fraction(int numerator, int denominator){
        this._numerator = numerator;
        if (denominator == 0)
            System.out.println("Нельзя");
        this._denominator = denominator;
    }

    public static fraction sum(fraction a, fraction b) {
        int cDenominator = a._denominator * b._denominator;
        int cNumerator = a._numerator * b._denominator + a._denominator * b._numerator;
        int nok = find_CSD(cNumerator, cDenominator);
        fraction c = new fraction(cNumerator / nok, cDenominator / nok);
        return c;
    }

    public static fraction minus(fraction a, fraction b) {
        int cDenominator = a._denominator * b._denominator;
        int cNumerator = a._numerator * b._denominator - a._denominator * b._numerator;
        int nok = find_CSD(cNumerator, cDenominator);
        fraction c = new fraction(cNumerator / nok, cDenominator / nok);
        return c;
    }

    public static fraction div(fraction a, fraction b) {
        int cDenominator = a._denominator * b._numerator;
        int cNumerator = a._numerator * b._denominator;
        int nok = find_CSD(cNumerator, cDenominator);
        fraction c = new fraction(cNumerator / nok, cDenominator / nok);
        return c;
    }

    public static fraction multiply(fraction a, fraction b) {
        int cDenominator = a._denominator * b._denominator;
        int cNumerator = a._numerator * b._numerator;
        int nok = find_CSD(cNumerator, cDenominator);
        fraction c = new fraction(cNumerator / nok, cDenominator / nok);
        return c;
    }

    public void showfrac() {
        if (_numerator % _denominator == 0)
            System.out.println(this._numerator / this._denominator);
        else
            System.out.println(this._numerator + "/" + this._denominator);
    }

}
public class Main {

    static int find_CSD(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("Выберите калькулятор:");
        Scanner in = new Scanner(System.in);
        int _case = in.nextInt();
        switch(_case) {
            case 1:
            int num_1 = in.nextInt();
            String symb = in.next();
            int num_2 = in.nextInt();
            switch (symb) {
                case "+":
                    System.out.println(num_1 + num_2);
                    break;
                case "-":
                    System.out.println(num_1 - num_2);
                    break;
                case "*":
                    System.out.println(num_1 * num_2);
                    break;
                case "/":
                    if (num_2 == 0) {
                        System.out.println("Нет решений");
                        break;
                    } else
                        System.out.println(num_1 / num_2);
                    break;
            }
            case 2:
            int num1 = in.nextInt();
            String symb1 = in.next();
            int num2 = in.nextInt();
            fraction frac_1 = new fraction(num1, num2);
            String symb3 = in.next();
            int num_3 = in.nextInt();
            String symb2 = in.next();
            int num_4 = in.nextInt();
            fraction frac_2 = new fraction(num_3, num_4);
            switch (symb3) {
                case "+":
                    fraction new_frac = frac_1.sum(frac_1, frac_2);
                    new_frac.showfrac();
                    break;
                case "-":
                    fraction new_frac_2 = frac_1.minus(frac_1, frac_2);
                    new_frac_2.showfrac();
                    break;
                case "*":
                    fraction new_frac_3 = frac_1.multiply(frac_1, frac_2);
                    new_frac_3.showfrac();
                    break;
                case "/":
                    fraction new_frac_4 = frac_1.div(frac_1, frac_2);
                    new_frac_4.showfrac();
                    break;
            }
        }
    }
}
