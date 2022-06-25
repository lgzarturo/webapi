package com.arthurolg.webapi.books;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Long createNewBook(BookRequest bookRequest) {
        Book book = new Book();
        BeanUtils.copyProperties(bookRequest, book);
        book = bookRepository.save(book);
        return book.getId();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> requestedBook = bookRepository.findById(id);
        if (requestedBook.isEmpty()) {
            throw new BookNotFoundException(String.format("Book with id '%s' not exists", id));
        }
        return requestedBook.get();
    }

    @Transactional
    public Book updateBookById(Long id, BookRequest bookToUpdate) {
        Optional<Book> requestedBook = bookRepository.findById(id);
        if (requestedBook.isEmpty()) {
            throw new BookNotFoundException(String.format("Book with id '%s' not exists", id));
        }
        Book book = requestedBook.get();
        BeanUtils.copyProperties(bookToUpdate, book);
        return book;
    }
}
