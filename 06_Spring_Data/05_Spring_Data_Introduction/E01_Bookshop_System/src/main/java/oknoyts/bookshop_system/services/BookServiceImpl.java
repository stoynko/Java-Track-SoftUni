package oknoyts.bookshop_system.services;

import oknoyts.bookshop_system.entities.*;
import oknoyts.bookshop_system.repositories.*;
import org.springframework.stereotype.*;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void seedBooks() {

    }
}
