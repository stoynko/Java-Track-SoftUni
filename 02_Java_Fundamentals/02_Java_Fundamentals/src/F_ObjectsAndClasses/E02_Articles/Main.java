package F_ObjectsAndClasses.E02_Articles;

import java.util.*;

public class Main {

/*Create an article class with the following properties:
•	Title – a string
•	Content – a string
•	Author – a string

The class should have a constructor and the following methods:
•	Edit (new content) – change the old content with the new one
•	ChangeAuthor (new author) – change the author
•	Rename (new title) – change the title of the article
•	override ToString – print the article in the following format: "{title} - {content}: {author}"

Write a program that reads an article in the following format "{title}, {content}, {author}".
On the next line, you will get the number n. On the next n lines, you will get one of the following commands:
•	"Edit: {new content}"
•	"ChangeAuthor: {new author}"
•	"Rename: {new title}".

At the end, print the final article.*/

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String[] currentArticle = (scanner.nextLine()).split(", ");
        String title = currentArticle[0];
        String content = currentArticle[1];
        String author = currentArticle[2];

        Article article = new Article(title, content, author);
        int numberOfOperations = Integer.parseInt(scanner.nextLine());

        for (int operation = 1; operation <= numberOfOperations; operation++) {
            String input = scanner.nextLine();
            String[] actions = input.split(": ");
            String action = actions[0];
            switch (action) {
                case "Edit" -> {
                    String newContent = actions[1];
                    article.changeContent(newContent);
                }
                case "ChangeAuthor" -> {
                    String newAuthor = actions[1];
                    article.changeAuthor(newAuthor);
                }
                case "Rename" -> {
                    String newTitle = actions[1];
                    article.changeTitle(newTitle);
                }
            }
        }
        article.printArticle();
    }
}