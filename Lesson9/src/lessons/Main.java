package lessons;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

    }

    int findMax(int[] array) throws Exception {
        if (array.length <= 0)
            throw new Exception();

        int max = array[0];
        for (int a : array) {
            max = max > a ? max : a;
        }

        return max;
    }

    boolean isSquare(int[][] array) throws Exception {
        if (array.length <= 0 || array[0].length <= 0)
            throw new Exception();

        if (array.length == array[0].length) {
            return true;
        } else {
            return false;
        }
    }

    int maxRow(int[][] array) throws Exception {
        if (array.length <= 0 || array[0].length <= 0)
            throw new Exception();

        int row = 0;
        int max = 0;
        int maxNext = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                maxNext += array[i][j];
            }
            if (i == 0) {
                max = maxNext;
                continue;
            }
            if (max > maxNext) {
                continue;
            } else {
                row = i;
            }
        }
        return row;
    }

    void randomArray(char [][] array) throws Exception {
        if (array.length <= 0 || array[0].length <= 0)
            throw new Exception();

        char[] alphabetA = new
                String("abcdefghijklmnopqrstuvwxyz0123456789").toCharArray();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = alphabetA[new Random().nextInt(alphabetA.length)];
            }
        }
    }
}
