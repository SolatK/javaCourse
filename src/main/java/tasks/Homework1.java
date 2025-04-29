package tasks;

import java.util.stream.Collectors;

public class Homework1 {
    public static void runTasks() {
        task1();
        task2();
        task3();
        task4();
        task5();
    }
    public static void task1() {
        int b = 4;
        int c = 5;

        int a = 4 * (b + c - 1 ) / 2;
        System.out.println(a);
    }

    public static void task2() {
        int n = 47;
        int summ = (n % 10) + (n / 10);
        System.out.println(summ);
    }

    public static void task3() {
        int n = 738;
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n = n / 10;
        }
        System.out.println(result);
    }

    public static void task4() {
        double n = 5.9234;
        int a = (int) Math.round(n);
        System.out.println(a);
    }

    public static void task5() {
        int q, w;
        q = 43;
        w = 3;
        System.out.printf("%d / %d = %d и %d в остатке", q, w, q / w, q % w);
    }
}
