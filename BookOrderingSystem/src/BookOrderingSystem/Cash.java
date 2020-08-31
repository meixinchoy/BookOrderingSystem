package BookOrderingSystem;

public class Cash extends Payment {

    private double cashReceived;

    public Cash(Cart cart) {
        super(cart);
        //this.cashReceived = cashReceived;
    }

    public void setCashReceived(double cashReceived) {
        this.cashReceived = cashReceived;
    }

    public boolean insufficientCash() {
        return getChange() < 0;
    }

    public double getChange() {
        return (cashReceived - super.grandtotal());
    }

    @Override
    public String generateReceipt() {
        String cashReceipt = String.format("\n%29s%6.2f\n%29s%6.2f\n%-15s\n", 
                "Cash Received (RM):", cashReceived, "Change (RM):", getChange(), "Paid with Cash");
        return super.generateReceipt() + cashReceipt;
    }
}
