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
public class Card extends Payment {

    private int cardNo;
    private int lastThreeDigits;

    public Card(Cart cart) {
        super(cart);
        //this.cardNo = cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
        lastThreeDigits = cardNo % 1000;
    }

    public boolean validCard() {
        int check1 = 0, check2 = 0;
        int[] ccNumber = new int[8];

        for (int i = 0, j = 10000000; i < ccNumber.length; i++, j /= 10) {
            ccNumber[i] = cardNo / j;
            cardNo %= j;
        }
        int checkDigit = ccNumber[7];

        for (int i = 1; i < ccNumber.length; i += 2) {
            check1 += ccNumber[i];

        }
        for (int i = 0; i < ccNumber.length; i += 2) {
            int x = 2 * ccNumber[i];
            int y = x / 10 + x % 10;
            check2 += y;
        }
        int Check = (check1 + check2) % 10;

        if (Check == 0) {
            //System.out.print("Valid card");
            return true;
        } else {
            //System.out.print("Invalid card");
            return false;
        }
    }

    @Override
    public String generateReceipt() {
        String cashReceipt = String.format("\n%-29s\n", "Paid with Card ending in " + lastThreeDigits);
        return super.generateReceipt() + cashReceipt;
    }
}
