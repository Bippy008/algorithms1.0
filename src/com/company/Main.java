package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] banknotes = {1, 3, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000};
        int[] quantities = {10, 5, 5, 3, 2, 1, 2, 3, 3, 2, 0, 2};
        String result = "";
        int countOfBanknotes, totalAvailable = 0;

        for (int i = 0; i < banknotes.length - 1; i++) {
            totalAvailable += banknotes[i] * quantities[i];
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("В банкомате " + totalAvailable + "  сом.");
        System.out.println("Введите желаемую сумму...");
        int withdraw = scanner.nextInt();
        int saveWithdraw = withdraw;

        if (totalAvailable < withdraw) {
            System.out.println("Недостаточно средств в банкомате.");
        } else {
            for (int i = banknotes.length - 1; i >= 0; i--) {
                System.out.println(0);
                if (withdraw >= banknotes[i] && quantities[i] > 0) {
                    countOfBanknotes = withdraw / banknotes[i];
                    if (countOfBanknotes <= quantities[i]) {
                        result += countOfBanknotes + "x" + banknotes[i] + " ";
                        quantities[i] -= countOfBanknotes;
                        totalAvailable -= countOfBanknotes * banknotes[i];
                        withdraw -= countOfBanknotes * banknotes[i];
                        if (totalAvailable == 0) {
                            break;
                        }
                    } else {
                        result += quantities[i] + "x" + banknotes[i];
                        quantities[i] = 0;
                        totalAvailable -= quantities[i] * banknotes[i];
                    }

                }
            }

            if (withdraw == 0) {
                System.out.println("Вы получили " + result);
                System.out.println("Всего " + saveWithdraw + ".");
            } else {
                System.out.println("Недостаточно средств в банкомате, " +
                        "запрашиваемая сумма не может быть выдана.");
            }
        }
    }
}

