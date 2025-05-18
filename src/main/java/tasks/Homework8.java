package tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Homework8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[3];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = scanner.nextLine();
        }
        task1(strings);
        task2(strings);
        task3(strings);
        task4(strings);
        task5(strings);
    }

    private static void task1(String[] strings) {
        System.out.println("Задача 1 ========================");
        List<String> ordered = Arrays.stream(strings).sorted(Comparator.comparing(String::length)).toList();
        String shorter = ordered.getFirst();
        String longer = ordered.getLast();
        System.out.printf("Самая короткая строка с длинной %d:\n %s\nСамая длинная строка с длинной %d:\n %s\n", shorter.length(), shorter, longer.length(), longer);
    }

    private static void task2(String[] strings) {
        System.out.println("Задача 2 ========================");
        List<String> ordered = Arrays.stream(strings).sorted(Comparator.comparing(String::length)).toList();
        System.out.printf("Строки в порядке их длины:\n%s\n%s\n%s\n", ordered.get(0), ordered.get(1), ordered.get(2));
    }

    private static void task3(String[] strings) {
        System.out.println("Задача 3 ========================");
        double middle = ((double) Arrays.stream(strings).mapToInt(String::length).sum()) / 3;
        System.out.printf("Строки с длиной меньше средней (%.2f):\n", middle);
        List<String> result = Arrays.stream(strings).filter(s -> (s.length() < middle)).toList();
        for (String item: result) {
            System.out.printf("\"%s\" с длиной %d\n", item, item.length());
        }
    }

    private static void task4(String[] strings) {
        System.out.println("Задача 4 ========================\nСлово из уникальных букв:");
        loop:
        for (String item : strings) {
            String[] words = item.split("[\\s\\p{Punct}]");
            for (String word : words) {
                boolean flag = true;
                String tempWord = word;
                if (tempWord.isEmpty()) {
                    continue;
                }
                for (int i = 0; i < tempWord.length();i++) {

                    char ch = tempWord.charAt(0);
                    tempWord = tempWord.substring(1);
                    if (tempWord.indexOf(ch) >= 0) {
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.println(word);
                    break loop;
                }
            }
        }
    }

    private static void task5(String[] strings) {
        System.out.println("Задача 5 ========================\nДублирование символов:");
        for (String item : strings) {
            StringBuilder builder = new StringBuilder(item);
            for (int i = 0; i < builder.length(); i+=2) {
                builder.insert(i, builder.charAt(i));
            }
            System.out.println(builder);
        }
    }
}
