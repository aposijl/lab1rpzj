# **Лабораторна робота 1**

<br>

## Авторка: ІО-23 Бадюлько Ірина

Для запуску лабораторної роботи не треба нічого вводити чи змінювати, значення матриць генеруються автоматично функцією **generateRandomMatrix**
```java
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
```

 проте можна власноруч змінити кількість рядків або колонок змінивши ці змінні
 
```java
private static final int rows = 5;
private static final int cols = 5;
```
