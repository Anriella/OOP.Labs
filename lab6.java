import java.io.*;
import java.util.Scanner;

public class lab6
{
    public static void main(String[] args) {
        GameRoom []gr = new GameRoom[1];

        gr[0] = new GameRoom("Игровая Комната");


        System.out.println(gr[0].Print_GameRoom());
    }
}



class Toy{

    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);
    int m = 0;
    String[] toy;
    int[] price;
    int[] tip;

    public Toy() {
        try {
            System.out.println("\nУкажите количество возможных игрушек: ");
            this.m = sc.nextInt();
            this.toy = new String[m];
            this.price = new int[m];
            this.tip = new int[m];

            System.out.println("Категория возраста: \n" + " 1: от 2 до 4 лет\n" + " 2: от 5 до 6 лет\n" + " 3: от 7 до 9 лет");

            for (int i = 0; i < m; i++) {
                int t=0;
                System.out.println("\nНазвание игрушки: ");
                toy[i] = sc1.nextLine();
                System.out.println("Укажите цену: ");
                price[i] = sc.nextInt();
                while (t==0) {
                    System.out.println("Укажите категорию возраста: ");
                    tip[i] = sc.nextInt();
                    if (tip[i]==1 || tip[i]==2 || tip[i]==3){
                        t=1;
                    } else System.out.println("Такой категории не существует");
                }
            }
        } catch(Exception e){}
    }
}

class Equip extends Toy{
    Scanner sc = new Scanner(System.in);
    int n;
    String []toy_eq;
    int []price_eq;
    int []tip_eq;

    public Equip(){
        try {

            System.out.println("\nУкажите количество игрушек в комнате: ");
            this.n = sc.nextInt();
            this.toy_eq = new String[n];
            this.price_eq = new int[n];
            this.tip_eq = new int[n];

            for (int i = 0; i < m; i++) {
                System.out.println(i + ": " + toy[i] + " " + price[i]);
            }

            System.out.println();

            for (int i = 0; i < n; i++) {
                System.out.println("Выберите игрушку по индексу: ");
                int j = sc.nextInt();
                toy_eq[i] = toy[j];
                price_eq[i] = price[j];
                tip_eq[i] = tip[j];
            }
        } catch(Exception e){}
    }


}

class Sort extends Equip{
    public Sort(){
        try {
            int j = 0;
            while (j < n - 1) {
                if (tip_eq[j + 1] > tip_eq[j]) {
                    int b = tip_eq[j];
                    tip_eq[j] = tip_eq[j + 1];
                    tip_eq[j + 1] = b;

                    b = price_eq[j];
                    price_eq[j] = price_eq[j + 1];
                    price_eq[j + 1] = b;

                    String c = toy_eq[j];
                    toy_eq[j] = toy_eq[j + 1];
                    toy_eq[j + 1] = c;

                    j = 0;
                } else j++;
            }
        } catch(Exception e){}


    }

}

class Print extends Sort{
    Scanner sc = new Scanner(System.in);
    public String print(){
        String s = "";
        try{
            for (int i = 0; i < n; i++) {
                s += "\n " + toy_eq[i] + " Цена: " + String.valueOf(price_eq[i]) + " Категория: " + String.valueOf(tip_eq[i]);
                s += " ";
            }
        } catch(Exception e){}

        return s;
    }

    public Print(){
        System.out.println("\nУкажите диапазон цен: ");
        System.out.print("От: ");
        int x = sc.nextInt();
        System.out.print("До: ");
        int z = sc.nextInt();
        System.out.println();

        System.out.println("Игрушки в данном диапазоне цен в комнате: ");
        for (int i=0;i<n;i++){
            if (price_eq[i]<=z && price_eq[i]>=x){
                System.out.println(" "+toy_eq[i]+" Цена: "+price_eq[i]);
            }

        }
    }

    public String full_price(){
        int full_price = 0;
        try {
            for (int i = 0; i < n; i++) {
                full_price += price_eq[i];
            }
        }catch(Exception e){}

        return String.valueOf(full_price);
    }
}

class GameRoom extends Print{
    public String i;
    public GameRoom(String i){
        this.i=i;
    }

    public String Print_GameRoom(){
        return "\n" + "Категория возраста: \n" + " 1: от 2 до 4 лет\n" + " 2: от 5 до 6 лет\n" + " 3: от 7 до 9 лет\n\n" + i + "\nИгрушки: " + print() + "\nВся стоимость игрушек: " + full_price();
    }
}