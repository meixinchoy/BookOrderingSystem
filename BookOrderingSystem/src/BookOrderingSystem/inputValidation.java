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
public class inputValidation {

    public static int IntegerValidation(int numOfChoices) {
        Scanner scanner = new Scanner(System.in);
        boolean isNotValid = false;
        String numberStr;
        int number = -1;
        do {
            isNotValid = false;
            System.out.print("Please enter 1");
            for (int i = 2; i <numOfChoices; i++) { //list all available selections of the user
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
    
        public static double CashValidation(Cash cash) {
        Scanner scanner = new Scanner(System.in);
        boolean isNotValid = false;
        String numberStr;
        double number = -1;
        do {
            isNotValid = false;
            System.out.println("Please enter cash payment: ");
            
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
        return number;
    }

    public static char CharValidation() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        boolean isNotValid = false;
        do {
            isNotValid = false;
            System.out.print("Please enter y or n: ");
            choice = scanner.nextLine().trim();
            if (choice.length() > 1 || !(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n"))) {
                System.out.printf("Choice \"%s\" is not available.\n", choice);
                isNotValid = true;
            }
        } while (isNotValid);
        return choice.toLowerCase().charAt(0);
    }

}
