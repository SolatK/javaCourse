package tasks.atm;

import static java.lang.Math.min;

public class ATM {
    private long banknote20;
    private long banknote50;
    private long banknote100;

    public ATM(long banknote20, long banknote50, long banknote100) {
        this.banknote20 = banknote20;
        this.banknote50 = banknote50;
        this.banknote100 = banknote100;
    }

    public boolean withdrawMoney(long moneyToWithdraw) {
        long sum = banknote20 * 20 + banknote50 * 50 + banknote100 * 100;

        if (sum < moneyToWithdraw | moneyToWithdraw % 10 != 0) {
            System.out.print("Банкомат не может выдать такую сумму\n");
            return false;
        }

        long banknote100toDraw = 0;
        long banknote50toDraw = 0;
        long banknote20toDraw = 0;

        if (moneyToWithdraw / 10 % 10 % 2 == 1 & moneyToWithdraw > 100 & banknote50 > 0 & banknote20 >= 3) {
            banknote50toDraw = 1;
            banknote20toDraw = 3;
            moneyToWithdraw -= 110;
        }

        long delta = 0;
        if (moneyToWithdraw > 0) {
            delta = min(moneyToWithdraw / 100, banknote100 - banknote100toDraw);
            moneyToWithdraw -= min(moneyToWithdraw / 100, banknote100 - banknote100toDraw) * 100;
            banknote100toDraw += delta;
        }

        if (moneyToWithdraw > 0) {
            for (int i = 3; i > 0; i--) {
                if ((moneyToWithdraw - (50 * min(moneyToWithdraw / 50, banknote50))) % 20 != 0 & banknote20 > 0 & banknote20toDraw < banknote20 & moneyToWithdraw >= 20) {
                    banknote20toDraw++;
                    moneyToWithdraw -= 20;
                } else {
                    break;
                }
            }
        }

        if (moneyToWithdraw > 0) {
            delta = min(moneyToWithdraw / 50, banknote50 - banknote50toDraw);
            if (delta > 0 & (moneyToWithdraw - delta * 50) % 20 != 0) {
                delta -= 1;
                moneyToWithdraw -= min((moneyToWithdraw / 50) - 1, banknote50 - banknote50toDraw - 1) * 50;
                banknote50toDraw += delta;
            } else {
                moneyToWithdraw -= min(moneyToWithdraw / 50, banknote50 - banknote50toDraw) * 50;
                banknote50toDraw += delta;
            }
        }

        if (moneyToWithdraw > 0) {
                delta = min(moneyToWithdraw / 20, banknote20 - banknote20toDraw);
                moneyToWithdraw -= min(moneyToWithdraw / 20, banknote20 - banknote20toDraw) * 20;
                banknote20toDraw += delta;
        }


        if (moneyToWithdraw == 0 & banknote100toDraw <= banknote100 & banknote50toDraw <= banknote50 & banknote20toDraw <= banknote20) {
            banknote100 -= banknote100toDraw;
            banknote50 -= banknote50toDraw;
            banknote20 -= banknote20toDraw;
            System.out.printf(
                    "Выдано %d, количество купюр: %d по 100, %d по 50, %d по 20\n",
                    banknote100toDraw * 100 + banknote50toDraw * 50 + banknote20toDraw * 20,
                    banknote100toDraw,
                    banknote50toDraw,
                    banknote20toDraw
            );

            return true;
        }
        System.out.print("Банкомат не может выдать такую сумму\n");
        return false;
    }
}
