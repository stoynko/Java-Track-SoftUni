package E01_Bookshop_System.controllers;

import E01_Bookshop_System.services.implementations.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.io.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private BookServiceImpl bookService;
    private final CategoryServiceImpl categoriesService;
    private final AuthorServiceImpl authorsService;
    private final BookServiceImpl booksService;

    public ConsoleRunner(CategoryServiceImpl categoryService, AuthorServiceImpl authorsService, BookServiceImpl booksService) {
        this.categoriesService = categoryService;
        this.authorsService = authorsService;
        this.booksService = booksService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws IOException {
        if (!this.categoriesService.areCategoriesImported()) {
            this.categoriesService.seedCategories();
        }
        if (!this.authorsService.areAuthorsImported()) {
            this.authorsService.seedAuthors();
        }
        if (!this.booksService.areBooksImported()) {
            this.booksService.seedBooks();
        }
    }
}
