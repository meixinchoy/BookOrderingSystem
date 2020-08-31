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
public class BasicBook implements Book {

    private final double basicPrice = 15.00;

    @Override
    public double getPrice() {
        return basicPrice;
    }

    @Override
    public String getDesc() {
        return String.format("%20.2f\n", basicPrice);
    }

}
