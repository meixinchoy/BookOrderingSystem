/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookOrderingSystem;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author kenne
 */
public class BookDecoratorPatternDemo {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        char cont = 'y';
        Scanner scanner = new Scanner(System.in);

        // array for prompts
        String[][] customization = {{"\nSelect Size", "Normal Size (Default [A5]: 148 x 210)", "Large Size [A4] (210 x 297)"},
                                    {"\nSelect Cover Material", "Paperback (Default)", "Hardcover"},
                                    {"\nSelect Color of Cover", "Black(Default)","Blue", "Yellow", "Green", "Pink"},
                                    {"\nSelect Page GSM", "80 GSM (Default)", "120 GSM"},
                                    {"\nSelect Page Style", "Blank (Default)", "Lined", "Grided"},
                                    {"\nDo you Want A Calendar", "No Calendar (Default)", "Add Calendar"},
                                    {"\nDo you Want A Pen Holder", "No Pen Holder (Default)", "Add Pen Holder"}};
        int[] choices = new int[customization.length]; // array for storing user's choices
        Cart cart = new Cart(); // cart to store books
        while (cont == 'y') {
            char confirmSelection = 'n';
            while (confirmSelection == 'n') {
                for (int i = 0; i < choices.length; i++) { // loop each customization choice
                    for (int j = 0; j < customization[i].length; j++) { // loop each prompt for each customization
                        if (j != 0) {
                            System.out.print(j + ". ");
                        }
                        System.out.println(customization[i][j]); // output choices
                    }
                    choices[i] = inputValidation.IntegerValidation(customization[i].length); //let user to enter selection
                }
                System.out.println("\nBasic Book ");
                for (int i = 0; i < choices.length; i++) {
                    System.out.println("-" + customization[i][choices[i]]); //displays user selections
                }
                System.out.print("\nConfirm Customisation?\n");
                confirmSelection = inputValidation.CharValidation(); //user confirm customization
            }  //reloop if not confirmed

            Book book = new BasicBook();        //create BasicBook object
            
            book = new AddSize(book, choices[0]);   //add hardcover if choices[0] equals to 2
            
            book = new AddHardCover(book, choices[1]);       //Upsize if choices[1] equals to 2
            
            book = new AddCoverColor(book, choices[2]); //add page style of book
            
            book = new AddPageGSM(book, choices[3]);    //add calendar if choices[2] equals to 2

            book = new AddPageStyle(book, choices[4]); //add page style if choices[3] more than 1
            
            if (choices[5] == 2) {
                book = new AddCalendar(book);       //add calendar if choices[4] equals to 2
            }
            if (choices[6] == 2) {
                book = new AddPenHolder(book);      //add pen holder if choices[5] equals to 2
            }
            cart.addBook(book);                 // add book to cart
    
            System.out.print("\nDo You Want To Order Another Book?\n");  // ask if user wants to order another book
            cont = inputValidation.CharValidation();      //user enter input 
        }   //loop back if user wants to order another book

        //cart.showBooks();
        System.out.println("\n\n");
        Payment receipt = new Cash(cart, 100);
        System.out.println(receipt.generateReceipt());

    }
}
