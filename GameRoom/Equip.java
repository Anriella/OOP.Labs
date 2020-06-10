package GameRoom;

import java.util.Scanner;

public class Equip extends Toy{
    Scanner sc = new Scanner(System.in);
    public int n;
    public String []toy_eq;
    public int []price_eq;
    public int []tip_eq;

    public Equip(){
        try {

            //System.out.println("\nУкажите количество игрушек в комнате: ");
            this.n = 6;
            this.toy_eq = new String[n];
            this.price_eq = new int[n];
            this.tip_eq = new int[n];

            //for (int i = 0; i < m; i++) {
            //    System.out.println(i + ": " + toy[i] + " " + price[i]);
            //}

            //System.out.println();

            for (int i = 0; i < n; i++) {
                //System.out.println("Выберите игрушку по индексу: ");
                int j = i;
                toy_eq[i] = toy[j];
                price_eq[i] = price[j];
                tip_eq[i] = tip[j];
            }
        } catch(Exception e){}
    }


}
