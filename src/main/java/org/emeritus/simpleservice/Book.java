package org.emeritus.simpleservice;

import lombok.Getter;
import lombok.Setter;

public class Book {
    @Getter @Setter
    private int bookId;

    @Getter @Setter
    private String name;
    
    @Getter @Setter
    private String author;
}
