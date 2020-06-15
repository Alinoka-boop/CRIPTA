package Alina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class DES {

    static int toWin1251(char symbol){//ÏÅÐÅÂÎÄ Â ÊÎÄÈÐÎÂÊÓ WINDOWS-1251
        if(symbol >= 'À' && symbol <= 'ß')
            return (symbol % 1040) + 192;
        else
        if(symbol >= 'à' && symbol <= 'ÿ')
            return (symbol % 1072) + 224;
        else
            return -1;
    }

    static String textToBin(String text){//ÏÅÐÅÂÎÄ Â ÄÂÎÈ×ÍÓÞ ÑÈÑÒÅÌÓ Ñ×ÈÑËÅÍÈß ØÈÔÐÀ
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < text.length(); i++){
            int code = toWin1251(text.charAt(i));
            String buf = Integer.toBinaryString(code);
            while(buf.length() < 8){
                buf = "0" + buf;
            }
            result.append(buf);
        }
        return result.toString();
    }

    static String formKey(String text){//ÏÅÐÅÂÎÄ Â ÄÂÎÈ×ÍÓÞ ÑÈÑÒÅÌÓ ÊËÞ×À 
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < text.length(); i++){
            int code = toWin1251(text.charAt(i));
            String buf = Integer.toBinaryString(code);
            while(buf.length() < 8){
                buf = "0" + buf;
            }
            result.append(buf);
        }
        return result.toString();
    }

    static String formFullKey(String text){
        StringBuilder result = new StringBuilder();
        text = formKey(text);
        String[] seven = split(text, 7);

        for(int i = 0; i < seven.length; i++){
            char[] sevenChar = seven[i].toCharArray();
            char check = mod2Sum(sevenChar);
            result.append(seven[i]).append(check);
        }
        return result.toString();
    }

    static char mod2(char bit1, char bit2){
        if(new Character(bit1).equals(bit2))
            return '0';
        else
            return '1';
    }

    static char mod2Sum(char[] bits){
        char sum = bits[0];
        for(int i = 0; i < bits.length - 1; i++)
            sum = mod2(sum, bits[i + 1]);
        return sum;
    }

    static String[] split(String text, int size){
        int n = text.length() / size;
        String[] result = new String[n];
        for(int i = 0; i < n; i++){
            result[i] = text.substring(i * size, i * size + size);
        }
        return result;
    }

    //íà÷àëüíàÿ ïåðåñòàíîâêà ip
    static String IP(String text){
        StringBuilder result = new StringBuilder(text);

        HashMap<Integer, Integer> swap = new HashMap<Integer, Integer>();
        swap.put(0,  58);
        swap.put(1,  50);
        swap.put(2,  42);
        swap.put(3,  34);
        swap.put(4,  26);
        swap.put(5,  18);
        swap.put(6,  10);
        swap.put(7,  2);
        swap.put(8,  60);
        swap.put(9,  52);
        swap.put(10, 44);
        swap.put(11, 36);
        swap.put(12, 28);
        swap.put(13, 20);
        swap.put(14, 12);
        swap.put(15, 4);
        swap.put(16, 62);
        swap.put(17, 54);
        swap.put(18, 46);
        swap.put(19, 38);
        swap.put(20, 30);
        swap.put(21, 22);
        swap.put(22, 16);
        swap.put(23, 8);
        swap.put(24, 64);
        swap.put(25, 56);
        swap.put(26, 48);
        swap.put(27, 40);
        swap.put(28, 32);
        swap.put(29, 24);
        swap.put(30, 16);
        swap.put(31, 8);
        swap.put(32, 57);
        swap.put(33, 49);
        swap.put(34, 41);
        swap.put(35, 33);
        swap.put(36, 25);
        swap.put(37, 17);
        swap.put(38, 9);
        swap.put(39, 1);
        swap.put(40, 59);
        swap.put(41, 51);
        swap.put(42, 43);
        swap.put(43, 35);
        swap.put(44, 27);
        swap.put(45, 19);
        swap.put(46, 11);
        swap.put(47, 3);
        swap.put(48, 61);
        swap.put(49, 53);
        swap.put(50, 45);
        swap.put(51, 37);
        swap.put(52, 29);
        swap.put(53, 21);
        swap.put(54, 13);
        swap.put(55, 5);
        swap.put(56, 63);
        swap.put(57, 55);
        swap.put(58, 47);
        swap.put(59, 39);
        swap.put(60, 31);
        swap.put(61, 23);
        swap.put(62, 15);
        swap.put(63, 7);

        for(int i = 0; i < result.length(); i++)
            result.setCharAt(i, text.charAt(swap.get(i) - 1));
        return result.toString();
    }

    //êîíå÷íàÿ ïåðåñòàíîâêà ip^(-1)
    static String minusIP(String text){
        StringBuilder result = new StringBuilder(text);
        HashMap<Integer, Integer> swap = new HashMap<Integer, Integer>();
        swap.put(0,  40);
        swap.put(1,  8);
        swap.put(2,  48);
        swap.put(3,  16);
        swap.put(4,  56);
        swap.put(5,  24);
        swap.put(6,  64);
        swap.put(7,  32);
        swap.put(8,  39);
        swap.put(9,  7);
        swap.put(10, 47);
        swap.put(11, 15);
        swap.put(12, 55);
        swap.put(13, 23);
        swap.put(14, 63);
        swap.put(15, 31);
        swap.put(16, 38);
        swap.put(17, 6);
        swap.put(18, 46);
        swap.put(19, 14);
        swap.put(20, 54);
        swap.put(21, 22);
        swap.put(22, 62);
        swap.put(23, 30);
        swap.put(24, 37);
        swap.put(25, 5);
        swap.put(26, 45);
        swap.put(27, 13);
        swap.put(28, 53);
        swap.put(29, 21);
        swap.put(30, 61);
        swap.put(31, 29);
        swap.put(32, 36);
        swap.put(33, 4);
        swap.put(34, 44);
        swap.put(35, 12);
        swap.put(36, 52);
        swap.put(37, 20);
        swap.put(38, 60);
        swap.put(39, 28);
        swap.put(40, 35);
        swap.put(41, 3);
        swap.put(42, 43);
        swap.put(43, 11);
        swap.put(44, 51);
        swap.put(45, 19);
        swap.put(46, 59);
        swap.put(47, 27);
        swap.put(48, 34);
        swap.put(49, 2);
        swap.put(50, 42);
        swap.put(51, 10);
        swap.put(52, 50);
        swap.put(53, 18);
        swap.put(54, 58);
        swap.put(55, 26);
        swap.put(56, 33);
        swap.put(57, 1);
        swap.put(58, 41);
        swap.put(59, 9);
        swap.put(60, 49);
        swap.put(61, 17);
        swap.put(62, 57);
        swap.put(63, 25);

        for(int i = 0; i < result.length(); i++)
            result.setCharAt(i, text.charAt(swap.get(i) - 1));
        return result.toString();
    }

    //ïåðåñòàíîâêà pc1
    static String PC1(String key){
        StringBuilder result = new StringBuilder(key);

        HashMap<Integer, Integer> swap = new HashMap<Integer, Integer>();
        swap.put(0,  57);
        swap.put(1,  49);
        swap.put(2,  41);
        swap.put(3,  33);
        swap.put(4,  25);
        swap.put(5,  17);
        swap.put(6,  9);
        swap.put(7,  1);
        swap.put(8,  58);
        swap.put(9,  50);
        swap.put(10, 42);
        swap.put(11, 34);
        swap.put(12, 26);
        swap.put(13, 18);
        swap.put(14, 10);
        swap.put(15, 2);
        swap.put(16, 59);
        swap.put(17, 51);
        swap.put(18, 43);
        swap.put(19, 35);
        swap.put(20, 27);
        swap.put(21, 19);
        swap.put(22, 11);
        swap.put(23, 3);
        swap.put(24, 60);
        swap.put(25, 52);
        swap.put(26, 44);
        swap.put(27, 36);
        swap.put(28, 63);
        swap.put(29, 55);
        swap.put(30, 47);
        swap.put(31, 39);
        swap.put(32, 31);
        swap.put(33, 23);
        swap.put(34, 15);
        swap.put(35, 7);
        swap.put(36, 62);
        swap.put(37, 54);
        swap.put(38, 46);
        swap.put(39, 38);
        swap.put(40, 30);
        swap.put(41, 22);
        swap.put(42, 14);
        swap.put(43, 6);
        swap.put(44, 61);
        swap.put(45, 53);
        swap.put(46, 45);
        swap.put(47, 37);
        swap.put(48, 29);
        swap.put(49, 21);
        swap.put(50, 13);
        swap.put(51, 5);
        swap.put(52, 28);
        swap.put(53, 20);
        swap.put(54, 12);
        swap.put(55, 4);

        for(int i = 0; i < result.length()-8; i++)
            result.setCharAt(i, key.charAt(swap.get(i) - 1));
        return result.toString();
    }

    //ïåðåñòàíîâêà pc2
    static String PC2(String key){
        StringBuilder result = new StringBuilder(key);

        HashMap<Integer, Integer> swap = new HashMap<Integer, Integer>();
        swap.put(0,  14);
        swap.put(1,  17);
        swap.put(2,  11);
        swap.put(3,  24);
        swap.put(4,  1);
        swap.put(5,  5);
        swap.put(6,  3);
        swap.put(7,  28);
        swap.put(8,  15);
        swap.put(9,  6);
        swap.put(10, 21);
        swap.put(11, 10);
        swap.put(12, 23);
        swap.put(13, 19);
        swap.put(14, 12);
        swap.put(15, 4);
        swap.put(16, 26);
        swap.put(17, 8);
        swap.put(18, 16);
        swap.put(19, 7);
        swap.put(20, 27);
        swap.put(21, 20);
        swap.put(22, 13);
        swap.put(23, 2);
        swap.put(24, 41);
        swap.put(25, 52);
        swap.put(26, 31);
        swap.put(27, 37);
        swap.put(28, 47);
        swap.put(29, 55);
        swap.put(30, 30);
        swap.put(31, 40);
        swap.put(32, 51);
        swap.put(33, 45);
        swap.put(34, 33);
        swap.put(35, 48);
        swap.put(36, 44);
        swap.put(37, 49);
        swap.put(38, 39);
        swap.put(39, 56);
        swap.put(40, 34);
        swap.put(41, 53);
        swap.put(42, 46);
        swap.put(43, 42);
        swap.put(44, 50);
        swap.put(45, 36);
        swap.put(46, 29);
        swap.put(47, 32);

        for(int i = 0; i < 48; i++)
            result.setCharAt(i, key.charAt(swap.get(i) - 1));
        return result.toString();
    }

    //ðàóíäîâûå êëþ÷è
    static String changeK(String K, int count){
        K=PC1(K);

        ArrayList<Character> C0=new ArrayList<>();
        ArrayList<Character> D0=new ArrayList<>();

        for(int i=0; i<28; i++){
            C0.add(K.charAt(i));
        }
        for(int i=28; i<56; i++){
            D0.add(K.charAt(i));
        }
        for(int l=1; l<=count; l++){
            if(l==1||l==2||l==9||l==16){
                char temp=C0.get(27);
                for(int i=26; i>0; i--){
                    C0.set(i+1, C0.get(i));
                }
                C0.set(0, temp);
                temp=D0.get(27);
                for(int i=26; i>0; i--){
                    D0.set(i+1, D0.get(i));
                }
                D0.set(0, temp);}
            else {
                char temp0=C0.get(27);
                char temp1=C0.get(26);
                for(int i=25; i>0; i--){
                    C0.set(i+2, C0.get(i));
                }
                C0.set(0, temp1);
                C0.set(1, temp0);
                temp0=D0.get(27);
                temp1=D0.get(26);
                for(int i=25; i>0; i--){
                    D0.set(i+2, D0.get(i));
                }
                D0.set(0, temp1);
                D0.set(1, temp0);
            }

        }
        String res=new String();
        res="";
        for(int i=0; i<28; i++){
            res+=C0.get(i);
        }
        for(int i=0; i<28; i++){
            res+=D0.get(i);
        }
        res=PC2(res);
        return res;
    }

    //òàáëèöû ñîîòâåòñòâèé
    static int yzelTable(int str, int stb, int num){
        switch (num){
            case 1:
                switch (str){
                    case 0:
                        switch (stb){
                            case 0:
                                return 14;
                            case 1:
                                return 4;
                            case 2:
                                return 13;
                            case 3:
                                return 1;
                            case 4:
                                return 2;
                            case 5:
                                return 15;
                            case 6:
                                return 11;
                            case 7:
                                return 8;
                            case 8:
                                return 3;
                            case 9:
                                return 10;
                            case 10:
                                return 6;
                            case 11:
                                return 12;
                            case 12:
                                return 5;
                            case 13:
                                return 9;
                            case 14:
                                return 0;
                            case 15:
                                return 7;
                            default:
                                return -1;
                        }
                    case 1:
                        switch (stb){
                            case 0:
                                return 0;
                            case 1:
                                return 15;
                            case 2:
                                return 7;
                            case 3:
                                return 4;
                            case 4:
                                return 14;
                            case 5:
                                return 2;
                            case 6:
                                return 13;
                            case 7:
                                return 1;
                            case 8:
                                return 10;
                            case 9:
                                return 6;
                            case 10:
                                return 12;
                            case 11:
                                return 11;
                            case 12:
                                return 9;
                            case 13:
                                return 5;
                            case 14:
                                return 3;
                            case 15:
                                return 8;
                            default:
                                return -1;
                        }
                    case 2:
                        switch (stb){
                            case 0:
                                return 4;
                            case 1:
                                return 1;
                            case 2:
                                return 14;
                            case 3:
                                return 8;
                            case 4:
                                return 13;
                            case 5:
                                return 6;
                            case 6:
                                return 2;
                            case 7:
                                return 11;
                            case 8:
                                return 15;
                            case 9:
                                return 12;
                            case 10:
                                return 9;
                            case 11:
                                return 7;
                            case 12:
                                return 3;
                            case 13:
                                return 10;
                            case 14:
                                return 5;
                            case 15:
                                return 0;
                            default:
                                return -1;
                        }
                    case 3:
                        switch (stb){
                            case 0:
                                return 15;
                            case 1:
                                return 12;
                            case 2:
                                return 8;
                            case 3:
                                return 2;
                            case 4:
                                return 4;
                            case 5:
                                return 9;
                            case 6:
                                return 1;
                            case 7:
                                return 7;
                            case 8:
                                return 5;
                            case 9:
                                return 11;
                            case 10:
                                return 3;
                            case 11:
                                return 14;
                            case 12:
                                return 10;
                            case 13:
                                return 0;
                            case 14:
                                return 6;
                            case 15:
                                return 13;
                            default:
                                return -1;
                        }
                    default:
                        return -1;
                }
            case 2:
                switch (str){
                    case 0:
                        switch (stb){
                            case 0:
                                return 15;
                            case 1:
                                return 1;
                            case 2:
                                return 8;
                            case 3:
                                return 14;
                            case 4:
                                return 6;
                            case 5:
                                return 11;
                            case 6:
                                return 3;
                            case 7:
                                return 4;
                            case 8:
                                return 9;
                            case 9:
                                return 7;
                            case 10:
                                return 2;
                            case 11:
                                return 13;
                            case 12:
                                return 12;
                            case 13:
                                return 0;
                            case 14:
                                return 5;
                            case 15:
                                return 10;
                            default:
                                return -1;
                        }
                    case 1:
                        switch (stb){
                            case 0:
                                return 3;
                            case 1:
                                return 13;
                            case 2:
                                return 4;
                            case 3:
                                return 7;
                            case 4:
                                return 15;
                            case 5:
                                return 2;
                            case 6:
                                return 8;
                            case 7:
                                return 14;
                            case 8:
                                return 12;
                            case 9:
                                return 0;
                            case 10:
                                return 1;
                            case 11:
                                return 10;
                            case 12:
                                return 6;
                            case 13:
                                return 9;
                            case 14:
                                return 11;
                            case 15:
                                return 5;
                            default:
                                return -1;
                        }
                    case 2:
                        switch (stb){
                            case 0:
                                return 0;
                            case 1:
                                return 14;
                            case 2:
                                return 7;
                            case 3:
                                return 11;
                            case 4:
                                return 10;
                            case 5:
                                return 4;
                            case 6:
                                return 13;
                            case 7:
                                return 1;
                            case 8:
                                return 5;
                            case 9:
                                return 8;
                            case 10:
                                return 12;
                            case 11:
                                return 6;
                            case 12:
                                return 9;
                            case 13:
                                return 3;
                            case 14:
                                return 2;
                            case 15:
                                return 15;
                            default:
                                return -1;
                        }
                    case 3:
                        switch (stb){
                            case 0:
                                return 13;
                            case 1:
                                return 8;
                            case 2:
                                return 10;
                            case 3:
                                return 1;
                            case 4:
                                return 3;
                            case 5:
                                return 15;
                            case 6:
                                return 4;
                            case 7:
                                return 2;
                            case 8:
                                return 11;
                            case 9:
                                return 6;
                            case 10:
                                return 7;
                            case 11:
                                return 12;
                            case 12:
                                return 0;
                            case 13:
                                return 5;
                            case 14:
                                return 14;
                            case 15:
                                return 9;
                            default:
                                return -1;
                        }
                    default:
                        return -1;
                }
            case 3:
                switch (str){
                    case 0:
                        switch (stb){
                            case 0:
                                return 10;
                            case 1:
                                return 0;
                            case 2:
                                return 9;
                            case 3:
                                return 14;
                            case 4:
                                return 6;
                            case 5:
                                return 3;
                            case 6:
                                return 15;
                            case 7:
                                return 5;
                            case 8:
                                return 1;
                            case 9:
                                return 13;
                            case 10:
                                return 12;
                            case 11:
                                return 7;
                            case 12:
                                return 11;
                            case 13:
                                return 4;
                            case 14:
                                return 2;
                            case 15:
                                return 8;
                            default:
                                return -1;
                        }
                    case 1:
                        switch (stb){
                            case 0:
                                return 13;
                            case 1:
                                return 7;
                            case 2:
                                return 0;
                            case 3:
                                return 9;
                            case 4:
                                return 3;
                            case 5:
                                return 4;
                            case 6:
                                return 6;
                            case 7:
                                return 10;
                            case 8:
                                return 2;
                            case 9:
                                return 8;
                            case 10:
                                return 5;
                            case 11:
                                return 14;
                            case 12:
                                return 12;
                            case 13:
                                return 11;
                            case 14:
                                return 15;
                            case 15:
                                return 1;
                            default:
                                return -1;
                        }
                    case 2:
                        switch (stb){
                            case 0:
                                return 13;
                            case 1:
                                return 6;
                            case 2:
                                return 4;
                            case 3:
                                return 9;
                            case 4:
                                return 8;
                            case 5:
                                return 15;
                            case 6:
                                return 3;
                            case 7:
                                return 0;
                            case 8:
                                return 11;
                            case 9:
                                return 1;
                            case 10:
                                return 2;
                            case 11:
                                return 12;
                            case 12:
                                return 5;
                            case 13:
                                return 10;
                            case 14:
                                return 14;
                            case 15:
                                return 7;
                            default:
                                return -1;
                        }
                    case 3:
                        switch (stb){
                            case 0:
                                return 1;
                            case 1:
                                return 10;
                            case 2:
                                return 13;
                            case 3:
                                return 0;
                            case 4:
                                return 6;
                            case 5:
                                return 9;
                            case 6:
                                return 8;
                            case 7:
                                return 7;
                            case 8:
                                return 4;
                            case 9:
                                return 15;
                            case 10:
                                return 14;
                            case 11:
                                return 3;
                            case 12:
                                return 11;
                            case 13:
                                return 5;
                            case 14:
                                return 2;
                            case 15:
                                return 12;
                            default:
                                return -1;
                        }
                    default:
                        return -1;
                }
            case 4:
                switch (str){
                    case 0:
                        switch (stb){
                            case 0:
                                return 7;
                            case 1:
                                return 13;
                            case 2:
                                return 14;
                            case 3:
                                return 3;
                            case 4:
                                return 0;
                            case 5:
                                return 6;
                            case 6:
                                return 9;
                            case 7:
                                return 10;
                            case 8:
                                return 1;
                            case 9:
                                return 2;
                            case 10:
                                return 8;
                            case 11:
                                return 5;
                            case 12:
                                return 11;
                            case 13:
                                return 12;
                            case 14:
                                return 4;
                            case 15:
                                return 15;
                            default:
                                return -1;
                        }
                    case 1:
                        switch (stb){
                            case 0:
                                return 13;
                            case 1:
                                return 8;
                            case 2:
                                return 11;
                            case 3:
                                return 5;
                            case 4:
                                return 6;
                            case 5:
                                return 15;
                            case 6:
                                return 0;
                            case 7:
                                return 3;
                            case 8:
                                return 4;
                            case 9:
                                return 7;
                            case 10:
                                return 2;
                            case 11:
                                return 12;
                            case 12:
                                return 1;
                            case 13:
                                return 10;
                            case 14:
                                return 14;
                            case 15:
                                return 9;
                            default:
                                return -1;
                        }
                    case 2:
                        switch (stb){
                            case 0:
                                return 10;
                            case 1:
                                return 6;
                            case 2:
                                return 9;
                            case 3:
                                return 0;
                            case 4:
                                return 12;
                            case 5:
                                return 11;
                            case 6:
                                return 7;
                            case 7:
                                return 13;
                            case 8:
                                return 15;
                            case 9:
                                return 1;
                            case 10:
                                return 3;
                            case 11:
                                return 14;
                            case 12:
                                return 5;
                            case 13:
                                return 2;
                            case 14:
                                return 8;
                            case 15:
                                return 4;
                            default:
                                return -1;
                        }
                    case 3:
                        switch (stb){
                            case 0:
                                return 3;
                            case 1:
                                return 15;
                            case 2:
                                return 0;
                            case 3:
                                return 6;
                            case 4:
                                return 10;
                            case 5:
                                return 1;
                            case 6:
                                return 13;
                            case 7:
                                return 8;
                            case 8:
                                return 9;
                            case 9:
                                return 4;
                            case 10:
                                return 5;
                            case 11:
                                return 11;
                            case 12:
                                return 12;
                            case 13:
                                return 7;
                            case 14:
                                return 2;
                            case 15:
                                return 14;
                            default:
                                return -1;
                        }
                    default:
                        return -1;
                }
            case 5:
                switch (str){
                    case 0:
                        switch (stb){
                            case 0:
                                return 2;
                            case 1:
                                return 12;
                            case 2:
                                return 4;
                            case 3:
                                return 1;
                            case 4:
                                return 7;
                            case 5:
                                return 10;
                            case 6:
                                return 11;
                            case 7:
                                return 6;
                            case 8:
                                return 8;
                            case 9:
                                return 5;
                            case 10:
                                return 3;
                            case 11:
                                return 15;
                            case 12:
                                return 13;
                            case 13:
                                return 0;
                            case 14:
                                return 14;
                            case 15:
                                return 9;
                            default:
                                return -1;
                        }
                    case 1:
                        switch (stb){
                            case 0:
                                return 14;
                            case 1:
                                return 11;
                            case 2:
                                return 2;
                            case 3:
                                return 12;
                            case 4:
                                return 4;
                            case 5:
                                return 7;
                            case 6:
                                return 13;
                            case 7:
                                return 1;
                            case 8:
                                return 5;
                            case 9:
                                return 0;
                            case 10:
                                return 15;
                            case 11:
                                return 10;
                            case 12:
                                return 3;
                            case 13:
                                return 9;
                            case 14:
                                return 8;
                            case 15:
                                return 6;
                            default:
                                return -1;
                        }
                    case 2:
                        switch (stb){
                            case 0:
                                return 4;
                            case 1:
                                return 2;
                            case 2:
                                return 1;
                            case 3:
                                return 11;
                            case 4:
                                return 10;
                            case 5:
                                return 13;
                            case 6:
                                return 7;
                            case 7:
                                return 8;
                            case 8:
                                return 15;
                            case 9:
                                return 9;
                            case 10:
                                return 12;
                            case 11:
                                return 5;
                            case 12:
                                return 6;
                            case 13:
                                return 3;
                            case 14:
                                return 0;
                            case 15:
                                return 14;
                            default:
                                return -1;
                        }
                    case 3:
                        switch (stb){
                            case 0:
                                return 11;
                            case 1:
                                return 8;
                            case 2:
                                return 12;
                            case 3:
                                return 7;
                            case 4:
                                return 1;
                            case 5:
                                return 14;
                            case 6:
                                return 2;
                            case 7:
                                return 13;
                            case 8:
                                return 6;
                            case 9:
                                return 15;
                            case 10:
                                return 0;
                            case 11:
                                return 9;
                            case 12:
                                return 10;
                            case 13:
                                return 4;
                            case 14:
                                return 5;
                            case 15:
                                return 3;
                            default:
                                return -1;
                        }
                    default:
                        return -1;
                }
            case 6:
                switch (str){
                    case 0:
                        switch (stb){
                            case 0:
                                return 12;
                            case 1:
                                return 1;
                            case 2:
                                return 10;
                            case 3:
                                return 15;
                            case 4:
                                return 9;
                            case 5:
                                return 2;
                            case 6:
                                return 6;
                            case 7:
                                return 8;
                            case 8:
                                return 0;
                            case 9:
                                return 13;
                            case 10:
                                return 3;
                            case 11:
                                return 4;
                            case 12:
                                return 14;
                            case 13:
                                return 7;
                            case 14:
                                return 5;
                            case 15:
                                return 11;
                            default:
                                return -1;
                        }
                    case 1:
                        switch (stb){
                            case 0:
                                return 10;
                            case 1:
                                return 15;
                            case 2:
                                return 4;
                            case 3:
                                return 2;
                            case 4:
                                return 7;
                            case 5:
                                return 12;
                            case 6:
                                return 9;
                            case 7:
                                return 5;
                            case 8:
                                return 6;
                            case 9:
                                return 1;
                            case 10:
                                return 13;
                            case 11:
                                return 14;
                            case 12:
                                return 0;
                            case 13:
                                return 11;
                            case 14:
                                return 3;
                            case 15:
                                return 8;
                            default:
                                return -1;
                        }
                    case 2:
                        switch (stb){
                            case 0:
                                return 9;
                            case 1:
                                return 14;
                            case 2:
                                return 15;
                            case 3:
                                return 5;
                            case 4:
                                return 2;
                            case 5:
                                return 8;
                            case 6:
                                return 12;
                            case 7:
                                return 3;
                            case 8:
                                return 7;
                            case 9:
                                return 0;
                            case 10:
                                return 4;
                            case 11:
                                return 10;
                            case 12:
                                return 1;
                            case 13:
                                return 13;
                            case 14:
                                return 11;
                            case 15:
                                return 6;
                            default:
                                return -1;
                        }
                    case 3:
                        switch (stb){
                            case 0:
                                return 4;
                            case 1:
                                return 3;
                            case 2:
                                return 2;
                            case 3:
                                return 12;
                            case 4:
                                return 9;
                            case 5:
                                return 5;
                            case 6:
                                return 15;
                            case 7:
                                return 10;
                            case 8:
                                return 11;
                            case 9:
                                return 14;
                            case 10:
                                return 1;
                            case 11:
                                return 7;
                            case 12:
                                return 6;
                            case 13:
                                return 0;
                            case 14:
                                return 8;
                            case 15:
                                return 13;
                            default:
                                return -1;
                        }
                    default:
                        return -1;
                }
            case 7:
                switch (str){
                    case 0:
                        switch (stb){
                            case 0:
                                return 4;
                            case 1:
                                return 11;
                            case 2:
                                return 2;
                            case 3:
                                return 14;
                            case 4:
                                return 15;
                            case 5:
                                return 0;
                            case 6:
                                return 8;
                            case 7:
                                return 13;
                            case 8:
                                return 3;
                            case 9:
                                return 12;
                            case 10:
                                return 9;
                            case 11:
                                return 7;
                            case 12:
                                return 5;
                            case 13:
                                return 10;
                            case 14:
                                return 6;
                            case 15:
                                return 1;
                            default:
                                return -1;
                        }
                    case 1:
                        switch (stb){
                            case 0:
                                return 13;
                            case 1:
                                return 0;
                            case 2:
                                return 11;
                            case 3:
                                return 7;
                            case 4:
                                return 4;
                            case 5:
                                return 9;
                            case 6:
                                return 1;
                            case 7:
                                return 10;
                            case 8:
                                return 14;
                            case 9:
                                return 3;
                            case 10:
                                return 5;
                            case 11:
                                return 12;
                            case 12:
                                return 2;
                            case 13:
                                return 15;
                            case 14:
                                return 8;
                            case 15:
                                return 6;
                            default:
                                return -1;
                        }
                    case 2:
                        switch (stb){
                            case 0:
                                return 1;
                            case 1:
                                return 4;
                            case 2:
                                return 11;
                            case 3:
                                return 13;
                            case 4:
                                return 12;
                            case 5:
                                return 3;
                            case 6:
                                return 7;
                            case 7:
                                return 14;
                            case 8:
                                return 10;
                            case 9:
                                return 15;
                            case 10:
                                return 6;
                            case 11:
                                return 8;
                            case 12:
                                return 0;
                            case 13:
                                return 5;
                            case 14:
                                return 9;
                            case 15:
                                return 2;
                            default:
                                return -1;
                        }
                    case 3:
                        switch (stb){
                            case 0:
                                return 6;
                            case 1:
                                return 11;
                            case 2:
                                return 13;
                            case 3:
                                return 8;
                            case 4:
                                return 1;
                            case 5:
                                return 4;
                            case 6:
                                return 10;
                            case 7:
                                return 7;
                            case 8:
                                return 9;
                            case 9:
                                return 5;
                            case 10:
                                return 0;
                            case 11:
                                return 15;
                            case 12:
                                return 14;
                            case 13:
                                return 2;
                            case 14:
                                return 3;
                            case 15:
                                return 12;
                            default:
                                return -1;
                        }
                    default:
                        return -1;
                }
            case 8:
                switch (str){
                    case 0:
                        switch (stb){
                            case 0:
                                return 13;
                            case 1:
                                return 2;
                            case 2:
                                return 8;
                            case 3:
                                return 4;
                            case 4:
                                return 6;
                            case 5:
                                return 15;
                            case 6:
                                return 11;
                            case 7:
                                return 1;
                            case 8:
                                return 10;
                            case 9:
                                return 9;
                            case 10:
                                return 3;
                            case 11:
                                return 14;
                            case 12:
                                return 5;
                            case 13:
                                return 0;
                            case 14:
                                return 12;
                            case 15:
                                return 7;
                            default:
                                return -1;
                        }
                    case 1:
                        switch (stb){
                            case 0:
                                return 1;
                            case 1:
                                return 15;
                            case 2:
                                return 13;
                            case 3:
                                return 8;
                            case 4:
                                return 10;
                            case 5:
                                return 3;
                            case 6:
                                return 7;
                            case 7:
                                return 4;
                            case 8:
                                return 12;
                            case 9:
                                return 5;
                            case 10:
                                return 6;
                            case 11:
                                return 11;
                            case 12:
                                return 0;
                            case 13:
                                return 14;
                            case 14:
                                return 9;
                            case 15:
                                return 2;
                            default:
                                return -1;
                        }
                    case 2:
                        switch (stb){
                            case 0:
                                return 7;
                            case 1:
                                return 11;
                            case 2:
                                return 4;
                            case 3:
                                return 1;
                            case 4:
                                return 9;
                            case 5:
                                return 12;
                            case 6:
                                return 14;
                            case 7:
                                return 2;
                            case 8:
                                return 0;
                            case 9:
                                return 6;
                            case 10:
                                return 10;
                            case 11:
                                return 13;
                            case 12:
                                return 15;
                            case 13:
                                return 3;
                            case 14:
                                return 5;
                            case 15:
                                return 8;
                            default:
                                return -1;
                        }
                    case 3:
                        switch (stb){
                            case 0:
                                return 2;
                            case 1:
                                return 1;
                            case 2:
                                return 14;
                            case 3:
                                return 7;
                            case 4:
                                return 4;
                            case 5:
                                return 10;
                            case 6:
                                return 8;
                            case 7:
                                return 13;
                            case 8:
                                return 15;
                            case 9:
                                return 12;
                            case 10:
                                return 9;
                            case 11:
                                return 0;
                            case 12:
                                return 3;
                            case 13:
                                return 5;
                            case 14:
                                return 6;
                            case 15:
                                return 11;
                            default:
                                return -1;
                        }
                    default:
                        return -1;
                }
            default:
                return -1;
        }
    }

    static String yzelChange(String a, int num){
        String a16=new String();
        String a2345=new String();
        a16+=a.charAt(0);
        a16+=a.charAt(5);
        a2345+=a.charAt(1);
        a2345+=a.charAt(2);
        a2345+=a.charAt(3);
        a2345+=a.charAt(4);
        int b16, b2345;
        b16=Integer.parseInt(a16, 2);
        b2345=Integer.parseInt(a2345, 2);
        int t=yzelTable(b16, b2345, num);
        String rezult=new String();
        rezult=Integer.toBinaryString(t);
        while(rezult.length()<4)
            rezult='0'+rezult;
        return rezult;
    }

    //ïåðåñòàíîâêà p
    static String perestP(String str){
        StringBuilder result = new StringBuilder(str);

        HashMap<Integer, Integer> swap = new HashMap<Integer, Integer>();
        swap.put(0,  16);
        swap.put(1,  7);
        swap.put(2,  20);
        swap.put(3,  21);
        swap.put(4,  29);
        swap.put(5,  12);
        swap.put(6,  28);
        swap.put(7,  17);
        swap.put(8,  1);
        swap.put(9,  15);
        swap.put(10, 23);
        swap.put(11, 26);
        swap.put(12, 5);
        swap.put(13, 18);
        swap.put(14, 31);
        swap.put(15, 10);
        swap.put(16, 2);
        swap.put(17, 8);
        swap.put(18, 24);
        swap.put(19, 14);
        swap.put(20, 32);
        swap.put(21, 27);
        swap.put(22, 3);
        swap.put(23, 9);
        swap.put(24, 19);
        swap.put(25, 13);
        swap.put(26, 30);
        swap.put(27, 6);
        swap.put(28, 22);
        swap.put(29, 11);
        swap.put(30, 4);
        swap.put(31, 25);

        for(int i = 0; i < result.length(); i++)
            result.setCharAt(i, str.charAt(swap.get(i) - 1));

        return result.toString();
    }

    //ôóíêöèÿ
    static String function(String L0, String K){
        Vector[] L1=new Vector[8];
        Vector[] L2=new Vector[8];
        for(int i=0; i<8; i++){
            L1[i]=new Vector();
            L2[i]=new Vector();
        }

        for(int i=0; i<4; i++){
            L1[0].add(L0.charAt(i));
            L1[1].add(L0.charAt(i+4));
            L1[2].add(L0.charAt(i+8));
            L1[3].add(L0.charAt(i+12));
            L1[4].add(L0.charAt(i+16));
            L1[5].add(L0.charAt(i+20));
            L1[6].add(L0.charAt(i+24));
            L1[7].add(L0.charAt(i+28));
        }
        L2[0].add(L1[7].get(3));
        L2[1].add(L1[0].get(3));
        L2[2].add(L1[1].get(3));
        L2[3].add(L1[2].get(3));
        L2[4].add(L1[3].get(3));
        L2[5].add(L1[4].get(3));
        L2[6].add(L1[5].get(3));
        L2[7].add(L1[6].get(3));
        for(int i=0; i<4; i++){
            L2[0].add(L1[0].get(i));
            L2[1].add(L1[1].get(i));
            L2[2].add(L1[2].get(i));
            L2[3].add(L1[3].get(i));
            L2[4].add(L1[4].get(i));
            L2[5].add(L1[5].get(i));
            L2[6].add(L1[6].get(i));
            L2[7].add(L1[7].get(i));
        }
        L2[0].add(L1[1].get(0));
        L2[1].add(L1[2].get(0));
        L2[2].add(L1[3].get(0));
        L2[3].add(L1[4].get(0));
        L2[4].add(L1[5].get(0));
        L2[5].add(L1[6].get(0));
        L2[6].add(L1[7].get(0));
        L2[7].add(L1[0].get(0));
        String L=new String();
        L="";
        for(int i=0; i<8; i++){
            for(int j=0;j<6; j++){
                L+=(L2[i].get(j));
            }
        }
        String R=new String();
        for(int i=0; i<48; i++){
            if(((L.charAt(i)=='0')&&(K.charAt(i)=='0'))||((L.charAt(i)=='1')&&(K.charAt(i)=='1')))
                R+='0';
            else
                R+='1';
        }
        String[] H=new String[8];
        for(int i=0; i<8; i++){
            H[i]=new String();
            H[i]="";
        }
        for(int i=0; i<8; i++){
            for(int j=0; j<6; j++){
                H[i]+=R.charAt(j+i*6);
            }
        }
        String[] H1=new String[8];
        for(int i=0; i<8; i++){
            H1[i]=new String();
            H1[i]="";
        }
        for(int i=0; i<8; i++){
            H1[i]=yzelChange(H[i], i+1);
        }

        String HR=new String();
        for(int i=0; i<8; i++){
            HR+=H1[i];
        }
        HR=perestP(HR);
        return HR;
    }

    static String message(String text, String key ){
        text=textToBin(text);
        key=formFullKey(key);
        text=IP(text);
        System.out.println("First IP: "+text);
        String H0=new String();
        String[] H=new String[17];
        String L0=new String();
        String[] L=new String[17];
        for(int i=0; i<17; i++){
            H[i]=new String();
            H[i]="";
            L[i]=new String();
            L[i]="";
        }

        for(int i=0; i<32; i++){
            H0+=(text.charAt(i));
        }
        for(int i=32; i<64; i++){
            L0+=(text.charAt(i));
        }
        int count=1;
        String temp=new String();
        temp="";
        String K = changeK(key, count);
        System.out.println("K"+count+ ": "+ K);
        L[0] = L0;
        System.out.println("L0: " +L[0] );
        temp = function(L0.toString(), K);
        System.out.println("f1: "+temp);
        for(int i=0; i<32; i++){
            if(((temp.charAt(i)=='0')&&(H0.charAt(i)=='0'))||((temp.charAt(i)=='1')&&(H0.charAt(i)=='1')))
                H[0]+='0';
            else
                H[0]+='1';
        }
        System.out.println("H0: "+H[0]);
        String swaps=new String();
        for(int i=1 ;i<17; i++) {
            K = changeK(key, i+1);
            System.out.println("K"+(i+1)+ ": "+ K);
            L[i] = L[i-1];
            temp = function(L[i-1].toString(), K);
            System.out.println("f"+(i+1)+": "+temp);
            for(int k=0; k<32; k++){
                if(((temp.charAt(k)=='0')&&(H0.charAt(k)=='0'))||((temp.charAt(k)=='1')&&(H0.charAt(k)=='1')))
                    H[i]+='0';
                else
                    H[i]+='1';
            }
            if(i!=16){
                swaps=L[i];
                L[i]=H[i];
                H[i]=swaps;
            }
            System.out.println("L"+(i)+": " +L[i] );
            System.out.println("H"+(i)+": " +H[i] );
        }
        String TT=new String();
        TT+=L[15];
        TT+=H[15];
        text=minusIP(TT);
        return text;
    }
}

