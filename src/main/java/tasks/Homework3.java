package tasks;

import java.util.Arrays;

public class Homework3 {
    public static void task1() {
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'j'};
        System.out.println(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void task2() {
        int[] arr = {5, 6, 3, 4, 5, 6, 8, 2};
        System.out.printf(
                "максимальное значение: %d, минимальное: %d\n",
                Arrays.stream(arr).max().getAsInt(),
                Arrays.stream(arr).min().getAsInt()
        );
    }

    public static void task3() {
        int[] arr = {5, 6, 3, 2, 5, 6, 8, 2};
        int iMin = 0;
        int iMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[iMax]) iMax = i;
            if (arr[i] < arr[iMin]) iMin = i;
        }
        System.out.printf("Индекс макс: %d, индекс мин: %d\n", iMax, iMin);
    }

    public static void task4() {
        int[] arr = {5, 6, 0, 2, 5, 0, 8, 2};
        int count = (int) Arrays.stream(arr).filter(a -> a == 0).count();
        System.out.println(count > 0 ? count : "нулевых элементов нет");
    }

    public static void task5() {
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'j'};
        for (int i = 0; i <= (arr.length - 1) / 2; i++) {
            char temp = arr[(arr.length - 1)- i];
            arr[(arr.length - 1) - i] =  arr[i];
            arr[i] = temp;
        }
        System.out.println(arr);
    }

    public static void task6() {
        int[] arr = {1, 3, 5, 50, 64, 66, 800, 20002};

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                System.out.println("Массив не возрастает");
                return;
            }
        }
        System.out.println("Массив возрастает");
    }
}
