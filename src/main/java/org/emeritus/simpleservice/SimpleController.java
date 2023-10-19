package org.emeritus.simpleservice;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private SimpleService simpleService;

    public SimpleController(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @GetMapping(path = "/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") final String id) {

        return new ResponseEntity<>(simpleService.getBook(Integer.parseInt(id)), HttpStatus.OK);
    }

    @PostMapping(path = "/book")
    public ResponseEntity<Book> createBook(@RequestBody final Book book) {
        return new ResponseEntity<>(simpleService.addBook(book), HttpStatus.CREATED);
    }
}
