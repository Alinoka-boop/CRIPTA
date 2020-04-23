package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.math.BigInteger;

/*
2038074761
2038074769
1299709
154793207506590481   - 5 �������, ���������� �����
 */

public class Main {

    public static BigInteger Function(BigInteger p, BigInteger q) {//������ � �������� �������, ���������� ������� ������

        BigInteger res = (p.subtract(BigInteger.valueOf(1))).multiply(q.subtract(BigInteger.valueOf(1)));
        return res;
    }

    public static BigInteger NOD(BigInteger num1, BigInteger num2) {//������� ���������� ���� ���� �����
        if (num1.compareTo(num2) == 1) {
            while (num2.compareTo(BigInteger.valueOf(0)) == 1) {
                BigInteger ost = num1.mod(num2);
                num1 = num2;
                num2 = ost;
            }
            return num1;
        } else {
            while (num1.compareTo(BigInteger.valueOf(0)) == 1) {
                BigInteger ost = num2.mod(num1);
                num2 = num1;
                num1 = ost;
            }
            return num2;
        }
    }

    static BigInteger[] UV(BigInteger a, BigInteger b) {//����������� ����
        BigInteger res[] = new BigInteger[3];
        if (b == BigInteger.valueOf(0)) {
            res[0] = a; // d
            res[1] = BigInteger.valueOf(1); // u
            res[2] = BigInteger.valueOf(0); // v
            return res;
        }

        res = UV(b, a.mod(b));
        BigInteger s = res[2];
        res[2] = res[1].subtract((a.divide(b)).multiply(res[2])); //  v = u - (a/b) * v
        res[1] = s;
        return res;
    }

    public static BigInteger Stepen(BigInteger num, BigInteger st, BigInteger del) {//���������� � �������
        String str = st.toString(2);

        String strArr[] = str.split("");
        BigInteger bin[] = new BigInteger[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bin[i] = new BigInteger(strArr[i]);
        }

        BigInteger mas[] = new BigInteger[bin.length];

        num = num.mod(del);
        mas[0] = num;

        for (int i = 1; i < bin.length; i++) {
            mas[i] = (mas[i - 1].pow(2)).mod(del);
        }
        BigInteger val = BigInteger.valueOf(1);
        int j = 0;
        while (j < bin.length) {
            for (int i = bin.length - 1; i >= 0; i--) {
                if (Objects.equals(bin[i], BigInteger.valueOf(1))) {
                    val = val.multiply(mas[j]);
                    j++;
                } else {
                    j++;
                }
            }
        }
        return (val.mod(del));
    }


    public static BigInteger Back(BigInteger number, BigInteger m) {//���������� ��������� �������� 
        BigInteger r = BigInteger.valueOf(0);
        if (!Objects.equals(NOD(m, number), BigInteger.valueOf(1))) {
             System.out.println("��� ��������� �������� ��� " + number);
            return BigInteger.valueOf(0);
        } else {
            BigInteger[] ar = UV(m, number);//��������� �������� �� ����������� ����
            r = ar[2];
            return ((r.add(m)).mod(m));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������������ ������ �6. ������������ ��������� � ������� CRT");

        System.out.println("������� ");
        System.out.print("p = ");
        BigInteger p = scanner.nextBigInteger();
        System.out.print("q = ");
        BigInteger q = scanner.nextBigInteger();
        System.out.print("e = ");
        BigInteger e = scanner.nextBigInteger();

        System.out.print("������� ����: ");
        BigInteger h = scanner.nextBigInteger();

        BigInteger m = p.multiply(q);//������������ p � q 
        System.out.println("n = " + m);//����� �� ����� ����������

        BigInteger ah = h.mod(p);//CRT �������������
        BigInteger bh = h.mod(q);//�RT �������������
        System.out.println("ah = " + ah);
        System.out.println("bh = " + bh);


        BigInteger f = Function(p, q);//���������� ������� ������ 
        System.out.println("������� ������ (" + m + ") = " + f);

        BigInteger d = BigInteger.valueOf(1);
        if (Objects.equals(NOD(e, f), BigInteger.valueOf(1))) {
            BigInteger[] arr = UV(f, e);//��������� ������ �� ����������� ���� 
            d = f.add(arr[2]);
            if (Objects.equals((e.multiply(d)).mod(f), (BigInteger.valueOf(1)).mod(f))) {
                System.out.println("��������� ���� d = " + d);//��������� ���������� ����� 
            }
        }

        BigInteger a = Stepen(ah, d, p);//������ �� ��������� 
        System.out.println("a = " + a);
        BigInteger b = Stepen(bh, d, q);
        System.out.println("b = " + b);
        BigInteger c = BigInteger.valueOf(1);
        BigInteger num = Back(q, p);//��������� ��������� �������� 
        System.out.println("�������� ��� q: " + num);
        BigInteger qqq = b.divide(a);
        if (qqq.compareTo(BigInteger.valueOf(0)) == 0) {
            qqq = BigInteger.valueOf(1);
        }
        if (!Objects.equals(num, BigInteger.valueOf(0))) {
            c = ((((a.subtract(b)).add(p.multiply(q))).multiply(num.mod(p))).mod(p)).multiply(q).add(b);//������� ������� 
            System.out.println("�����������: " + c);

        } else {
            System.out.println("��� ��������� ��������. ���������� ������������ ���������.");
        }
        char[] letter = {'�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
                         '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�'};//������� 
        BigInteger s;
        ArrayList list = new ArrayList();
        for (; c.compareTo(BigInteger.valueOf(0)) > 0; c = c.divide(BigInteger.valueOf(100))) {
            s = c.mod(BigInteger.valueOf(100));
            list.add(s.intValue());
        }
        System.out.println(list);//����� � ����� ������

        System.out.println("�������������� ���������: ");
        int count = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            count = (int) list.get(i);
            while(count > 33) {
                count -= 33;
            }
            System.out.print(letter[count-1]);//����������� �����
        }
    }
}
