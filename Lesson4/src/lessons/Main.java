package lessons;

public class Main {

    public static void main(String[] args) {
        // task 1
      /*  String[] catsNames = {
                "Васька",
                "Кузя",
                "Барсик",
                "Мурзик",
                "Леопольдllll",
                "Бегемот",
                "Рыжик",
                "Матроскин"
        };*/

        //  System.out.println(findLongest(catsNames));


        //task 2


        //    System.out.println(palindrome("torokkt"));

        // task 3
        //  System.out.println(censored("кака бяка кулебяка бяка"));

        // task 4
/*
        String sub = "sub";
        String target = "subdnlksdnvlknfsdlksubdlmfdsmlfsdm;lfdsml;sub";
        System.out.println(subString(target,sub));
*/

        // task 5
     //   String testString = "This is a test string";
     //   System.out.println(reversedStr(testString));
    }


    public static String findLongest(String[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        String longest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > longest.length()) {

                longest = arr[i];
            }
        }
        return longest;
    }

    public static boolean palindrome(String str) {

        if (str == null || str.equals("")) return false;
        if (str.length() == 1) return true;
        if (str.length() % 2 == 0) {
            for (int i = 0, j = str.length() - 1; i <= str.length() / 2; i++, j--) {
                if (str.charAt(i) == str.charAt(j)) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 0, j = str.length() - 1; i <= str.length() / 2 + 1; i++, j--) {
                if (i == str.length() / 2 + 1) {
                    return true;
                }
                if (str.charAt(i) == str.charAt(j)) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }

    }

    public static String censored(String str) {

        StringBuilder stringBuilder = new StringBuilder();
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {

            if (words[i].equals("бяка")) {
                words[i] = "[вырезано цензурой]";
            }
            if (i == 0) {
                stringBuilder.append(words[i]);
            } else {
                stringBuilder.append(" " + words[i]);
            }
        }

        return stringBuilder.toString();
    }

    public static int subString(String target, String sub) {

        int counter = 0;
        for (int i = 0; i < target.length() - sub.length() + 1; i++) {
            if (target.substring(i, i + sub.length()).equals(sub)) {
                counter++;
            }
        }
        return counter;
    }

    public static String reversedStr(String str) {

        StringBuilder stringBuilder = new StringBuilder();
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {

            if (i == 0) {
                stringBuilder.append(new StringBuilder(words[i]).reverse().toString());
            } else {
                stringBuilder.append(" " + new StringBuilder(words[i]).reverse().toString());
            }
        }

        return stringBuilder.toString();
    }


}
