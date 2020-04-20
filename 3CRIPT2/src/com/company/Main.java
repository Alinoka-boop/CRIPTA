package com.company;

import java.util.Scanner;
import java.util.Vector;

/*
 9118515943
 3386496689
    */
public class Main {

    public static Vector Del(long number) {
        Vector res = new Vector();
        int multiplier = 2;
        while (number > 1 && multiplier <= number)
                if (number % multiplier == 0) {
                    res.addElement(multiplier);
                    number /= multiplier;
                } else {
                    multiplier++;
                }
            return res;
    }

    //алгоритм евклида
    public static void gcd(long a, long b) {   //делим одно на второе, находим остаток от деления, потом повторяем
        while (a != 0 && b != 0) {
            if (a > b) {
                System.out.print("\n " + a + " = ");
                long f = (a- (a%b)) / b;
                System.out.print( b + " * " + f);

                a %= b;
                System.out.print( " + " + a%b);

            } else {
                System.out.print("\n" + b + " = ");
                long f = (b- (b%a)) / a;
                System.out.print( a + " * " + f);

                b %= a;
                System.out.print( " + " + b%a);

            }
        }
        System.out.println(a+b);   //потому что одна переменая равно нулю
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        System.out.println( "Лаба 2. Задание 2. Найти НОД(а, b):" );

        System.out.println( "Введите а: " );
        long a = sc.nextLong();
        System.out.println( "Введите b: " );
        long b = sc.nextLong();
        System.out.println();
        System.out.println( "a) Алгоритм Евклида" );
        System.out.print( "НОД(" + a + "," + b + ") = " );
        gcd( a, b );

        System.out.println();
        System.out.println( "б) Разложением чисел на простые множители" );
        System.out.print( a + " = " );
        Vector mas = Del( a );

        for (int i = 0; i < mas.size(); i++) {
            System.out.print(mas.get(i) + " ");
        }

        System.out.println();

        System.out.print( b + " = " );
        Vector mas2 = Del( b );

        for (int i = 0; i < mas2.size(); i++)
            System.out.print( mas2.get(i) + " " );

        System.out.println();
        int num = 1;

        for (int i = 0; i < mas.size(); i++) {
            for (int j = 0; j < mas2.size(); j++) {
                if (mas.get(i)==(mas2.get(j))) {
                    num *= (int)mas2.get(j);
                    mas2.remove(j);
                    mas.remove(i);
                    i=0;
                    j=0;
                }
            }
        }

        System.out.print("НОД(" + a + "," + b + ") = ");
        System.out.print(num);
    }
}
