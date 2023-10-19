package org.emeritus.simpleservice;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class SimpleService {
    HashMap<Integer, Book> books;

    public SimpleService(){
        this.books = new HashMap<>();
    }

    public Book addBook(Book book){
        //returns book if add is successful, else returns null
        try{
           books.put(book.getBookId(),book);
            return book; 
        } catch (Exception e) {
            return null;
        }        
    }

    public Book getBook(int bookId){
        //returns the book if it is found, else returns null
        return books.get(bookId);
    }


}
