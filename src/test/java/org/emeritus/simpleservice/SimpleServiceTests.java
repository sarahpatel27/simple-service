package org.emeritus.simpleservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleServiceTests {
    @Test
    void addBookTest() {
       SimpleService simpleService = new SimpleService();
        Book bookExpected = new Book();
        String author = "J.R.R. Tolkein";
        String name = "The Hobbit";
        int id = 123;
        bookExpected.setBookId(id);
        bookExpected.setAuthor(author);
        bookExpected.setName(name);
        Book bookActual = simpleService.addBook(bookExpected);
        assertEquals(bookExpected, bookActual);
    }

    @Test
    void getBookTest() {
        SimpleService simpleService = new SimpleService();
        Book bookExpected = new Book();
        String author = "J.R.R. Tolkein";
        String name = "The Hobbit";
        int id = 123;
        bookExpected.setBookId(id);
        bookExpected.setAuthor(author);
        bookExpected.setName(name);
        Book bookActual = simpleService.addBook(bookExpected);
        bookActual = simpleService.getBook(bookExpected.getBookId());
        assertEquals(bookExpected.getBookId(), bookActual.getBookId());
    }
    
}
