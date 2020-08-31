/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookOrderingSystem;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class BookOrderingSystemDriverFile {

    public static void main(String[] args) throws IOException {

        char nextPurchase = 'y';
        Scanner scanner = new Scanner(System.in);
        final String[] MONTHS = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
        int[] booksBoughtPerMonth = new int[12];
        double[] expenditurePerMonth = new double[12];

        do {
            //display the menu options for the user
            System.out.println("       Welcome to The Bookstore");
            System.out.println("\n  1. Order New Custom Book");
            System.out.println("  2. View Monthly Purchase History");
            System.out.println("  3. Exit\n");
            int menuChoice = InputValidation.integerValidation(4);

            switch (menuChoice) {
                case 1:
                    char cont = 'y';
                    // array for prompts
                    String[][] customization = {{"\nSelect Size", "Normal Size (Default [A5]: 148 x 210)", String.format("%-27s%-20s", "Large Size [A4]:210 x 297","+RM5")},
                    {"\nSelect Cover Material", "Paperback (Default)", String.format("%-27s%-20s", "Hardcover","+RM8")},
                    {"\nSelect Color of Cover", "Black(Default)", "Blue", "Yellow", "Green", "Pink"},
                    {"\nSelect Page GSM", "80 GSM (Default)", String.format("%-27s%-20s", "120 GSM","+RM5")},
                    {"\nSelect Page Style", "Blank (Default)", String.format("%-27s%-20s", "Lined","+RM2"), String.format("%-27s%-20s", "Grided","+RM3")},
                    {"\nDo you Want A Calendar", "No Calendar (Default)", String.format("%-27s%-20s", "Add Calendar","+RM6")},
                    {"\nDo you Want A Pen Holder", "No Pen Holder (Default)", String.format("%-27s%-20s", "Add Pen Holder","+RM10")}};
                    int[] choices = new int[customization.length]; // array for storing user's choices
                    Cart cart = new Cart(); // cart to store books to be purchased

                    System.out.println("\n\n\n        Order New Custom Book");
                    System.out.println("    =============================");

                    while (cont == 'y') {
                        char confirmSelection = 'n';
                        while (confirmSelection == 'n') {
                            System.out.println("the Basic Book is RM15");
                            for (int i = 0; i < choices.length; i++) { // loop each customization available
                                for (int j = 0; j < customization[i].length; j++) { // loop each prompt for each customization option
                                    if (j != 0) {
                                        System.out.print(j + ". ");
                                    }
                                    System.out.println(customization[i][j]); // output choices
                                }
                                choices[i] = InputValidation.integerValidation(customization[i].length); //let user to enter selection
                            }
                            System.out.printf("\n\n%-27s%-20s\n","Basic Book", " RM15");
                            for (int i = 0; i < choices.length; i++) {
                                System.out.println("-" + customization[i][choices[i]]); //displays user's selections
                            }
                            System.out.print("\nConfirm Customisation?\n");
                            confirmSelection = InputValidation.charValidation(); //Let user confirm customization
                        }                                                        //reloop if not confirmed

                        Book book = new BasicBook();        //create BasicBook object
                        //based on user's choice of accessory, add decoration to book object

                        book = new AddSize(book, choices[0]);   //add hardcover if choices[0] equals to 2

                        book = new AddHardCover(book, choices[1]);   //Upsize if choices[1] equals to 2

                        book = new AddCoverColor(book, choices[2]); //add page style of book

                        book = new AddPageGSM(book, choices[3]);    //increase PageGSM if choices[3] equals to 2

                        book = new AddPageStyle(book, choices[4]); //add page style if choices[4] more than 1

                        if (choices[5] == 2) {
                            book = new AddCalendar(book);       //add calendar if choices[5] equals to 2
                        }
                        if (choices[6] == 2) {
                            book = new AddPenHolder(book);      //add pen holder if choices[6] equals to 2
                        }
                        cart.addBook(book);                 // add book to cart

                        Date date = new Date();             //obtain the date (month) of purchase for record keeping
                        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        int monthPurchased = localDate.getMonthValue();

                        for (int i = 0; i < booksBoughtPerMonth.length; i++) {
                            //record the book sold and the cost based on the month purchased
                            if (monthPurchased == i + 1) {
                                booksBoughtPerMonth[i] += 1;
                                expenditurePerMonth[i] += book.getPrice();
                            }
                        }

                        System.out.print("\nDo You Want To Order Another Book?\n");  // ask if user wants to order another book
                        cont = InputValidation.charValidation();      //user enter input
                    }   //loop back if user wants to order another book
                    //displays total amount to be paid and prompts for user's choice of payment method
                    System.out.printf("\nTotal Amount due: RM %.2f", cart.getTotalPrice());
                    System.out.println("\nDo you want to pay with card(1) or cash?(2)");
                    int paymentType = InputValidation.integerValidation(3);
                    Payment payment;    //variable for holding user's payment details
                    if (paymentType == 1) { //Pay by Card
                        System.out.println("");
                        payment = new Card(cart);
                        InputValidation.cardValidation((Card) payment);
                    } else {//Pay by Cash
                        System.out.println("");
                        payment = new Cash(cart);
                        InputValidation.cashValidation((Cash) payment);
                    }

                    System.out.println(payment.generateReceipt());
                    System.out.println("Return to Main Menu To Continue Browsing?");
                    nextPurchase = InputValidation.charValidation();
                    if (nextPurchase == 'y') {
                        System.out.println("\n\n\n");
                    }
                    break;

                case 2:
                    //Display the monthly purchase history
                    boolean printed = false;
                    System.out.println("\n\n\n        Monthly Purchase History");
                    System.out.println("    ================================");
                    for (int i = 0; i < MONTHS.length; i++) {
                        if (expenditurePerMonth[i] > 0) {
                            System.out.printf("  Number of books bought in %s : %s\n", MONTHS[i], booksBoughtPerMonth[i]);
                            System.out.printf("  Total expenditure : RM %.2f\n\n", expenditurePerMonth[i]);
                            printed = true;
                        }
                    }
                    if (!printed) {     //If no purchases has been made
                        System.out.println("          No purchase history.\n");
                    }
                    System.out.println("Press enter to continue...");
                    scanner.nextLine();
                    System.out.println("\n\n");
                    continue;

                default:
                    nextPurchase = 'n'; //exits the program
                    break;
            }
        } while (nextPurchase == 'y');
        System.out.println("\n\nThank you for browsing with us!");
    }
}
