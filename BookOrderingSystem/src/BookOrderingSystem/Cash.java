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
    
    public boolean sufficientCash(){
        return getChange() >= 0;
    }
    
    public double getChange(){
        return (cashReceived - super.grandtotal());
    }
}

