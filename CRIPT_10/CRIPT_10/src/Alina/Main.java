package Alina;

public class Main {

    public static void main(String[] args) {
    	System.out.println("������������ ������ � 10 - ���������� �����");
    	
        System.out.println("���� ����� � �������� �������: " + DES.textToBin("��������"));
        
        System.out.println("����: " + DES.formKey("�������"));
        
        System.out.println("Full ����: " + DES.formFullKey("�������"));
        
        System.out.println("IP: " + DES.IP(DES.textToBin("��������")));
        
        System.out.println("���������: " + DES.message("��������", "�������"));
    }
}
