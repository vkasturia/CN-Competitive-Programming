import java.util.Scanner;

public class WinningLottery {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int digits = in.nextInt();
        int[] number = new int[digits];
        number[0] = 1;
        int i = digits-1;
        sum = sum -1;

        while (sum >= 9 && i >= 1){
            number[i] = 9;
            sum = sum - 9;
            i--;
        }

        if (sum <= 9 && sum > 0){
            number[i] = sum;
            i--;
        }

        while (i >= 1){
            number[i] = 0;
            i--;
        }

        for (int j = 0; j < digits; j++){
            System.out.print(number[j]);
        }
    }
}
