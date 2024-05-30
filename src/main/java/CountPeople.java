import java.util.Scanner;

public class CountPeople{
//Функция первой части.
//На сколько людей будем делить счет
    public static int countPeopleInput() {

        Scanner in = new Scanner(System.in);
        System.out.println("На скольких человек необходимо разделить счет?");

        boolean check = true;
        int quantity = 0;

        while (check) {
            if (in.hasNextInt()) {
                quantity = in.nextInt();
                if (quantity <= 1) {
                    System.out.println("Вы ошиблись, вы ввели меньше 2, а именно: " + quantity + "\n Пожалуйста повторите ввод.");
                } else {
                    check = false;
                }
            } else {
                System.out.println("Вы ошиблись, вы ввели " + in.next() + " вместо целого числа. \n Пожалуйста повторите ввод.");
            }
        }
        return quantity;
    }
}

