package lessons;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            List<String> result = fileToListReader();
            System.out.println(result);
            System.out.println(fileStringReader());
            connectFiles();
            fileCopy();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> fileToListReader() throws IOException {
        String fileName = "D:/Repository/ITMO.Java/Lesson11a/src/lessons/fileTest.txt";
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static String fileStringReader() throws IOException {
        String fileName = "D:/Repository/ITMO.Java/Lesson11a/src/lessons/fileTest.txt";

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static void connectFiles() throws IOException {
        String fileName = "D:/Repository/ITMO.Java/Lesson11a/src/lessons/fileTest.txt";
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter writer = new FileWriter("D:/Repository/ITMO.Java/Lesson11a/src/lessons/fileTest2.txt", true);
        for (String str : list) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }

    public static void fileCopy() throws IOException {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(
                    "D:/Repository/ITMO.Java/Lesson11a/src/lessons/fileTest.txt");
            fos = new FileOutputStream(
                    "D:/Repository/ITMO.Java/Lesson11a/src/lessons/fileTest2.txt");
            int c;
            while ((c = fis.read()) != -1) {
                fos.write(c);
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

    public static List<File> fileByString(String path, String str) {
        File dir = new File(path);
        List<File> files = new LinkedList<>();
        if (!dir.exists()) {
            return null;
        } else {
            if (!dir.isDirectory()) {
                return null;
            } else {
                for (File item : dir.listFiles()) {
                    if (item.isDirectory()) {
                    } else {
                        if (item.getName().contains(str)) {
                            files.add(item);
                        }
                    }
                }
            }
        }
        return files;
    }

    public static List<String> fileByString(String path, String str, String ext) {
        File dir = new File(path);
        List<String> files = new LinkedList<>();
        if (!dir.exists()) {
            return null;
        } else {
            if (!dir.isDirectory()) {
                return null;
            } else {
                for (File item : dir.listFiles()) {
                    if (item.isDirectory()) {
                    } else {
                        if (item.getName().endsWith(ext) && item.getName().contains(ext)) {
                            files.add(item.getName());
                        }
                    }
                }
            }
        }
        return files;
    }

}
