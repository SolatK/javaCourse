package tasks;

public class Tasks {
    public static void task1() {
        float b = 10;
        float c = 30;
        float a = 4 * (b + c - 1) / 2;
        System.out.println(a);
    }

    public static void task2(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n = n / 10;
        }
        System.out.println(result);
    }

    public static void task3(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n = n / 10;
        }
        System.out.println(result);
    }

    public static void task4(float n) {
        int result = (int) (n - (n % 1));
        System.out.println(result);
    }

    public static void task5(int q, int w) {
        int result = q / w;
        int left = q % w;
        System.out.println(String.format("Результат %d, остаток %d", result, left));
    }
}
