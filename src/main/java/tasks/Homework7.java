package tasks;

import java.util.Random;

public class Homework7 {
    public static void main(String[] args) {
        method1(1);
        method2(2);
        method3(3);
        method4(4);
    }

    public static void method1(int i) {
        try {
            i = i / 0;
        } catch (ArithmeticException e) {
            System.out.println("Увы");
        }
    }

    public static void method2(int i) {
        int[] arr = new int[1];
        try {
            System.out.println(Math.random() > 0.5 ? i/0 : arr[2] + i);
        } catch (ArithmeticException e) {
            System.out.println("Увы");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("За гранью");
        }
    }

    public static void method3(int i) {
        int[] arr = new int[1];
        try {
            System.out.println(Math.random() > 0.5 ? i/0 : arr[2] + i);
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Как же так");
        }
    }

    public static void method4(int i) {
        try {
            i += i;
        } catch (Throwable t) {
            //todo
        } finally {
            System.out.println("hello world");
        }
    }
}
