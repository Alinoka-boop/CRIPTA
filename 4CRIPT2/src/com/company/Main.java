package com.company;

import java.util.Scanner;

public class Main {
	

    public static int Func(int number) {
        int res = number;
        for (int p = 2; p * p <= number; p++)  //�������� ��� �������� ������� ������, ���������� ������ �������� ��� ����������
            if (number % p == 0) {
                while (number % p == 0)
                    number /= p;
                res -= res / p;
            }
            if (number > 1)
                res -= res / number;

        return res;
    }
    
    public static void Del(int number) {//�������� �����
        int multiplier = 2;
        while(number > 1 && multiplier <= number)
           if(number % multiplier == 0) {
        	  
               System.out.print( multiplier + " " );
               number /= multiplier;
           }
           else {
               multiplier++;
           }
        }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("���� 4. ������� 2. ������� ������");
   

        int n;
        System.out.print("������� ����� n: ");
        n = scanner.nextInt();
        System.out.println();

 
        System.out.println("������� ������ ��� ����� " + n + " = " + Func(n));
        System.out.print("��������:  ");
        Del(n);
 

    }
}
