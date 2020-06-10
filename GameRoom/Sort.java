package GameRoom;

public class Sort extends Equip{
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
