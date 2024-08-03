package Tinkoff;

import java.util.Scanner;

public class NumberOfInterestingPare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int rows = arr.length;
        int cols = arr[0].length;
        int result = 0;

        int[][] newArr = new int[rows + 1][cols + 1];

        // Копируем исходный массив в новый массив
        for (int i = 0; i < rows; i++) {
            System.arraycopy(arr[i], 0, newArr[i], 0, cols);
        }

        // Вычисляем сумму элементов в каждой строке и столбце и записываем в последний столбец
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                rowSum += newArr[i][j];
            }
            newArr[i][cols] = rowSum;
        }

        for (int i = 0; i < cols; i++) {
            int colSum = 0;
            for (int j = 0; j < rows; j++) {
                colSum += newArr[j][i];
            }
            newArr[rows][i] = colSum;
        }

        //Проходимся по всей матрице и сверяем значения
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int rowSum = newArr[i][cols];
                int colSum = newArr[rows][j];
                int diff = Math.abs(rowSum - colSum);
                if (diff <= newArr[i][j]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
