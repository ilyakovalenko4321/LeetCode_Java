package LeetCode;

public class CountSquareSubmatriceswithAllOnes {

    public static int countSquares(int[][] matrix) {
        int maskSize = 1; // Начинаем с маски 1x1
        int result = 0;
        boolean flag;

        while (maskSize <= matrix.length && maskSize <= matrix[0].length) {
            for (int i = 0; i <= matrix.length - maskSize; i++) {
                for (int j = 0; j <= matrix[0].length - maskSize; j++) {
                    result++;
                    flag = true;
                    // Обрабатываем элементы внутри маски
                    for (int x = i; x < i + maskSize  && flag; x++) {
                        for (int y = j; y < j + maskSize  && flag; y++) {
                            if(matrix[x][y] == 0){
                                result-=1;
                                flag = false;
                            }
                        }
                    }
                }
            }
            maskSize++; // Увеличиваем размер маски
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSquares(new int[][]{
                {1,0,1},
                {1,1,0},
                {1,1,0}
        }));
    }
}
