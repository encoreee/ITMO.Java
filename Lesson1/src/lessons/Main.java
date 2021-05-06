package lessons;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1\n");
        System.out.println("Я\n" + "хорошо\n" + "знаю\n" + "Java.\n");
        System.out.println("Задание 2\n");
        System.out.println(( 46 + 10 ) * ( 10 / 3 ));
        System.out.println(( 29 ) * ( 4 ) * (- 15 ));
        System.out.println("Задание 3\n");
        int number = 10500;
        int result = (number / 10) / 10;
        System.out.println("Задание 4\n");
        double num1 = 3.6;
        double num2 = 4.1;
        double num3 = 5.9;
        double result4 = num1 * num2 * num3;


        System.out.println("Задание 5 и 6\n");
        Scanner scanner = new Scanner(System.in);
        while (true){
            int num4 = scanner.nextInt() ;
            if(num4 < 100){
                if (num4 % 2 == 0){
                    System.out.println("Четное");
                } else {
                    System.out.println("Нечетное");
                }
            } else {
                System.out.println("Выход за пределы диапазона");
            }

        }
    }


}
