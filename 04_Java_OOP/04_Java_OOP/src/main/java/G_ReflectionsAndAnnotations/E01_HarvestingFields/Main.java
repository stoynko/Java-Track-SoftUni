package G_ReflectionsAndAnnotations.E01_HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {

/*You are given a RichSoilLand class with lots of fields (look at the provided skeleton). Like the good farmer you are, you must harvest them.
Harvesting means that you must print each field in a certain format (see output).

Input:
	You will receive a maximum of 100 lines with one of the following commands:
	•	private - print all private fields
	•	protected - print all protected fields
	•	public - print all public fields
	•	all - print ALL declared fields
	•	HARVEST - end the input

Output:
For each command, you must print the fields that have the given access modifier as described in the input section. The format in which the fields should be printed is:
"{access modifier} {field type} {field name}" */

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Class richSoilClass = RichSoilLand.class;

		while (!"HARVEST".equals(input)) {
			Field[] fields = richSoilClass.getDeclaredFields();
			if ("all".equals(input)) {
				Arrays.stream(richSoilClass.getDeclaredFields()).forEach(Main::print);
			} else {
				String finalInput = input;
				Arrays.stream(richSoilClass.getDeclaredFields()).filter(field -> matchesModifier(field, finalInput)).forEach(Main::print);
			}

			input = scanner.nextLine();
		}
	}
	public static boolean matchesModifier (Field field, String modifier) {
		int accessModifier = field.getModifiers();
		return switch (modifier) {
			case "private" -> Modifier.isPrivate(accessModifier);
			case "protected" -> Modifier.isProtected(accessModifier);
			case "public" -> Modifier.isPublic(accessModifier);
			default -> false;
		};
	}

	public static void print(Field field) {
		String accessModifier = Modifier.toString(field.getModifiers());
		System.out.printf("%s %s %s\n", accessModifier, field.getType().getSimpleName(), field.getName());
	}
}
