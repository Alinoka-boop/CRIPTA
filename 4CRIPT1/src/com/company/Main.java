package com.company;
import java.util.Scanner;
public class Main {

    public static int[][] Sum(int num) { //������� ���������� ������� �������� 
        int[][] array = new int[num+1][num+1];

        for (int i = 1; i <= num; i++)
            array[i][0] = i - 1;
        for (int j = 1; j <= num; j++)
            array[0][j] = j - 1;

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                array[i][j] = (array[i][0] + array[0][j]) % num;
            }
        }
        return array;
    }

    public static int[][] Mul(int num) { //������� ��� ���������� ������� ��������� 
        int[][] array = new int[num+1][num+1];

        for (int i = 1; i <= num; i++)
            array[i][0] = i - 1;
        for (int j = 1; j <= num; j++)
            array[0][j] = j - 1;

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                array[i][j] = (array[i][0] * array[0][j]) % num;
            }
        }
        return array;
    }

    public static void Output(int[][] mas) {//������� ������ �� ����� ������ 
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                System.out.printf("%4d", mas[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("���� 4. ������� 1. ������� �������� � ���������.");

        System.out.print("������� ����� n: ");
        int n = scanner.nextInt();
        System.out.println();

        System.out.println();
        System.out.println("������� �� �������� ��� n = " + n + ": ");
        Output(Sum(n));

        System.out.println();
        System.out.println("������� �� ��������� ��� n = " + n + ": ");
        Output(Mul(n));
    }
}
