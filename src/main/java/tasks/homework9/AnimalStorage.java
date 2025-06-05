package tasks.homework9;

import java.util.ArrayDeque;
import java.util.Deque;

public class AnimalStorage {
    private static Deque<String> animals = new ArrayDeque<>();

    static {
        animals.add("Рысь");
        animals.add("Дракон");
        animals.add("Медведь");
        animals.add("Рыба");
    }

    public static String getString() {
        String result = "";
        for (String animal: animals) {
            result += animal + ", ";
        }
        return result;
    }

    public static void addAnimal(String animal) {
        animals.addFirst(animal);
    }

    public static void removeAnimal() {
        animals.pollLast();
    }
}
