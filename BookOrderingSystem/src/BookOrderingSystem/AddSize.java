/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookOrderingSystem;

/**
 *
 * @author kenne
 */
public class AddSize extends BookDecorator {

    private final double largeSizePrice = 5;
    private Book book;
    int choice;

    public AddSize(Book book, int choice) {
        super(book);
        this.book = book;
        this.choice = choice;
    }

    @Override
    public double getPrice() {
        if (choice != 1)
            return (book.getPrice() + largeSizePrice);
        return book.getPrice();
    }

    @Override
    public String getDesc() {
        if (choice == 2) {
            return book.getDesc() + String.format("%-15s%20.2f\n", "  -Large (A4)", largeSizePrice);
        }
        return book.getDesc() + String.format("%-15s%20s\n", "  -Normal (A5)", " - ");
    }

}
