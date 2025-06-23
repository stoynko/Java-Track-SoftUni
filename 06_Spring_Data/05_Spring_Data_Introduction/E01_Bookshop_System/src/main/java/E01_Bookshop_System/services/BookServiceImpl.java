package E01_Bookshop_System.services;

import E01_Bookshop_System.repositories.*;
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
