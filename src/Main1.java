import java.util.Random;
import java.util.Scanner;

class InvalidIndexException extends Exception {
    public InvalidIndexException(String message) {
        super(message);
    }
}

class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

class EmptyArrayException extends Exception {
    public EmptyArrayException(String message) {
        super(message);
    }
}

class ArrayGenerator {
    public static int[] generateArray() {
        Random rand = new Random();
        int size = rand.nextInt(30) + 1;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(31);
        }
        return array;
    }

    public static double getElementAtIndex(int[] array) throws InvalidIndexException, DivisionByZeroException, EmptyArrayException {
        if (array.length == 0) {
            throw new EmptyArrayException("Масив порожній");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть індекс елемента: ");
        int index = scanner.nextInt();

        if (index < 0 || index >= array.length) {
            throw new InvalidIndexException("Введений індекс виходить за межі масиву");
        }

        if (array[0] == 0) {
            throw new DivisionByZeroException("Перший елемент масиву дорівнює нулю, неможливо розділити на нуль");
        }

        return (double) array[index] / array[0];
    }
}

public class Main1 {
    public static void main(String[] args) {
        try {
            int[] array = ArrayGenerator.generateArray();
            double result = ArrayGenerator.getElementAtIndex(array);
            System.out.println("Результат: " + result);
        } catch (InvalidIndexException e) {
            System.out.println("Помилка з індексом: " + e.getMessage());
        } catch (DivisionByZeroException e) {
            System.out.println("Ділення на нуль: " + e.getMessage());
        } catch (EmptyArrayException e) {
            System.out.println("Порожній масив: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Невідома помилка: " + e.getMessage());
        }
    }
}
