package tasks;

import java.util.Scanner;

public class Homework1 {
    static Scanner scanner = new Scanner(System.in);

    public static void runTasks() {
        task1();
        task2();
        task3();
        task4();
    }
    public static void task1() {
        System.out.println("Задание 1:");
        int in = scanner.nextInt();
        System.out.println( in % 2 == 0 ? "чет" : "нечет");
    }

    public static void task2() {
        System.out.println("Задание 2:");
        int t = scanner.nextInt();
        System.out.println( t > -5 ? "warm" : t > -20 ? "normal" : "cold");
    }

    public static void task3() {
        System.out.println("Задание 3:");
        for (int i = 10; i < 21; i++) {
            System.out.println(i * i);
        }
    }

    public static void task4() {
        System.out.println("Задание 4:");
        for (int i = 1; i <= 14; i++) {
            System.out.print(7 * i + (i == 14 ? "\n" : " "));
        }
    }
}
