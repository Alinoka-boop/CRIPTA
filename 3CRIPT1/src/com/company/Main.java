package com.company;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.Scanner;
import java.io.FileReader;

/*
16254559
1029073
*/
public class Main {

    public static void Del(long number) {
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


    public static void main(String[] args) throws IOException {
        Reader read = new FileReader("D:\\a.txt");
        BufferedReader bufReader = new BufferedReader(read);
        String line = bufReader.readLine();
        long var;
        var = Long.parseLong(line);
        System.out.println("���� 2. ������� 1. ������������ ���������� ����� � � b.");
        System.out.println("---���������---");
        System.out.print(var + " = ");
        Del(var);
        System.out.println();
        Reader read1 = new FileReader("D:\\b.txt");
        BufferedReader bufReader1 = new BufferedReader(read1);
        String line1 = bufReader1.readLine();
        long var1;
        var1 = Long.parseLong(line1);
        System.out.println("---���������---");
        System.out.print(var1 + " = ");
        Del(var1);

    }
}
