package D_OOP.D_InterfacesAndAbstraction.E05_Telephony;

import java.util.*;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder browsingOutput = new StringBuilder();
        for (String url : urls) {
            boolean isValid = true;
            for (char currentChar : url.toCharArray()) {
                if (Character.isDigit(currentChar)) {
                    isValid = false;
                }
            }
            if (isValid) {
                browsingOutput.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            } else {
                browsingOutput.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return browsingOutput.toString();
    }

    @Override
    public String call() {
        StringBuilder callingOutput = new StringBuilder();
        boolean isValid = true;

        for (String phoneNumber : numbers) {
            for (char currentChar : phoneNumber.toCharArray()) {
                if (Character.isLetter(currentChar)) {
                    isValid = false;
                }
            }
            if (isValid) {
                callingOutput.append(String.format("Calling... %s", phoneNumber)).append(System.lineSeparator());
            } else {
                callingOutput.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return callingOutput.toString();
    }
}
