package com.example;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.controller.BookController;
import com.example.model.Book;
import com.example.service.BookService;

public class AppTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void testAddBook() throws Exception {

        Book newBook = new Book();
        newBook.setTitle("New Book");
        newBook.setAuthor("New Author");

        mockMvc.perform(post("/books/add")
                .param("title", "New Book")
                .param("author", "New Author"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/books/list"));

    }

    @Test
    public void testListBooks() throws Exception {
        // Mock data
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Book 1");
        book1.setAuthor("Author 1");

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Book 2");
        book2.setAuthor("Author 2");

        // Do not mock the behavior of BookService.getAllBooks()

        // Test listing books
        mockMvc.perform(get("/books/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("book-list"))
                .andExpect(model().attribute("books", hasSize(0)));
    }
}
