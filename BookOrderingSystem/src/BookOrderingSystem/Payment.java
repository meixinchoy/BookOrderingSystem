/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookOrderingSystem;

import java.time.LocalDate;

/**
 *
 * @author kenne
 */
public abstract class Payment {
    private Cart cart;
    private static int invoicenum=1000;
    Payment(Cart cart) {
        this.cart = cart;
    }

    public double grandtotal() {
        return cart.getTotalPrice();
    }
    
    public String generateReceipt(){
        String receiptHeader=String.format("\n%22s \n%15s %s \n%21s %s\n %6s %27s\n %15s %18s",
                                "Notebooks", "Date: ", LocalDate.now(),
                                "Invoice No.:",invoicenum, "Item", "Price (RM)", "---------------", "----------");
        StringBuilder receipt = new StringBuilder(receiptHeader);
        receipt = receipt.append(cart.showBooks());
        receipt = receipt.append(String.format("%35s\n%29s%6.2f","======","Grand total (RM):",grandtotal()));
        invoicenum++;
        return receipt.toString();
    }
    
    
}
