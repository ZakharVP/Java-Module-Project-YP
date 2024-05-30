import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Goods {
    //Функция второй части
    //Что было заказано и по какой стоимости, с точностью до копеек.
    static Map goodsInput(){

        boolean checkCost = true;
        boolean checkEnter = true;
        float cost = 0;
        String product = "";
        Map<String,Float> receipt = new HashMap<String,Float>();

        System.out.println("Введите заказанное блюдо-товар.");
        while (checkEnter){
            Scanner in = new Scanner(System.in);

            //Товар
            product = in.nextLine(); // Товар может быть с пробелом в имени
            if(product.toLowerCase().equals("завершить")){
                checkEnter = false;
                break;
            }

            //Стоимость
            System.out.println("Введите стоимость до копеек(,00). В качестве разделителя нужно использовать \",\"");
            while (checkCost) {
                if(!(in.hasNextFloat())){
                    System.out.println("Вы ввели " + in.next() + " это не похоже на стоимость.\n Пожалуйста повторите ввод.");
                }
                else {
                    cost = Math.round(in.nextFloat()*100)/100.0f;
                    if(cost > 0){
                        checkCost = false;
                    }
                    else{
                        System.out.println("Вы ввели " + cost + ", это неправильная стоимость.\n Пожалуйста повторите ввод.");
                    }

                }
            }

            //Добавим в массив
            receipt.put(product, cost);
            Main.totalCost += cost;
            System.out.println("Вы добавили в чек " + product + " по стоимости " + cost);
            System.out.println("Если вы хотите завершить ввод - наберите \"Завершить\" или введите новый товар.");
            checkCost = true;

        }

        return receipt;
    }
}
