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
public abstract class BookDecorator implements Book{
    private Book decoratedBook;

    public BookDecorator(Book decoratedBook) {
        this.decoratedBook = decoratedBook;
    }
    
    @Override
    public double getPrice(){
       return 15.00; 
    }
}
