import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static float totalCost = 0;

    public static void main(String[] args) {

        int quantity = CountPeople.countPeopleInput();
        Map receipt = Goods.goodsInput();
        Calculation.calculationOutput(quantity, receipt);

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
                return "рубля";
            default:
                return "рублей";
        }
    }
}

// Напоминалка "Калькулятор счета"

// 1. Задаем вопросы в консоли
// 2. Считаем пользовательский ввод
// 3. Показываем список товаров и показываем сумму каждого из друзей
