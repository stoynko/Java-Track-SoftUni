package D_Java_OOP.A_WorkingWithAbstraction.E05_JediGalaxy.OOP_Refactoring;

import java.util.*;

public class Field {

    private int[][] starsField;

    public Field(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];
        this.starsField = new int[rows][columns];
        populateGalaxy(rows, columns, this.starsField);
    }

    public void populateGalaxy (int rows, int columns, int [][] starsField) {
        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                this.starsField[row][col] = value++;
            }
        }
    }

    public  boolean isWithinField(int positionX, int positionY) {
        return positionX >= 0 && positionX < starsField.length && positionY >= 0 && positionY < starsField[0].length;
    }

    public int getValue(int row, int column) {
        return this.starsField[row][column];
    }

    public int getFieldLength() {
        return this.starsField[0].length;
    }

    public void setValue (int row, int column, int newValue) {
        this.starsField[row][column] = newValue;
    }

}
