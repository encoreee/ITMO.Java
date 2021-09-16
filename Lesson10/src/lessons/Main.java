package lessons;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        colTimeCheck(new ArrayList(), new LinkedList());
    }

    static <T> void CollectionUnique(Collection<T> col, Collection<T> tar) {
        Set<T> set = new HashSet<T>(col);
        for (T o : set) {
            tar.addAll(set);
        }
    }

    static void colTimeCheck(ArrayList a, LinkedList b) {

        {
            int max = 100;
            int min = 0;
            System.out.println("Arraylist add");
            Instant starts = Instant.now();

            for (int i = 0; i < 1000000; i++) {
                Random random = new Random();
                a.add(random.ints(min, max).findFirst().getAsInt());
            }
            Instant ends = Instant.now();
            System.out.println(Duration.between(starts, ends).getNano());
        }
        {
            int max = 1000000;
            int min = 0;
            System.out.println("Arraylist select");
            Instant starts = Instant.now();

            for (int i = 0; i < 1000000; i++) {
                Random random = new Random();
                int val = (int) a.get(random.ints(min, max).findFirst().getAsInt());
            }
            Instant ends = Instant.now();
            System.out.println(Duration.between(starts, ends).getNano());
        }
        {
            int max = 100;
            int min = 0;
            Instant starts = Instant.now();

            System.out.println("LinkedList add");
            for (int i = 0; i < 1000000; i++) {
                Random random = new Random();
                b.add(random.ints(min, max).findFirst().getAsInt());
            }
            Instant ends = Instant.now();
            System.out.println(Duration.between(starts, ends).getNano());
        }
        {
            int max = 1000000;
            int min = 0;
            System.out.println("LinkedList select");
            Instant starts = Instant.now();

            for (int i = 0; i < 100; i++) {
                Random random = new Random();
                int val = (int) b.get(random.ints(min, max).findFirst().getAsInt());
            }
            Instant ends = Instant.now();
            System.out.println(Duration.between(starts, ends).getNano());
        }
    }

    static void game() {
        Map<User, Integer> players = new HashMap<User, Integer>();
        int max = 100;
        int min = 0;
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            String name = "User " + i;
            players.put(new User(name), random.ints(min, max).findFirst().getAsInt());
        }

        for (;;) {
            Scanner in = new Scanner(System.in);
            System.out.print("Input name or \"exit\":");
            String find = in.toString();
            if (find.equals("exit")) {
                break;
            }
            boolean check = false;
            for (Map.Entry<User, Integer> entry : players.entrySet()) {
                if (entry.getKey().getName().equals(find)) {
                    System.out.println(players.get(entry.getKey().getName()) + " " + entry.getValue());
                    check = true;
                    in.close();
                    break;
                }
            }
            if (!check){
                System.out.println("not found");
            }
        }
    }

    static <K> Map<K, Integer> arrayToMap(K[] ks){
        Map<K, Integer> entries =  new HashMap<K, Integer>();
        for (K a: ks) {
            Set<K> keys = entries.keySet();
            if(keys.contains(a)){
                entries.put(a, entries.get(a) + 1);
            } else {
                entries.put(a, 1) ;
            }
        }
        return entries;
    }
}
