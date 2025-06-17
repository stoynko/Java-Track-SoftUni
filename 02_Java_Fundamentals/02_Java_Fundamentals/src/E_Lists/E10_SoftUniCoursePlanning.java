package E_Lists;

import java.util.*;
import java.util.stream.*;

public class E10_SoftUniCoursePlanning {

/*You are tasked to help plan the next Programming Fundamentals course by keeping track of the lessons that will be included in the course,
as well as all the exercises for the lessons. On the first input line, you will receive the initial schedule of lessons and exercises that will be part of the next course,
separated by a comma and space. But before the course starts, there are some changes to be made.
Until you receive "course start", you will be given some commands to modify the course schedule. The possible commands are:

    •	Add:{lessonTitle} - add the lesson to the end of the schedule, if it does not exist
    •	Insert:{lessonTitle}:{index} - insert the lesson to the given index, if it does not exist
    •	Remove:{lessonTitle} - remove the lesson, if it exists
    •	Swap:{lessonTitle}:{lessonTitle} - change the place of the two lessons, if they exist
    •	Exercise:{lessonTitle} - add Exercise in the schedule right after the lesson index, if the lesson exists and there is no exercise already,
        in the following format: "{lessonTitle}-Exercise". If the lesson doesn't exist, add the lesson at the end of the course schedule, followed by the Exercise.

Each time you Swap or Remove a lesson, you should do the same with the Exercises, if there are any, which follow the lessons.

Input:
    •	On the first line -the initial schedule lessons -strings, separated by comma and space ", ".
    •	Until "course start", you will receive commands in the format described above.
Output:
    •	Print the whole course schedule, each lesson on a new line with its number(index) in the schedule:
        "{lesson index}.{lessonTitle}"
    •	Allowed working time / memory: 100ms / 16MB.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> lessons = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("course start")) {

            String[] actions = input.split(":");
            String action = actions[0];
            String lessonTitle = actions[1];

            switch (action) {
                case "Add" -> {
                    if (!isLessonScheduled(lessons, lessonTitle)) {
                        lessons.add(lessonTitle);
                    }
                }
                case "Insert" -> {
                    int index = Integer.parseInt(actions[2]);
                    if (!isLessonScheduled(lessons, lessonTitle) && index >= 0 && index <= lessons.size()) {
                        lessons.add(index, lessonTitle);
                    }
                }
                case "Remove" -> {
                    if (isLessonScheduled(lessons, lessonTitle)) {
                        lessons.remove(lessonTitle);
                        lessons.remove(lessonTitle + "-Exercise");
                    }
                }
                case "Swap" -> {
                    String lessonToSwapWith = actions[2];
                    if (isLessonScheduled(lessons, lessonTitle) && isLessonScheduled(lessons, lessonToSwapWith)) {
                        swapLessons(lessons, lessonTitle, lessonToSwapWith);
                    }
                }
                case "Exercise" -> {
                    if (isLessonScheduled(lessons, lessonTitle)) {
                        if (!lessons.contains(lessonTitle + "-Exercise")) {
                            int index = lessons.indexOf(lessonTitle);
                            lessons.add(index + 1, lessonTitle + "-Exercise");
                        }
                    } else {
                        lessons.add(lessonTitle);
                        lessons.add(lessonTitle + "-Exercise");
                    }
                }
            }
            input = scanner.nextLine();
        }
        int lessonIndex = 1;
        for (String lesson : lessons) {
            System.out.printf("%d.%s%n", lessonIndex, lesson);
            lessonIndex++;
        }
    }

    private static void swapLessons(List<String> lessons, String lessonTitle, String lessonToSwapWith) {
        int index1 = lessons.indexOf(lessonTitle);
        int index2 = lessons.indexOf(lessonToSwapWith);
        lessons.set(index1, lessonToSwapWith);
        lessons.set(index2, lessonTitle);
        if (lessons.contains(lessonTitle + "-Exercise")) {
            lessons.remove(lessonTitle + "-Exercise");
            lessons.add(index2 + 1, lessonTitle + "-Exercise");
        }
        if (lessons.contains(lessonToSwapWith + "-Exercise")) {
            lessons.remove(lessonToSwapWith + "-Exercise");
            lessons.add(index1 + 1, lessonToSwapWith + "-Exercise");
        }
    }

    private static boolean isLessonScheduled(List<String> lessons, String lessonTitle) {
        return lessons.contains(lessonTitle);
    }
}
