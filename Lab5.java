import java.io.*;
import java.util.Scanner;

public class lab5 {
    public static void main(String[] args) {
        Palindrom pal = new Palindrom();

    }
}

class Split{
    Scanner sc = new Scanner(System.in);
    String a[];

    public Split(){
        System.out.println("Введите текст:");
        String s = sc.nextLine();
        int n=0;
        for (String z : s.split(" ")){
            if (z.trim().length() > 0) {
                n++;
            }
        }
        a = new String[n];

        int i=0;
        for (String z : s.split(" ")){
            if (z.trim().length() > 0) {
                a[i] = z;
                i++;
            }
        }
    }

}

class Pal extends Split{
    String []pal;
    int u=0;

    public Pal(){
        int n1=0;
        int n=a.length;
        boolean t=false;
        for (int i=0;i<n;i++){
            t=false;
            t=isPal(a[i]);
            if (t){
                n1++;
            }
        }

        this.pal = new String[n1];

        u=0;
        for (int i=0;i<n;i++){
            t=false;
            t=isPal(a[i]);
            if (t){
                pal[u]=a[i];
                u++;
            }
        }
    }

    public Boolean isPal(String s){
        int n = s.length();
        String s1 = "";

        for (int i=0; i<n; i++){
            if (Character.isUpperCase(s.charAt(i))){
                s1 += Character.toLowerCase(s.charAt(i));
            } else s1 += s.charAt(i);
        }

        for (int i = 0; i < (n/2); ++i) {
            if (s1.charAt(i) != s1.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

}

class Print extends Pal{
    public void PrintPal(){
        if (u>0) {
            System.out.println("Все палиндромы:");
            for (int i = 0; i < pal.length; i++) {
                System.out.println(pal[i]);
            }
            Max();
        } else System.out.println("Палиндромов нет");
    }

    public void Max(){
        String s="";
        for (int i=0;i<pal.length;i++){
            if (pal[i].length() > s.length()){
                s=pal[i];
            }
        }

        System.out.println("\nПалиндром максимальной длины: \n" + s);
    }

}

class Palindrom extends Print{
    public Palindrom(){
        PrintPal();
    }
}