package tasks;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    static Scanner scanner = new Scanner(System.in);
    static final char empty = '-';
    static final char tic = 'X';
    static final char tac = 'O';
    static final int gameSize = 3;

    public static void run() {
        int gameTicks = 1;
        char[][] field = getNewField();
        printField(field);
        while (true) {
            gameTicks++;
            playerMove(field);
            checkWin(field, gameTicks);
            computerMove(field);
            printField(field);
            checkWin(field, gameTicks);
        }
    }

    private static void checkWin(char[][] field, int gameTicks) {
        char[] playerWin = new char[gameSize];
        Arrays.fill(playerWin, tic);
        char[] playerLoose = new char[gameSize];
        Arrays.fill(playerLoose, tac);

        char[][] transposedField = new char[gameSize][gameSize];
        char[] mainDiagonal = new char[gameSize];
        char[] secondDiagonal = new char[gameSize];

        for (int i = 0; i < gameSize; i++) {
            if (Arrays.equals(field[i], playerWin)) {
                win();
            } else if (Arrays.equals(field[i], playerLoose)) {
                loose();
            }
            mainDiagonal[i] = field[i][i];
            secondDiagonal[i] = field[i][gameSize - i - 1];
            for (int j = 0; j < gameSize; j++) {
                transposedField[i][j] = field[j][i];
            }
        }

        for (int i = 0; i < gameSize; i++) {
            if (Arrays.equals(transposedField[i], playerWin)) {
                win();
            } else if (Arrays.equals(mainDiagonal, playerWin) | Arrays.equals(secondDiagonal, playerWin)) {
                win();
            } else if (Arrays.equals(mainDiagonal, playerLoose) | Arrays.equals(secondDiagonal, playerLoose)) {
                loose();
            } else if (Arrays.equals(transposedField[i], playerLoose)) {
                loose();
            }
        }

        if (gameTicks >= gameSize * gameSize) {
            loose();
        }
    }

    private static void win() {
        System.out.println("Вы выиграли");
        System.exit(0);
    }

    private static void loose() {
        System.out.println("Вы проиграли");
        System.exit(0);
    }

    private static void computerMove(char[][] field) {
        boolean isLegalMove = false;
        while (isLegalMove == false) {
            int x = (int) Math.floor(Math.random() * gameSize);
            int y = (int) Math.floor(Math.random() * gameSize);

            if (field[x][y] == empty) {
                field[x][y] = tac;
                isLegalMove = true;
            }
        }
    }

    private static void playerMove(char[][] field) {
        System.out.println("Ваш ход, введите координаты вашего крестика:");
        boolean isLegalMove = false;
        while (isLegalMove == false) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;

            //можно использовать исключение, но мы пока "не умеем"
            if (x < gameSize && y < gameSize && field[x][y] == empty) {
                field[x][y] = tic;
                isLegalMove = true;
            } else {
                System.out.println("Такой ход невозможен, повторите ввод.");
            }
        }

    }

    private static char[][] getNewField() {
        char[][] field = new char[gameSize][gameSize];
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                field[i][j] = empty;
            }
        }
        return field;
    }

    private static void printField(char[][] field) {
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                System.out.print(field[i][j] + (j == gameSize - 1 ? "\n" : " "));
            }
        }
    }


}
