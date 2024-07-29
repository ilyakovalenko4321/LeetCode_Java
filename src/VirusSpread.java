import java.util.Scanner;

public class VirusSpread {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long minute = scanner.nextLong();
        if(minute==1){
            System.out.println(minute);
        }else{
            System.out.println((minute-1)*4);
        }

    }

}
