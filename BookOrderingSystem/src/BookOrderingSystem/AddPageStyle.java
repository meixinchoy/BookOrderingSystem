/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookOrderingSystem;

/**
 *
 * @author XM
 */
public class AddPageStyle extends BookDecorator {

    private final double linePrice = 2;
    private final double gridPrice = 3;
    private Book book;
    int choice;

    public AddPageStyle(Book book, int choice) {
        super(book);
        this.book = book;
        this.choice = choice;
    }

    @Override
    public double getPrice() {
        if (choice == 2) {
            return book.getPrice() + linePrice;
        }
        if (choice == 3) {
            return book.getPrice() + gridPrice;
        }
        return book.getPrice();
    }

    @Override
    public String getDesc() {
        if (choice == 2) {
            return book.getDesc() + String.format("%-15s%20.2f\n", "  -Lined Pages", linePrice);
        }
        if (choice == 3) {
            return book.getDesc() + String.format("%-15s%20.2f\n", "  -Grided Pages", gridPrice);
        }
        return book.getDesc();
    }
}
