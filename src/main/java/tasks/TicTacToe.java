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
        char[][] field = getNewField();
        printField(field);
        for (int turns = 0; true; turns++) {
            playerMove(field, (turns % 2) + 1);
            printField(field);
            checkWin(field, turns);
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
                win(1);
            } else if (Arrays.equals(field[i], playerLoose)) {
                win(2);
            }
            mainDiagonal[i] = field[i][i];
            secondDiagonal[i] = field[i][gameSize - i - 1];
            for (int j = 0; j < gameSize; j++) {
                transposedField[i][j] = field[j][i];
            }
        }

        for (int i = 0; i < gameSize; i++) {
            if (Arrays.equals(transposedField[i], playerWin)) {
                win(1);
            } else if (Arrays.equals(mainDiagonal, playerWin) | Arrays.equals(secondDiagonal, playerWin)) {
                win(1);
            } else if (Arrays.equals(mainDiagonal, playerLoose) | Arrays.equals(secondDiagonal, playerLoose)) {
                win(2);
            } else if (Arrays.equals(transposedField[i], playerLoose)) {
                win(2);
            }
        }

        if (gameTicks + 1 >= gameSize * gameSize) {
            draw();
        }
    }

    private static void win(int player) {
        System.out.printf("Игрок %d выиграл%n", player);
        System.exit(0);
    }
    private static void draw() {
        System.out.println("Ничья");
        System.exit(0);
    }

    private static void playerMove(char[][] field, int player) {
        System.out.printf("Ход игрока %d, введите координаты вашего хода:%n", player);
        boolean isLegalMove = false;
        while (!isLegalMove) {
            char playerSymbol = player == 1 ? tic : tac ;
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;

            //можно использовать исключение, но мы пока "не умеем"
            if (x < gameSize && y < gameSize && field[x][y] == empty) {
                field[x][y] = playerSymbol;
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