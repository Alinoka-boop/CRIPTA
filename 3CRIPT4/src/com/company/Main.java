package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/*
1. перевод степени в двоичную систему
2. возводим основание в квадрат и находим мод
продолжаем возводить в квадрат
3. там где 1 в двоичной перемнной, берем те числа и перемножаем
4. находим мод от этого числа это и есть ответ
5. Проверка числа 51,степень 43 делим на 19  
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Лаба 2. Задание 4. Найти остаток от деления числа на простое число.");

        System.out.println("Введите основание: ");
        int x = sc.nextInt();
        System.out.println("Введите степень: ");
        int p = sc.nextInt();
        System.out.println("Введите число, на которое делить: ");
        int m = sc.nextInt();
        System.out.println();
        int  mas3 []  = new int[100];
        int a=0;
        int v=p;
        while (p!=0)
        {
        	if (p % 2==0) 
        	{
        		p=p/2;
                mas3[a]=p;
                a++;
        	}
        	if (p % 2==1) 
        	{
        		p=(p-1)/2;
                mas3[a]=p;
                a++;
        	} 
        }
        for (int k=0; k<a; k++ )
        System.out.print( mas3[k] + " " );
        double mas[] = new double[100];
        double x1 = x%m;
        mas[0] = x1;
        double d=0;
        int b=a-1;
        int c=a-1;
        for (int i = 1; i < b; i++) {
        if (mas3[c]%2==0)
        {	
    	mas[i]=(Math.pow( mas[i-1], 2 )) % m;
    	c--;
        }
        else
        {
        	if (mas3[c]%2==1)
        	{
        	mas[i]=(Math.pow( mas[i-1], 2 )*x) % m;
        	c--;
        }
        }
        }
        if (v %2 ==0)
        {
        d=(Math.pow( mas[b-1], 2 )) % m;
        }
        if (v% 2 == 1)
        	d=(Math.pow( mas[b-1], 2 )*x) % m;
        
        for (int i = 0; i < a-1; i++) 
        	System.out.print( mas[i] + " " ); 
        System.out.print(d );
}
}

