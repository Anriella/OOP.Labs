package GameRoom;

public class GameRoom extends Print{
    public String i;
    public GameRoom(String i){
        this.i=i;
    }

    public String Print_GameRoom(){
        return "\n" + "Категория возраста: \n" + " 1: от 2 до 4 лет\n" + " 2: от 5 до 6 лет\n" + " 3: от 7 до 9 лет\n\n" + i + "\nИгрушки: " + print() + "\nВся стоимость игрушек: " + full_price();
    }
}
