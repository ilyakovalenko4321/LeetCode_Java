import java.util.Scanner;

public class TinkoffTask1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long sum = sumFromHundredToN(n);
        System.out.println(sum);
    }

    public static long sumFromHundredToN(long n) {
        long nCount = n - 99;
        long first = 100;
        long last = n;
        long sum = nCount * (first + last) / 2;
        return sum;
    }
}
