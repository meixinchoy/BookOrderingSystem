package BookOrderingSystem;

/**
 *
 * @author XM
 */
public class AddPenHolder extends BookDecorator {

    private Book book;
    private final double penHolderPrice = 10;

    public AddPenHolder(Book book) {
        super(book);
        this.book = book;
    }

    @Override
    public double getPrice() {
        return (book.getPrice() + penHolderPrice);
    }

    @Override
    public String getDesc() {
        return book.getDesc() + String.format("%-15s%20.2f\n", "  -Pen Holder", penHolderPrice);
    }
}
