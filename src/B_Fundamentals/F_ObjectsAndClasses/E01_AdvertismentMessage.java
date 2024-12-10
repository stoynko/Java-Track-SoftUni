package B_Fundamentals.F_ObjectsAndClasses;

import java.util.*;

public class E01_AdvertismentMessage {

/*Write a program that generates random fake advertisement messages to extol some product.
The messages must consist of 4 parts: laudatory phrase + event + author + city.
The format of the output message is: "{phrase} {event} {author} – {city}".
As an input, you take the number of messages to be generated. Print each random message on a separate line.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        int messagesToGenerate = Integer.parseInt(scanner.nextLine());
        Random random = new Random();

        for (int currentMessage = 1; currentMessage <= messagesToGenerate; currentMessage++) {

            int randomPhrase = random.nextInt(phrases.length - 1);
            int randomEvent = random.nextInt(events.length - 1);
            int randomAuthor = random.nextInt(authors.length - 1);
            int randomCity = random.nextInt(cities.length - 1);

            System.out.printf("%s %s %s - %s\n", phrases[randomPhrase], events[randomEvent], authors[randomAuthor], cities[randomCity]);
        }
    }
}
