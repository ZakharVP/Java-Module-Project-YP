import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static float totalCost = 0;

    public static void main(String[] args) {

        int quantity = firstInput();
        Map receipt = secondInput();
        thirdOutput(quantity, receipt);

    }

    //Функция первой части
    //На сколько людей будем делить счет
    static int firstInput() {

        Scanner in = new Scanner(System.in);
        System.out.println("На скольких человек необходимо разделить счет?");

        boolean proverka = true;
        int quantity = 0;

        while (proverka) {
            if (in.hasNextInt()) {
                quantity = in.nextInt();
                if (quantity <= 1) {
                    System.out.println("Вы ошиблись, вы ввели меньше 2, а именно: " + quantity + "\n Пожалуйста повторите ввод.");
                } else {
                    proverka = false;
                }
            } else {
                System.out.println("Вы ошиблись, вы ввели " + in.next() + " вместо целого числа. \n Пожалуйста повторите ввод.");
            }
        }
        return quantity;
    }

    //Функция второй части
    //Что было заказано и по какой стоимости, с точностью до копеек.
    static Map secondInput(){

        boolean checkCost = true;
        boolean checkEnter = true;
        float cost = 0;
        int count = 0;
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
            System.out.println("Введите стоимость до копеек(.00).");
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
            totalCost += cost;
            System.out.println("Вы добавили в чек " + product + " по стоимости " + cost);
            System.out.println("Если вы хотите завершить ввод - наберите \"Завершить\" или введите новый товар.");
            checkCost = true;

//            count += 1;
//            if(count == 5){
//                break;
//            }
        }

       return receipt;
    }

    //Процедура третей части
    static void thirdOutput(int quantity, Map receipt){

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
//            System.out.println(String.format(text,product,cost));
            System.out.println(product + " стоит " + cost);
        }
        perCost = totalCost / quantity;
        if (perCost * (double)(quantity) < totalCost){
            perCost += 0.01f;
        }
        intPerCost = (int) Math.ceil(perCost);

        System.out.println(String.format("Общая стоимость счета " + totalCost +  ", каждый должен внести %.2f %s или %d %s", perCost, GetRubls(intPerCost), intPerCost, GetRubls(intPerCost)));

    }

    public static String GetRubls(int num){
        int preLastDigit = num % 100/10;
        if(preLastDigit == 1){
            return "рублей";
        }
        switch(num % 10){
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубль";
            default:
                return "рублей";
        }
    }
}

// Напоминалка "Калькулятор счета"

// 1. Задаем вопросы в консоли
// 2. Считаем пользовательский ввод
// 3. Показываем список товаров и показываем сумму каждого из друзей
