package tasks.homework9;

import java.util.*;

public class Homework9 {
    static Scanner scanner = new Scanner(System.in);

    public static void task1() {
        Set<Integer> numbers = new HashSet<>();
        String[] line = scanner.nextLine().split(",");
        for (String s : line) {
            numbers.add(Integer.parseInt(s.trim()));
        }

        System.out.println(numbers);
    }

    public static void task2() {
        System.out.println(AnimalStorage.getString());

        AnimalStorage.addAnimal("Краб");
        AnimalStorage.addAnimal("Лемур");
        AnimalStorage.removeAnimal();

        System.out.println(AnimalStorage.getString());

    }

    public static void task3() {
        String[] strings = {"aaa","aaa","bbb","bbb","ab","ba","aaa","bba","aba"};
        Map<String, Boolean> map = new HashMap<>();
        for (String s: strings) {
            if (!map.containsKey(s)) {
                map.put(s, false);
            } else {
                map.put(s, true);
            }
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }
}
