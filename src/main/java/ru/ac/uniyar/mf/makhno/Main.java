package ru.ac.uniyar.mf.makhno;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;
import java.util.ArrayList;

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
        this._denominator = denominator;
    }

    fraction(int num){
        this._numerator = num;
        this._denominator = 1;
    }

    void set_numerator(int num){
        this._numerator = num;
    }

    void set_denominator(int num){
        this._denominator = num;
    }

    public fraction sum(fraction b) {
        int cDenominator = this._denominator * b._denominator;
        int cNumerator = this._numerator * b._denominator + this._denominator * b._numerator;
        int nok = find_CSD(cNumerator, cDenominator);
        fraction c = new fraction(cNumerator / nok, cDenominator / nok);
        return c;
    }

    public fraction minus(fraction b) {
        int cDenominator = this._denominator * b._denominator;
        int cNumerator = this._numerator * b._denominator - this._denominator * b._numerator;
        int nok = find_CSD(cNumerator, cDenominator);
        fraction c = new fraction(cNumerator / nok, cDenominator / nok);
        return c;
    }

    public fraction div(fraction b) {
        int cDenominator = this._denominator * b._numerator;
        int cNumerator = this._numerator * b._denominator;
        int nok = find_CSD(cNumerator, cDenominator);
        fraction c = new fraction(cNumerator / nok, cDenominator / nok);
        return c;
    }

    public fraction multiply(fraction b) {
        int cDenominator = this._denominator * b._denominator;
        int cNumerator = this._numerator * b._numerator;
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

    public String frac2str(){
        return String.valueOf(_numerator + "/" + _denominator);
    }

}
public class Main {

    static void check_parts(String[] parts, fraction frac_1){
        int num_2;
        if (parts.length == 2) {
            num_2 = Integer.parseInt(parts[1]);
            frac_1.set_denominator(num_2);
        }
    }

    public static void main(String[] args) {
        ArrayList<fraction> arr = new ArrayList<fraction>();
        Scanner in = new Scanner(System.in);
        int num_1 = 1;
        int num_2 = 1;
        String frac = in.next();
        String[] parts = frac.split("/");
        parts = frac.split("/");
        int num_3 = Integer.parseInt(parts[0]);
        fraction frac_1 = new fraction(num_3);
        check_parts(parts, frac_1);
        arr.add(frac_1);
        String symb3 = in.next();
        frac = in.next();
        String[] parts2 = frac.split("/");
        int num_4 = Integer.parseInt(parts2[0]);
        fraction frac_2 = new fraction(num_4);
        check_parts(parts2, frac_2);
        arr.add(frac_2);
        if (num_1 == 0 || num_2 == 0) {
            System.out.println("Нет решений");
            return;
        }
        switch (symb3) {
            case "+":
                fraction new_frac = frac_1.sum(frac_2);
                new_frac.showfrac();
                break;
            case "-":
                fraction new_frac_2 = frac_1.minus(frac_2);
                new_frac_2.showfrac();
                break;
            case "*":
                fraction new_frac_3 = frac_1.multiply(frac_2);
                new_frac_3.showfrac();
                break;
            case "/":
                fraction new_frac_4 = frac_1.div(frac_2);
                new_frac_4.showfrac();
                break;
        }
        System.out.println(arr.size());
        if (arr.contains(0)) {
            System.out.println("ArrayList contains 0/");
        } else
            System.out.println("ArrayList isn't contains 0");
    }

    public static String calculate(int num, String s, String s1, String s2) {
        int _case = num;
        switch (_case) {
            case 1:
                int num_1 = Integer.parseInt(s);
                String symb = s1;
                int num_2 = Integer.parseInt(s2);
                switch (symb) {
                    case "+":
                        return String.valueOf(num_1 + num_2);
                    case "-":
                        return String.valueOf(num_1 - num_2);
                    case "*":
                        return String.valueOf(num_1 * num_2);
                    case "/":
                        if (num_2 == 0) {
                            return "Деление на 0";
                        } else
                            return String.valueOf(num_1 / num_2);
                }
            case 2:
                String[] parts = s.split("/");
                int num1 = Integer.parseInt(parts[0]);
                int num2 = Integer.parseInt(parts[1]);
                fraction frac_1 = new fraction(num1, num2);
                String symb3 = s1;
                String[] parts2 = s2.split("/");
                int num_3 = Integer.parseInt(parts2[0]);
                int num_4 = Integer.parseInt(parts2[1]);
                fraction frac_2 = new fraction(num_3, num_4);
                if (num_4 == 0 || num2 == 0){
                    return "Нет решений";
                }
                switch (symb3) {
                    case "+":
                        fraction new_frac = frac_1.sum(frac_2);
                        return new_frac.frac2str();
                    case "-":
                        fraction new_frac_2 = frac_1.minus(frac_2);
                        return new_frac_2.frac2str();
                    case "*":
                        fraction new_frac_3 = frac_1.multiply(frac_2);
                        return new_frac_3.frac2str();
                    case "/":
                        fraction new_frac_4 = frac_1.div(frac_2);
                        return new_frac_4.frac2str();
                }
        }
        return "0";
    }
}
