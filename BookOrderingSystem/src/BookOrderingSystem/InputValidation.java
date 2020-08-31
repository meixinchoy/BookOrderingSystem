/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookOrderingSystem;

import java.util.Scanner;

/**
 *
 * @author XM
 */
public class InputValidation {

    public static int integerValidation(int numOfChoices) {
        Scanner scanner = new Scanner(System.in);
        boolean isNotValid;
        String numberStr;
        int number = -1;
        do {
            isNotValid = false;
            System.out.print("Please enter 1");
            for (int i = 2; i < numOfChoices; i++) { //list all available selections of the user
                System.out.print(" or " + i);
            }
            System.out.print(": ");

            numberStr = scanner.nextLine().trim();
            try {
                number = Integer.parseInt(numberStr);
                if (number < 1 || number > numOfChoices - 1) {
                    System.out.printf("Choice \"%s\" is not available.\n", numberStr);
                    isNotValid = true;
                }
            } catch (Exception e) {
                System.out.printf("Choice \"%s\" is not available.\n", numberStr);
                isNotValid = true;
            }
        } while (isNotValid);
        return number;
    }

    public static void cardValidation(Card card){
        Scanner scanner = new Scanner(System.in);
        boolean isNotValid;
        String numberStr;
        do {
            isNotValid = false;
            System.out.print("Please enter your card number: ");
            numberStr = scanner.nextLine().trim();
            try {
                int cardNo = Integer.parseInt(numberStr);
                card.setCardNo(cardNo);
                //Card Number must be 8 digits long and valid
                if (!card.validCard() || numberStr.length() != 8) {
                    System.out.printf("%s is not a valid card number.\n", numberStr);
                    isNotValid = true;
                }
            } catch (Exception e) {
                System.out.printf("%s is not a valid card number.\n", numberStr);
                isNotValid = true;
            }
        } while (isNotValid);
    }
    
    public static void cashValidation(Cash cash) {
        Scanner scanner = new Scanner(System.in);
        boolean isNotValid;
        String numberStr;
        double number;
        do {
            isNotValid = false;
            System.out.print("Please enter cash payment: RM ");

            numberStr = scanner.nextLine().trim();
            try {
                number = Double.parseDouble(numberStr);
                cash.setCashReceived(number);
                if (cash.insufficientCash()) {
                    System.out.println("Insufficient Payment.");
                    isNotValid = true;
                }
            } catch (Exception e) {
                System.out.printf("\"%s\" is not a valid amount.\n", numberStr);
                isNotValid = true;
            }
        } while (isNotValid);
    }

    public static char charValidation() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        boolean isNotValid;
        do {
            isNotValid = false;
            System.out.print("Please enter y for yes or n for no: ");
            choice = scanner.nextLine().trim();
            if (choice.length() > 1 || !(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n"))) {
                System.out.printf("Choice \"%s\" is not available.\n", choice);
                isNotValid = true;
            }
        } while (isNotValid);
        return choice.toLowerCase().charAt(0);
    }

}
