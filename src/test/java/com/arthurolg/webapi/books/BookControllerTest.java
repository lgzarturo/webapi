package com.arthurolg.webapi.books;

import com.fasterxml.jackson.core.JsonProcessingException;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
}
