package oknoyts.bookshop_system.controllers;

import oknoyts.bookshop_system.repositories.*;
import oknoyts.bookshop_system.services.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private BookServiceImpl bookService;
    private AuthorServiceImpl authorService;
    private CategoryServiceImpl categoryService;

    @Override
    public void run(String... args) throws Exception {




    }
}
