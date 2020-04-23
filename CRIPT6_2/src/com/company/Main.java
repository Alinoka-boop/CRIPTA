package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.math.BigInteger;

/*
2038074761
2038074769
1299709
154793207506590481   - 5 Вариант, Григорович Алина
 */

public class Main {

    public static BigInteger Function(BigInteger p, BigInteger q) {//Работа с большими числами, нахождение функции Эйлера

        BigInteger res = (p.subtract(BigInteger.valueOf(1))).multiply(q.subtract(BigInteger.valueOf(1)));
        return res;
    }

    public static BigInteger NOD(BigInteger num1, BigInteger num2) {//Функция нахождения НОДа двух чисел
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

    static BigInteger[] UV(BigInteger a, BigInteger b) {//соотношение Безу
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

    public static BigInteger Stepen(BigInteger num, BigInteger st, BigInteger del) {//возведение в степень
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


    public static BigInteger Back(BigInteger number, BigInteger m) {//нахождение обратного элемента 
        BigInteger r = BigInteger.valueOf(0);
        if (!Objects.equals(NOD(m, number), BigInteger.valueOf(1))) {
             System.out.println("Нет обратного элемента для " + number);
            return BigInteger.valueOf(0);
        } else {
            BigInteger[] ar = UV(m, number);//получение элемента из соотношения Безу
            r = ar[2];
            return ((r.add(m)).mod(m));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Лабораторная работа №6. Расшифровать сообщение с помощью CRT");

        System.out.println("Введите ");
        System.out.print("p = ");
        BigInteger p = scanner.nextBigInteger();
        System.out.print("q = ");
        BigInteger q = scanner.nextBigInteger();
        System.out.print("e = ");
        BigInteger e = scanner.nextBigInteger();

        System.out.print("Введите шифр: ");
        BigInteger h = scanner.nextBigInteger();

        BigInteger m = p.multiply(q);//произведение p и q 
        System.out.println("n = " + m);//вывод на экран результата

        BigInteger ah = h.mod(p);//CRT представление
        BigInteger bh = h.mod(q);//СRT представление
        System.out.println("ah = " + ah);
        System.out.println("bh = " + bh);


        BigInteger f = Function(p, q);//нахождение функции Эйлера 
        System.out.println("Функция Эйлера (" + m + ") = " + f);

        BigInteger d = BigInteger.valueOf(1);
        if (Objects.equals(NOD(e, f), BigInteger.valueOf(1))) {
            BigInteger[] arr = UV(f, e);//получение данных из соотношения Безу 
            d = f.add(arr[2]);
            if (Objects.equals((e.multiply(d)).mod(f), (BigInteger.valueOf(1)).mod(f))) {
                System.out.println("Секретный ключ d = " + d);//получение секретного ключа 
            }
        }

        BigInteger a = Stepen(ah, d, p);//работа со степенями 
        System.out.println("a = " + a);
        BigInteger b = Stepen(bh, d, q);
        System.out.println("b = " + b);
        BigInteger c = BigInteger.valueOf(1);
        BigInteger num = Back(q, p);//получение обратного элемента 
        System.out.println("Обратный для q: " + num);
        BigInteger qqq = b.divide(a);
        if (qqq.compareTo(BigInteger.valueOf(0)) == 0) {
            qqq = BigInteger.valueOf(1);
        }
        if (!Objects.equals(num, BigInteger.valueOf(0))) {
            c = ((((a.subtract(b)).add(p.multiply(q))).multiply(num.mod(p))).mod(p)).multiply(q).add(b);//формула Гарнера 
            System.out.println("Расшифровка: " + c);

        } else {
            System.out.println("Нет обратного элемента. Невозможно расшифровать сообщение.");
        }
        char[] letter = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                         'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};//алфавит 
        BigInteger s;
        ArrayList list = new ArrayList();
        for (; c.compareTo(BigInteger.valueOf(0)) > 0; c = c.divide(BigInteger.valueOf(100))) {
            s = c.mod(BigInteger.valueOf(100));
            list.add(s.intValue());
        }
        System.out.println(list);//вывод в ввиде списка

        System.out.println("Расшифрованное сообщение: ");
        int count = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            count = (int) list.get(i);
            while(count > 33) {
                count -= 33;
            }
            System.out.print(letter[count-1]);//побуквенный вывод
        }
    }
}
