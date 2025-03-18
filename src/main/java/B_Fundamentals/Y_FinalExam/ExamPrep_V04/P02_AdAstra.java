package B_Fundamentals.Y_FinalExam.ExamPrep_V04;

import java.util.*;
import java.util.regex.*;

public class P02_AdAstra {

/*You are an astronaut who just embarked on a mission across the solar system. Since you will be in space for a long time, you have packed a lot of food with you. Create a program,
which helps you identify how much food you have left and gives you information about its expiration date.
On the first line of the input, you will be given a text string. You must extract the information about the food and calculate the total calories.
First, you must extract the food info. It will always follow the same pattern rules:
    •	It will be surrounded by "|" or "#" (only one of the two) in the following pattern: #{item name}#{expiration date}#{calories}#   or   |{item name}|{expiration date}|{calories}|
    •	The item name will contain only lowercase and uppercase letters and whitespace.
    •	The expiration date will always follow the pattern: "{day}/{month}/{year}", where the day, month, and year will be exactly two digits long.
    •	The calories will be an integer between 0-10000.
Calculate the total calories of all food items and then determine how many days you can last with the food you have. Keep in mind that you need 2000kcal a day.

Input / Constraints:
    •	You will receive a single string.
Output:
    •	First, print the number of days you will be able to last with the food you have: "You have food to last you for: {days} days!"
    •	The output for each food item should look like this: "Item: {item name}, Best before: {expiration date}, Nutrition: {calories}"*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([#|])(?<product>[A-za-z\\s]+)\\1(?<date>[\\d]{2,2}\\/[\\d]{2,2}\\/[\\d]{2,2})\\1(?<calories>[\\d]+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> products = new ArrayList<>();
        List<String> expirationDates = new ArrayList<>();
        List<Integer> calories = new ArrayList<>();

        while (matcher.find()) {

            String productName = matcher.group("product");
            String productExpiryDate = matcher.group("date");
            int productCalories = Integer.parseInt(matcher.group("calories"));
            products.add(productName);
            calories.add(productCalories);
            expirationDates.add(productExpiryDate);
        }
        int totalCalories = 0;
        for (int caloricValue : calories) {
            totalCalories += caloricValue;
        }
        System.out.printf("You have food to last you for: %d days!\n", totalCalories / 2000);
        for (int index = 0; index <= products.size() - 1; index++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d\n", products.get(index), expirationDates.get(index), calories.get(index));
        }
    }
}
