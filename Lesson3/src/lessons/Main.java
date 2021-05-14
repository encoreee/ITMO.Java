package lessons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // Task 1

        //  int[] massiveTask1 = new int[]{0, 2, 1, 3, 4, 5};
        //    massiveSort(massiveTask1);


        // Task 2
        // massiveInput();

        // Task 3
        // int[] massiveTask2 = new int[]{0, 2, 1, 3, 4, 5};
        //   massiveSwap(massiveTask2);

        //  Task 4
        // int[] massiveTask4 = new int[]{0, 0, 1, 4, 1, 0};
        // massiveUnique(massiveTask4);

        //  Task 5
        //fibo(11);

        //  Task 6
        //   int[] massiveTask5 = new int[]{0, 2, 1, 3, 4, 5};
        //   int [] SortArray = sortArray(massiveTask5);
        //  for (int i = 0; i < SortArray.length; i++) {
        //       System.out.print(SortArray[i] + " ");
        //  }

        //  Task 7
     //   int[] massiveTask7 = new int[]{0, 2, 1, 3, 4, 5, 4, 3, 45, 67, 34, 4, 5, 67, 5, 4, 3, 6, 8, 8, 3, 0, 9, 8, 4, 3, 2, 3, 5, 6, 7, 8};
      //  int[] uniqueArr = frequentNum(massiveTask7, 3);

    }

    public static void massiveSort(int[] massive) {
        boolean result = true;

        for (int i = 1; i < massive.length; i++) {
            if (massive[i] >= massive[i - 1]) {
                continue;
            } else {
                result = false;
                break;
            }
        }
        if (result) {
            System.out.println("OK");
        } else {
            System.out.println("Please, try again");
        }

    }

    public static void massiveInput() throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter massive length");
        int length = Integer.parseInt(reader.readLine());
        System.out.println(String.format("Please enter %d numbers", length));
        int[] massive = new int[length];

        for (int i = 0; i < length; i++) {
            massive[i] = Integer.parseInt(reader.readLine());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < massive.length; i++) {
            if (i == 0) {
                stringBuilder.append("[");
            }
            stringBuilder.append(massive[i]);
            if (i == massive.length - 1) {
                stringBuilder.append("]");
            } else {
                stringBuilder.append(", ");
            }
        }
        System.out.println("Result: " + stringBuilder.toString());
    }

    public static void massiveSwap(int[] massive) {

        int first = massive[0];
        int last = massive[massive.length - 1];

        massive[0] = last;
        massive[massive.length - 1] = first;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < massive.length; i++) {
            if (i == 0) {
                stringBuilder.append("[");
            }
            stringBuilder.append(massive[i]);
            if (i == massive.length - 1) {
                stringBuilder.append("]");
            } else {
                stringBuilder.append(", ");
            }
        }
        System.out.println("Result: " + stringBuilder.toString());

    }

    public static void massiveUnique(int[] massive) {
        int unique = massive[0];
        boolean result = false;

        for (int i = 1; i < massive.length; i++) {
            if (result) {
                break;
            }
            if (massive[i] == massive[i - 1]) {
                continue;
            } else {
                unique = massive[i];
                for (int j = i + 1; j < massive.length; j++) {
                    if (massive[i] == massive[j]) {
                        result = false;
                        break;
                    }
                    if (j == massive.length - 1) {
                        result = true;
                    }
                }

            }
        }

        if (!result) {
            System.out.println("No unique numbers");
        } else {
            System.out.println(unique);
        }


    }

    public static void fibo(int number) {
        int n0 = 1;
        int n1 = 1;
        int result = 0;

        if (number == 1 || number == 2) {
            System.out.println("1");
        } else {
            for (int i = 3; i <= number; i++) {
                result = n0 + n1;
                n0 = n1;
                n1 = result;
            }
            System.out.println(result);
        }
    }

    public static int[] sortArray(int[] array) {
        if (array == null) {
            return null;
        }
        int length_arr = array.length / 2;
        if (array.length < 2) {
            return array;
        }
        if (array.length % 2 != 0) {
            length_arr += 1;
        }
        int[] arrayR = new int[length_arr];
        int[] arrayL = new int[array.length / 2];

        for (int i = 0; i < array.length / 2; i++) {
            arrayL[i] = array[i];

        }
        for (int i = array.length / 2; i < array.length; i++) {
            arrayR[i - array.length / 2] = array[i];

        }
        arrayL = sortArray(arrayL);
        arrayR = sortArray(arrayR);

        return mergeArray(arrayL, arrayR);
    }

    public static int[] mergeArray(int[] arrayL, int[] arrayR) {

        int[] arrayC = new int[arrayL.length + arrayR.length];
        int posL = 0, posR = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (posL < arrayL.length && posR < arrayR.length) {
                if (arrayL[posL] < arrayR[posR]) {
                    arrayC[i] = arrayL[posL];
                    posL++;
                } else {
                    arrayC[i] = arrayR[posR];
                    posR++;
                }
            } else if (posL == arrayL.length && posR < arrayR.length) {
                arrayC[i] = arrayR[posR];
                posR++;
            } else if (posL < arrayL.length && posR == arrayR.length) {
                arrayC[i] = arrayL[posL];
                posL++;
            } else {
                arrayC[i] = 0;
            }
        }
        return arrayC;
    }

    public static int[] frequentNum(int[] array, int magicNum) {

        if (array == null) {
            return null;
        }

        if (magicNum < 1) {
            return null;
        }

        int[] resArray = new int[magicNum];
        int[] targets = new int[array.length];
        int[] mask = new int[array.length];
        int targetsCounter = 0;

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            boolean exist = false;

            for (int j = i - 1; j >= 0; j--) {
                if (array[i] == array[j]) {
                    i++;
                    exist = true;
                    break;
                }
            }

            if (exist) {
                continue;
            }

            targets[targetsCounter] = number;
            int maskCounter = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    maskCounter++;
                }
            }
            mask[targetsCounter] = maskCounter;
            targetsCounter++;

        }
        int[] finalTargets = new int[targetsCounter];
        int[] finalMask = new int[targetsCounter];

        for (int i = 0; i < targetsCounter; i++) {
            finalTargets[i] = targets[i];
            finalMask[i] = mask[i];
        }


        int tempT = 0;
        int tempM = 0;

        for (int i = 0; i < targetsCounter; i++) {
            for (int j = 1; j < (targetsCounter - i); j++) {
                if (finalMask[j - 1] < finalMask[j]) {

                    tempM = finalMask[j - 1];
                    finalMask[j - 1] = finalMask[j];
                    finalMask[j] = tempM;
                    tempT = finalTargets[j - 1];
                    finalTargets[j - 1] = finalTargets[j];
                    finalTargets[j] = tempT;
                }
            }
        }

        for (int i = 0; i < magicNum; i++) {
            resArray[i] = finalTargets[i];
        }
        return resArray;
    }
}