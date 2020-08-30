/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookOrderingSystem;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author XM
 */
public class Cart {
   private List<Book> books = new ArrayList<Book>();
   private int itemCount=0;

   public void addBook(Book book){
      books.add(book);
      itemCount++;
   }

   public double getTotalPrice(){
      double totalPrice = 0.0;
      
      for (Book book : books) {
         totalPrice += book.getPrice();
      }		
      return totalPrice;
   }

   public String showBooks(){
      StringBuilder booklist = new StringBuilder(); 
      int i = 1;
      for (Book book : books) {
         booklist.append( "\n Book Item #"+i +"  ");
         booklist.append(book.getDesc()); 
         booklist.append(String.format("%35s\n%29s%6.2f\n","-----","Sub-total (RM):",book.getPrice()));
         i++;
      }		
      return booklist.toString();
   }
   
   public int getItemCount(){
       return itemCount;
   }
   
   
}
