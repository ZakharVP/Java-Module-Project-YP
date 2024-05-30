import java.util.Iterator;
import java.util.Map;

public class Calculation {
    //Процедура третей части
    static void calculationOutput(int quantity, Map receipt){

        float perCost;
        int intPerCost;
        String sRubOne      = "рубль";
        String sRubls       = "рубля";
        String sMoreRubls   = "рублей";


        System.out.println("Добавленные товары:");

        Iterator<Map.Entry<String, Float>> iterator = receipt.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Float> entry = iterator.next();
            String product = entry.getKey();
            Float cost = entry.getValue();
            System.out.println(product + " стоит " + cost);
        }
        perCost = Main.totalCost / quantity;
        if (perCost * (double)(quantity) < Main.totalCost){
            perCost += 0.01f;
        }
        intPerCost = (int) Math.ceil(perCost);

        System.out.println(String.format("Общая стоимость счета " + Main.totalCost +  ", каждый должен внести %.2f %s или %d %s", perCost, Main.GetRubls(intPerCost), intPerCost, Main.GetRubls(intPerCost)));

    }
}
