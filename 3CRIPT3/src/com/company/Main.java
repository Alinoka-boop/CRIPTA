package com.company;

import java.util.Scanner;

/*
9118515943
3386496689
   */
//вызывает сама себя пока не "b == 0", тогда определены коэф которые являются коэф для предыдущего вызова функции
public class Main {
    static long[] GcdExtended(long a, long b) {
        long res[] = new long[3]; // d, u, v
        if (b == 0) {
            res[0] = a;
            res[1] = 1;
            res[2] = 0;
            return res;
        }

        res = GcdExtended( b, a % b );
        long s = res[2];
        res[2] = res[1] - (a / b) * res[2]; //  v = u - (a/b) * v
        res[1] = s;
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Лаба 2. Задание 2. Найти НОД(а, b):");

        System.out.println("Введите а: ");
        long a = sc.nextLong();
        System.out.println("Введите b: ");
        long b = sc.nextLong();
        System.out.println();

        long res[] = GcdExtended( a, b );
        System.out.println( "НОД(a,b) = " + res[0] );
        System.out.println( "u = " + res[1] );
        System.out.println( "v = " + res[2] );
    }
}

