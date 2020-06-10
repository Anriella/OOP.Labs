package GameRoom;

import java.util.Scanner;

public class Toy{

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
    public int m = 0;
    public String[] toy;
    public int[] price;
    public int[] tip;

    public Toy() {
        try {
            this.m = 6;
            this.toy = new String[]{"Маленькая Машинка", "Средняя Машинка", "Большая Машинка", "Кукла", "Мяч", "Кубики"};
            this.price = new int[]{135, 150, 200, 345, 420, 120};
            this.tip = new int[]{1, 2, 3, 1, 3, 1};

            //System.out.println("Категория возраста: \n" + " 1: от 2 до 4 лет\n" + " 2: от 5 до 6 лет\n" + " 3: от 7 до 9 лет");
        } catch(Exception e){}
    }
}
