package lessons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        odder(); // task 1
        divider(); // task 2
        boolean result1 = multiplier(); // task 3
        System.out.println("Результат: " + result1);
        boolean result2 = comparator(); // task 4
        System.out.println("Результат: " + result2);
        int[] massive = new int[]{3, -3, 7, 4, 5, 4, 3}; // task 5
        boolean result3 = massiveChecker1(massive, 3);
        System.out.println("Результат: " + result3);
        boolean result4 = massiveChecker2(massive); // task 6
        System.out.println("Результат: " + result4);
    }

    public static void odder() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void divider() {

        StringBuffer strBuffer1 = new StringBuffer();
        strBuffer1.append("Делится на 3: ");
        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0) {
                strBuffer1.append(" " + i);
            }
        }
        System.out.println(strBuffer1.toString());

        StringBuffer strBuffer2 = new StringBuffer();
        strBuffer2.append("Делится на 5: ");
        for (int i = 1; i < 100; i++) {
            if (i % 5 == 0) {
                strBuffer2.append(" " + i);
            }
        }
        System.out.println(strBuffer2.toString());

        StringBuffer strBuffer3 = new StringBuffer();
        strBuffer3.append("Делится на 3 и на 5: ");
        for (int i = 1; i < 100; i++) {
            if ((i % 5 == 0) && (i % 3 == 0)) {
                strBuffer3.append(" " + i);
            }
        }
        System.out.println(strBuffer3.toString());

    }

    public static boolean multiplier() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите первое число: ");
        int first = Integer.parseInt(reader.readLine());
        System.out.println("Введите второе число: ");
        int second = Integer.parseInt(reader.readLine());
        System.out.println("Введите третье число: ");
        int third = Integer.parseInt(reader.readLine());

        if ((first + second) == third) {
            return true;
        } else return false;
    }

    public static boolean comparator() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите первое число: ");
        int first = Integer.parseInt(reader.readLine());
        System.out.println("Введите второе число: ");
        int second = Integer.parseInt(reader.readLine());
        System.out.println("Введите третье число: ");
        int third = Integer.parseInt(reader.readLine());

        if ((first < second) && (third > second)) {
            return true;
        } else return false;
    }

    public static boolean massiveChecker1(int[] massive, int number) {

        if ((massive[0] == number) && (massive[massive.length - 1] == number)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean massiveChecker2(int[] massive) {
        boolean res = false;
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] == 1 || massive[i] == 3) {
                res = true;
            }
        }
        return res;
    }
}