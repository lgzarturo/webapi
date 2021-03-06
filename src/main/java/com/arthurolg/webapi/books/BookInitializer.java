package com.arthurolg.webapi.books;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BookInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public BookInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        log.info("Starting book initializer sample data..");
        Faker faker = new Faker();
        for (int i = 0; i<10; i++) {
            Book book = new Book();
            book.setAuthor(faker.book().author());
            book.setTitle(faker.book().title());
            book.setIsbn(UUID.randomUUID().toString());
            bookRepository.save(book);
        }
        log.info(".. finished book initializer sample data");
    }
}
