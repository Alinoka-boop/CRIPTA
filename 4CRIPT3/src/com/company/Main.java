package com.company;

import java.util.Scanner;
public class Main {

        public static int gcd(int a, int b) {   //������� ���������� ���� �����, ����� ���������
            while (a != 0 && b != 0) {
                if (a > b) {
                    a %= b;
                } else {
                    b %= a;
                }
            }
           return a+b;
        }
    //�������� ���� ���� ���� �� "b == 0", ����� ���������� ���� ������� �������� ���� ��� ����������� ������ �������
    static int[] InverseBezu(int a, int b) {  //<���� - ����������� �������
        int res[] = new int[3];
        if (b == 0) {
            res[0] = a; // d
            res[1] = 1; // u
            res[2] = 0; // v
            return res;
        }

        res = InverseBezu( b,a % b );
        int s = res[2];
        res[2] = res[1] - (a / b) * res[2];
        res[1] = s;
        return res;
    }
    static int InverseClass(int n, int m) {  //�������
        int z = 0;
        for (int i = 1; i<m;i++)
    		if (modexp((n*i),1,m)==1)//�������� �������
    		{
    			z = i;
    			break;
    		}
        return z;
    	}
    public static int modexp(int a, int b, int n) {//��� ��� � ����� ����������� ����� ���������� � ������� �� ������ ����������� �������
            if (b == 0) return 1;
            long t = modexp(a, b/2, n);  
            long c = (t * t) % n;
            if (b % 2 == 1)
               c = (c * a) % n;
            return (int) c;
        }

    public static void Back (int number, int m) {
        int r = 0;
        if (gcd(m, number) != 1) {//������������ �������� ��� ������� ������
            System.out.println("��� ��������� �������� ���  ( �� ����) " + number);
        }
        else {
            int[] ar = InverseBezu(m, number);
            r = ar[2];

            System.out.println("�������� ������� ��� (�� ����) " + number + " : " + (r + m) % m);//������� �� ����� ��������� 
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("���� 4. ������� 4. �������� �������� � .... � Z/mZ");
        int m,n;
        System.out.print("������� ����� m: ");
        m = scanner.nextInt();
        System.out.println();
        System.out.print("������� ����� n: ");
        n = scanner.nextInt();
        System.out.println();

        Back(n, m);//�� ����
        int r = 0;
        if (gcd(m, n) != 1) {
            System.out.println("��� ��������� �������� ��� (������� �������) " + n);
        }
        else {
        	  int k=0;
              k=InverseClass(n,m);
              System.out.println("�������� ������� ��� (������� �������) " + n + " : " + k);//�������
        }
      
    }
}
