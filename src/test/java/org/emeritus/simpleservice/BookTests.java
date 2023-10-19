package org.emeritus.simpleservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTests {
    @Test
    void EntityTest() {
        Book book = new Book();
        String author = "J.R.R. Tolkein";
        String name = "The Hobbit";
        int id = 123;
        book.setBookId(id);
        book.setAuthor(author);
        book.setName(name);
        assertEquals(id, book.getBookId());
        assertEquals(author, book.getAuthor());
        assertEquals(name, book.getName());
    }
}
