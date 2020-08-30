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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kenne
 */
public class Cash extends Payment {

    private double cashReceived;

    public Cash(Cart cart, double cashReceived) {
        super(cart);
        this.cashReceived = cashReceived;
    }

    public void setCashReceived(double cashReceived) {
        this.cashReceived = cashReceived;
    }
    
    public boolean insufficientCash(){
        return getChange() < 0;
    }
    
    public double getChange(){
        return (cashReceived - super.grandtotal());
    }
    
    @Override
    public String generateReceipt(){
        String cashReceipt= String.format("\n%29s%6.2f\n%29s%6.2f\n\n%-15s","Cash Received(RM):",cashReceived,"Change(RM):",getChange(),"Paid with Cash");
        return super.generateReceipt()+cashReceipt;
    }
}

