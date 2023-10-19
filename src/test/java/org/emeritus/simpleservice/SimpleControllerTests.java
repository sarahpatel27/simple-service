package org.emeritus.simpleservice;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class SimpleControllerTests {
    @Autowired private WebApplicationContext context;


    @MockBean private SimpleService simpleServiceMock;

    protected MockMvc mvc;

    @BeforeEach
    public void setup() {
        this.mvc = MockMvcBuilders
            .webAppContextSetup(this.context)
            .build();
    }
    @Test
    void postEndPointTest() throws Exception {

        Book book = new Book();
        book.setAuthor("J.R.R. Tolkein");
        book.setName("The Hobbit");
        book.setBookId(123);

        when(simpleServiceMock.addBook(any(Book.class))).thenReturn(book);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(book);

        mvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json) 
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.bookId").value("123")) 
                .andExpect(jsonPath("$.author").value("J.R.R. Tolkein"))
                .andExpect(jsonPath("$.name").value("The Hobbit")); 

    }

    @Test
    void getEndPointTest() throws Exception {
        Book book = new Book();
        book.setAuthor("J.R.R. Tolkein");
        book.setName("The Hobbit");
        book.setBookId(123);

        when(simpleServiceMock.getBook(123)).thenReturn(book);

        mvc.perform(get("/book/123")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
