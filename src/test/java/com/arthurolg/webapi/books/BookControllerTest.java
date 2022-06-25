package com.arthurolg.webapi.books;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookService bookService;

    @Captor
    private ArgumentCaptor<BookRequest> argumentCaptor;

    @Test
    public void postingANewBookShouldCreateANewBookInDatabase() throws Exception {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setAuthor("Arturo");
        bookRequest.setTitle("Spring Boot Fundamentals");
        bookRequest.setIsbn("1244");
        when(bookService.createNewBook(argumentCaptor.capture())).thenReturn(1L);
        this.mockMvc.perform(
                post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookRequest))
        ).andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", "http://localhost/api/books/1"));
        assertThat(argumentCaptor.getValue().getAuthor(), is("Arturo"));
        assertThat(argumentCaptor.getValue().getTitle(), is("Spring Boot Fundamentals"));
        assertThat(argumentCaptor.getValue().getIsbn(), is("1244"));
    }

    @Test
    public void allBooksEndpointShouldReturnTwoBooks() throws Exception {
        when(bookService.getAllBooks()).thenReturn(
                List.of(
                        createBook(1L, "React 17", "Juan", "1124"),
                        createBook(2L, "Spring Boot", "Carlos", "18716")
                )
        );
        this.mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].title",is("Spring Boot")))
                .andExpect(jsonPath("$[1].author",is("Carlos")))
                .andExpect(jsonPath("$[1].isbn",is("18716")))
                .andExpect(jsonPath("$[1].id",is(2)));
    }

    @Test
    public void getBookWithIdOneShouldReturnABook() throws Exception {
        when(bookService.getBookById(1L)).thenReturn(createBook(1L, "React 17", "Juan", "1124"));
        this.mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title",is("React 17")))
                .andExpect(jsonPath("$.author",is("Juan")))
                .andExpect(jsonPath("$.isbn",is("1124")))
                .andExpect(jsonPath("$.id",is(1)));
    }

    @Test
    public void getBookWithIdTwoShouldReturnA404() throws Exception {
        when(bookService.getBookById(2L)).thenThrow(new BookNotFoundException("Book with id '2' not exists"));
        this.mockMvc.perform(get("/api/books/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateBookWithIdShouldUpdateTheBook() throws Exception {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setAuthor("Arturo");
        bookRequest.setTitle("Spring Boot Fundamentals");
        bookRequest.setIsbn("1244");

        when(bookService.updateBookById(eq(1L), argumentCaptor.capture()))
                .thenReturn(createBook(1L, "Spring Boot Fundamentals", "Arturo", "1244"));
        this.mockMvc.perform(put("/api/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookRequest))
        ).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title",is("Spring Boot Fundamentals")))
                .andExpect(jsonPath("$.author",is("Arturo")))
                .andExpect(jsonPath("$.isbn",is("1244")))
                .andExpect(jsonPath("$.id",is(1)));
        assertThat(argumentCaptor.getValue().getAuthor(), is("Arturo"));
        assertThat(argumentCaptor.getValue().getTitle(), is("Spring Boot Fundamentals"));
        assertThat(argumentCaptor.getValue().getIsbn(), is("1244"));
    }

    @Test
    public void updateBookWithUnkownIdShouldReturn404() throws Exception {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setAuthor("Arturo");
        bookRequest.setTitle("Spring Boot Fundamentals");
        bookRequest.setIsbn("1244");

        when(bookService.updateBookById(eq(42L), argumentCaptor.capture()))
                .thenThrow(new BookNotFoundException("Book with id '42' not exists"));

        this.mockMvc.perform(put("/api/books/42")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookRequest))
        ).andExpect(status().isNotFound());
    }

    private Book createBook(long id, String title, String author, String isbn) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setId(id);
        return book;
    }
}
