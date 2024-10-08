import java.util.Random;

/* C5 = 1: виконується транспонування матриці
C7 = 2: тип елементів матриці – short.
C11 = 6: виконується сума найбільших елементів у стовпцях з парними номерами та найменших елементів у стовпцях з непарними номерами.*/

public class Main {
    // визначаємо розміри матриці
    private static final int rows = 5;
    private static final int cols = 5;

    public static void main(String[] args) {
        // ініціалізація матриці типу short за варіантом
        short[][] matrixB = new short[rows][cols];
        generateRandomMatrix(matrixB);
        System.out.println("матриця B:");
        printMatrix(matrixB);

        // транспонування матриці
        short[][] matrixC = transposeMatrix(matrixB);
        if (matrixC != null) {
            System.out.println("\nматриця C після транспонування:");
            printMatrix(matrixC);

            // обчислення суми найбільших елементів у парних стовпцях та найменших у непарних
            int result = sumMaxEvenMinOddColumns(matrixC);
            System.out.println("\nрезультат обчислення: " + result);
        } else {
            System.out.println("транспонування не вдалося через некоректну матрицю.");
        }
    }

    // метод для генерації випадкових значень у матриці
    private static void generateRandomMatrix(short[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("помилка: матриця не може бути пуста!");
            return;
        }
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (short) (random.nextInt(101)); // заповнюємо випадковими числами від 0 до 100
            }
        }
    }

    // метод для транспонування матриці
    private static short[][] transposeMatrix(short[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("помилка: неможливо транспонувати пусту матрицю.");
            return null; // повертаємо null у разі невдалої операції
        }
        short[][] transposed = new short[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j]; // міняємо місцями рядки та стовпці
            }
        }
        return transposed;
    }

    // метод для обчислення суми найбільших елементів у парних стовпцях та найменших елементів у непарних стовпцях
    private static int sumMaxEvenMinOddColumns(short[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("помилка: матриця пуста, неможливо виконати обчислення.");
            return 0;
        }
        int sum = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            if (j % 2 == 0) { // парний стовпець
                int max = findMaxInColumn(matrix, j);
                sum += max;
            } else { // непарний стовпець
                int min = findMinInColumn(matrix, j);
                sum += min;
            }
        }
        return sum;
    }

    // пошук максимального значення в стовпці
    private static int findMaxInColumn(short[][] matrix, int col) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("помилка: матриця пуста.");
            return Integer.MIN_VALUE;
        }
        int max = matrix[0][col];
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][col] > max) {
                max = matrix[i][col];
            }
        }
        return max;
    }

    // пошук мінімального значення в стовпці
    private static int findMinInColumn(short[][] matrix, int col) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("помилка: матриця пуста.");
            return Integer.MAX_VALUE;
        }
        int min = matrix[0][col];
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][col] < min) {
                min = matrix[i][col];
            }
        }
        return min;
    }

    // вивід матриці
    private static void printMatrix(short[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("матриця пуста.");
            return;
        }
        for (short[] row : matrix) {
            for (short element : row) {
                System.out.printf("%4d", element);
            }
            System.out.println();
        }
    }
}
