package Alina;

public class Main {

    public static void main(String[] args) {
    	System.out.println("Лабораторная работа № 10 - Григорович Алина");
    	
        System.out.println("Шифр текст в двоичной систему: " + DES.textToBin("Григоров"));
        
        System.out.println("Ключ: " + DES.formKey("Григоро"));
        
        System.out.println("Full ключ: " + DES.formFullKey("Григоро"));
        
        System.out.println("IP: " + DES.IP(DES.textToBin("Григоров")));
        
        System.out.println("Сообщение: " + DES.message("Григоров", "Григоро"));
    }
}
